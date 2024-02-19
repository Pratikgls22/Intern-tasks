package org.example.swaggeruispringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
    {
        Map<String,String> resp = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((objectError -> {
            String filedName = (objectError).getField();
            String message =objectError.getDefaultMessage();
            resp.put(filedName,message);
        }));
        return new ResponseEntity<Map<String,String>>(resp, HttpStatus.NOT_ACCEPTABLE);
    }

}
