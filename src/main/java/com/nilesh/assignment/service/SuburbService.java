package com.nilesh.assignment.service;

import com.nilesh.assignment.dao.SuburbRepository;
import com.nilesh.assignment.model.Suburb;
import com.nilesh.assignment.util.StringUtil;
import com.nilesh.assignment.controller.params.CreateSuburbParam;
import com.nilesh.assignment.controller.params.QuerySuburbParam;
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
