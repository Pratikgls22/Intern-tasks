package org.example.jwtspringsecurity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
@ControllerAdvice
public class GlobalHandleException extends Exception{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
    {
        Map<String,String> stringMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->{
            String fieldName = error.getField();
            String message = error.getDefaultMessage();
            stringMap.put(fieldName,message);
        });
        return new ResponseEntity<>(stringMap,HttpStatus.CREATED);
    }
}
