package com.s3valkov.unilib.exception;

import com.s3valkov.unilib.exception.common.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Language not found!")
public class LanguageNotFoundException extends NotFoundException {

    public LanguageNotFoundException(String message) {
        super(message);
    }

    public int getStatusCode() {
        return statusCode;
    }
}