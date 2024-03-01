package org.example.jwtspringsecurity.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
@AllArgsConstructor

public class ErrorResponse {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final String details;
}
