package com.group24.trelloclone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class EmptyPasswordException extends Exception{

    public EmptyPasswordException() {
    }

    public EmptyPasswordException(String message) {
        super(message);
    }
}
