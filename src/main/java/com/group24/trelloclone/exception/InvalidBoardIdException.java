package com.group24.trelloclone.exception;

public class InvalidBoardIdException extends Exception {

    public InvalidBoardIdException() {
        super("Invalid Board Id");
    }

    public InvalidBoardIdException(String message) {
        super(message);
    }

}
