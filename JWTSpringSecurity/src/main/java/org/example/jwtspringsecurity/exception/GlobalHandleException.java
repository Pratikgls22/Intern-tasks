package org.example.jwtspringsecurity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

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
        return new ResponseEntity<>(stringMap,HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException e, WebRequest webRequest)
    {
         UserException userException = new UserException(
                          e.getMessage(),
                          e.getCause(),
                 HttpStatus.NOT_FOUND,
                 webRequest.getDescription(false)
                 );
         return new ResponseEntity<>(userException,HttpStatus.NOT_FOUND);
    }
}
