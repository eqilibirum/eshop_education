package com.denys.main.exceptions;

public class NotUniqueLoginException extends DBException {

    public NotUniqueLoginException(String message) {
        super(message);
    }

    public NotUniqueLoginException(String message, Throwable cause){
        super(message, cause);
    }

}
