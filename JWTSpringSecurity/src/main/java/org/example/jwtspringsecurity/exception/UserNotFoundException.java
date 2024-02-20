package org.example.jwtspringsecurity.exception;

import org.example.jwtspringsecurity.model.User;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
