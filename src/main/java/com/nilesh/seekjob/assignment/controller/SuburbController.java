package com.nilesh.seekjob.assignment.controller;

import com.nilesh.seekjob.assignment.controller.params.CreateSuburbParam;
import com.nilesh.seekjob.assignment.controller.params.QuerySuburbParam;
import com.nilesh.seekjob.assignment.exception.RequestValidationException;
import com.nilesh.seekjob.assignment.model.Suburb;
import com.nilesh.seekjob.assignment.service.SuburbService;
import com.nilesh.seekjob.assignment.validators.RequestValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class SuburbController {
    private RequestValidator requestValidator;
    private SuburbService suburbService;

    @GetMapping("v{version}/suburb")
    public ResponseEntity getSuburb(QuerySuburbParam querySuburbParam) {
        try {
            requestValidator.validate(querySuburbParam);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(suburbService.getSuburb(querySuburbParam));
        }catch(RequestValidationException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request");
        }
    }

    @PostMapping("v{version}/suburb")
    @PreAuthorize("#oauth2.hasScope('bar')")
    public ResponseEntity<Suburb> saveSuburb(@RequestBody CreateSuburbParam createSuburbParam) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(suburbService.saveSuburb(createSuburbParam));
    }
}
