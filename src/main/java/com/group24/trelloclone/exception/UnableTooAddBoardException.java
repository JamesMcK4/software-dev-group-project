package com.group24.trelloclone.exception;

public class UnableTooAddBoardException extends Exception{

    public UnableTooAddBoardException() {
        super("Error happens. Cannot add board to workspace!");
    }

    public UnableTooAddBoardException(String message) {
        super(message);
    }

}
