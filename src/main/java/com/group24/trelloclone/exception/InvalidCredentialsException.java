package com.group24.trelloclone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class InvalidCredentialsException extends Exception {

    public InvalidCredentialsException() {
        super("Invalid Credential!");
    }

    public InvalidCredentialsException(String message) {
        super(message);
    }
}
