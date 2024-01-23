package org.example.exceptionhandlingspringboot.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentNotFoundException extends RuntimeException{
    private String message;
}
