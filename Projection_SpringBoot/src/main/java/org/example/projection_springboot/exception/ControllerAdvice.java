package org.example.projection_springboot.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.projection_springboot.dto.ApiResponse;
import org.example.projection_springboot.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleException(HttpServletRequest request,Exception e)
    {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        ErrorDTO errorDTO = new ErrorDTO(httpStatus,new Date().getTime(),
                "Something went wrong",request.getServletPath());

        ApiResponse apiResponse = new ApiResponse(httpStatus, e.getMessage(),errorDTO);
        log.error("handleException ::" , e);
        return ResponseEntity.status(httpStatus).body(apiResponse);
    }


    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse> handleCustomException(HttpServletRequest request, CustomException e)
    {
        HttpStatus httpStatus = e.getHttpStatus();

        ErrorDTO errorDTO = new ErrorDTO(httpStatus, new Date().getTime(),
                e.getMessage(),request.getServletPath());
        errorDTO.setError(e.getMessage());
        errorDTO.setMessage(httpStatus.name());

        ApiResponse apiResponse = new ApiResponse(httpStatus,e.getMessage(),errorDTO);
        log.error("handleCustomException :: ",e);
        return ResponseEntity.status(httpStatus).body(apiResponse);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiResponse> handleAccessDeniedException(HttpServletRequest req, AccessDeniedException e)
    {
        HttpStatus httpStatus = HttpStatus.FORBIDDEN;
        ErrorDTO errorDTO = new ErrorDTO(httpStatus, new Date().getTime(), e.getMessage(), req.getServletPath());
        errorDTO.setError(e.getMessage());
        errorDTO.setMessage(httpStatus.name());
        ApiResponse apiResponse = new ApiResponse(httpStatus, e.getMessage(), errorDTO);
        log.error("handleAccessDeniedException :: ", e);
        return ResponseEntity.status(httpStatus).body(apiResponse);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse> handleIllegalArgumentException(HttpServletRequest req,
                                                                      IllegalArgumentException e)
    {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ErrorDTO errorDTO = new ErrorDTO(httpStatus, new Date().getTime(),
                "Something went wrong", req.getServletPath());
        ApiResponse apiResponse = new ApiResponse(httpStatus, e.getMessage(), errorDTO);
        log.error("handleIllegalArgumentException :: ", e);
        return ResponseEntity.status(httpStatus).body(apiResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(HttpServletRequest req,
                                                                             MethodArgumentNotValidException e)
    {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        List<String> errorMessages = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach(error -> errorMessages.add(error.getDefaultMessage()));
        ErrorDTO errorDTO = new ErrorDTO(httpStatus, new Date().getTime(), httpStatus.name(), req.getServletPath(),
                errorMessages);
        ApiResponse apiResponse = new ApiResponse(httpStatus, httpStatus.name(), errorDTO);
        log.error("handleMethodArgumentNotValidException :: ", e);
        return ResponseEntity.status(httpStatus).body(apiResponse);
    }
}
