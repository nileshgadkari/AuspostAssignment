package com.nilesh.assignment.service;

import com.nilesh.assignment.controller.params.CreateSuburbParam;
import com.nilesh.assignment.controller.params.QuerySuburbParam;
import com.nilesh.assignment.dao.SuburbRepository;
import com.nilesh.assignment.model.Suburb;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@SpringBootTest
class SuburbServiceTest {

    @Mock
    private SuburbRepository suburbRepository;
    @Mock
    private QuerySuburbParam querySuburbParam;
    @Mock
    private Suburb suburb;
    @Mock
    private CreateSuburbParam createSuburbParam;
    @InjectMocks
    private SuburbService suburbService;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Test suburb is retrieved when suburb exists")
    void getSuburbWhenSuburbExists() {
        when(querySuburbParam.getName()).thenReturn("SampleSuburb");
        when(suburb.getName()).thenReturn("SampleSuburb");
        when(suburbRepository.findByName(anyString())).thenReturn(suburb);
        Suburb retrievedSuburb = suburbService.getSuburb(querySuburbParam);
        Assertions.assertEquals(suburb, retrievedSuburb);
    }

    @Test
    @DisplayName("Test service does not throw exception when suburb does not exists")
    void getSuburbWhenSuburbDoesNotExists() {
        when(querySuburbParam.getName()).thenReturn("SampleSuburb");
        when(suburbRepository.findByName(anyString())).thenReturn(null);
        Suburb retrievedSuburb = suburbService.getSuburb(querySuburbParam);
        Assertions.assertNull(retrievedSuburb);
    }

   @Test
   @DisplayName("Test suburb is saved")
    void saveSuburbIsSuccessful() {
        when(createSuburbParam.getName()).thenReturn("SampleSuburb");
        when(createSuburbParam.getPostcodes()).thenReturn(List.of("123","456"));
        when(suburbRepository.save(any(Suburb.class))).thenReturn(suburb);
        Suburb savedSuburb = suburbService.saveSuburb(createSuburbParam);
        Assertions.assertNotNull(savedSuburb);
    }

    @Test
    @DisplayName("Test exception is propagated if error occurs when saving suburb")
    void saveSuburbIsUnsuccessful() {
        when(createSuburbParam.getName()).thenReturn("SampleSuburb");
        when(createSuburbParam.getPostcodes()).thenReturn(List.of("123","456"));
        doThrow(new RuntimeException()).when(suburbRepository).save(any(Suburb.class));
        Assertions.assertThrows(RuntimeException.class, () -> {
            suburbService.saveSuburb(createSuburbParam);
        });
    }
}
