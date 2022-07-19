package com.group24.trelloclone.exception;

public class InvalidTaskIdException extends Exception{

    public InvalidTaskIdException() {
        super("Invalid Task Id!");
    }

    public InvalidTaskIdException(String message) {
        super(message);
    }

}
