package com.nilesh.seekjob.assignment.service;

import com.nilesh.seekjob.assignment.controller.params.CreateSuburbParam;
import com.nilesh.seekjob.assignment.controller.params.QuerySuburbParam;
import com.nilesh.seekjob.assignment.dao.SuburbRepository;
import com.nilesh.seekjob.assignment.model.Suburb;
import com.nilesh.seekjob.assignment.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@AllArgsConstructor
public class SuburbService {
    private SuburbRepository suburbRepository;

    public Suburb getSuburb(QuerySuburbParam param) {
       return  StringUtil.isNotBlank(param.getName()) ? suburbRepository.findByName(param.getName())
                : suburbRepository.findByPostcodes(param.getPostcode());
    }

    @Transactional
    public Suburb saveSuburb(CreateSuburbParam param){
            Suburb suburb = new Suburb(param.getName(), param.getPostcodes());
            return suburbRepository.save(suburb);
    }
}
