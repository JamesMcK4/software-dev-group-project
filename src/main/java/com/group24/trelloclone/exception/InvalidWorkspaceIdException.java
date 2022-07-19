package com.group24.trelloclone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidWorkspaceIdException extends Exception{

    public InvalidWorkspaceIdException() {
    }

    public InvalidWorkspaceIdException(String message) {
        super(message);
    }

}
