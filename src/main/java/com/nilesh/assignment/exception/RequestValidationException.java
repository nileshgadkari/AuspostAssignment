package com.nilesh.assignment.exception;

public class RequestValidationException extends RuntimeException{
    private String msg;
    public RequestValidationException(String msg) {
        super(msg);
    }
}
