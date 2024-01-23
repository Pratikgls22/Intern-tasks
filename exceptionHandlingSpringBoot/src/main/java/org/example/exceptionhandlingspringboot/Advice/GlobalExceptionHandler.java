package org.example.exceptionhandlingspringboot.Advice;

import org.example.exceptionhandlingspringboot.exception.StudentNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public Map<String,String> handleStudentException(StudentNotFoundException e){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("Error Message is ", e.getMessage());
        return errorMap;
    }
}
