package com.s3valkov.unilib.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Email already exists.")
public class UserAlreadyExistsException extends RuntimeException{
    protected int statusCode;

    public UserAlreadyExistsException() {
        this.statusCode = HttpStatus.BAD_REQUEST.value();
    }

    public UserAlreadyExistsException(String message) {
        super(message);
        this.statusCode = HttpStatus.BAD_REQUEST.value();
    }

    public int getStatusCode() {
        return statusCode;
    }
}