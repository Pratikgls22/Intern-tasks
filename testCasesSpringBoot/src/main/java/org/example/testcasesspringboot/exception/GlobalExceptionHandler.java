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
    public ResponseEntity<Map<String,Object>> handleMethodArgNotValidException(MethodArgumentNotValidException ex)
   {
       Map<String,Object> resp = new HashMap<>();
       ex.getBindingResult().getAllErrors().forEach((objectError -> {
           String field = ((FieldError) objectError).getField();
           Object message = objectError.getDefaultMessage();
           resp.put(field,message);
       }));
        return new ResponseEntity<>(resp,HttpStatus.NOT_ACCEPTABLE);
   }
}
