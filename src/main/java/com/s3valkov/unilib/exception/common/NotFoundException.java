package com.s3valkov.unilib.exception.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Object not found!")
public abstract class NotFoundException extends RuntimeException{
    protected int statusCode;

    public NotFoundException() {
        this.statusCode = HttpStatus.NOT_FOUND.value();
    }

    public NotFoundException(String message) {
        super(message);
        this.statusCode = HttpStatus.NOT_FOUND.value();
    }

    public int getStatusCode() {
        return statusCode;
    }
}