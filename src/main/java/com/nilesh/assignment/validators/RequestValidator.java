package com.nilesh.assignment.validators;

import com.nilesh.assignment.exception.RequestValidationException;
import com.nilesh.assignment.controller.params.Param;
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
