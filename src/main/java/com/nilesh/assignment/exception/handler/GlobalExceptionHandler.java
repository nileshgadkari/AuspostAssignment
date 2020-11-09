package com.nilesh.assignment.exception.handler;

import com.nilesh.assignment.exception.RequestValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RequestValidationException.class)
    public ResponseEntity handleRequestValidationException(RequestValidationException rve){
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rve.getMessage());
    }
}
