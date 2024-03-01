package org.example.jwtspringsecurity.exception;


public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }


}
