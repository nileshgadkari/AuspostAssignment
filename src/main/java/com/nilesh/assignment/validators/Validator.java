package com.nilesh.assignment.validators;


import com.nilesh.assignment.controller.params.Param;

public interface Validator<T extends Param> {
    boolean isValid(T param);
    boolean canValidate(Object param);
    String getErrorMessage(T param);
}
