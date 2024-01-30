package org.example.testcasesspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgNotValidException(MethodArgumentNotValidException ex)
   {
       Map<String,String> resp = new HashMap<>();
       ex.getBindingResult().getAllErrors().forEach((objectError -> {
           String field = ((FieldError) objectError).getField();
           String message = objectError.getDefaultMessage();
           resp.put(field,message);
       }));
        return new ResponseEntity<Map<String,String>>(resp,HttpStatus.NOT_ACCEPTABLE);
   }
}
