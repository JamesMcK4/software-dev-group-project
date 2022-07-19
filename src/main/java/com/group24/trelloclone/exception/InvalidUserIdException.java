package com.group24.trelloclone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidUserIdException extends Exception{
    public InvalidUserIdException() {
    }

    public InvalidUserIdException(String message){
        super(message);
    }
}
