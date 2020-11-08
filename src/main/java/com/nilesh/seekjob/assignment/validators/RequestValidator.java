package com.nilesh.seekjob.assignment.validators;

import com.nilesh.seekjob.assignment.controller.params.Param;
import com.nilesh.seekjob.assignment.exception.RequestValidationException;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class RequestValidator<T extends Param, V extends  Validator<T>>{

    private List<V> validators;

    public boolean validate(T param){
        val v = validators.stream()
                .filter(validator -> validator.canValidate(param))
                .filter(validator -> !validator.isValid(param))
                .findAny();
        if(v.isPresent()){
            throw new RequestValidationException(v.get().getErrorMessage(param));
        }
        return true;
    }
}
