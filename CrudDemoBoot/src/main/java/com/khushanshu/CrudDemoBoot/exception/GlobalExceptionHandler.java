package com.khushanshu.CrudDemoBoot.exception;

import com.khushanshu.CrudDemoBoot.dto.ExceptionResponseDto;
import com.khushanshu.CrudDemoBoot.dto.ValidationExceptionResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ValidationExceptionResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request){

        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->fieldErrors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ValidationExceptionResponseDto( LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                        "Validation Failed",
                request.getRequestURI(),fieldErrors)
                )
        ;
    }




    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ExceptionResponseDto> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponseDto( LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()));
    }

    @ExceptionHandler(DuplicateResourceException.class)
    ResponseEntity<ExceptionResponseDto> handleDuplicateResourceException(DuplicateResourceException ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionResponseDto( LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()));
    }


    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<ExceptionResponseDto> handleRuntimeException(RuntimeException ex, HttpServletRequest request){
        return ResponseEntity.internalServerError().body(new ExceptionResponseDto( LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()));
    }


    @ExceptionHandler(Exception.class)
    ResponseEntity<ExceptionResponseDto> handleGenericException(Exception ex, HttpServletRequest request){
         return ResponseEntity.internalServerError().body(new ExceptionResponseDto( LocalDateTime.now(),
                 HttpStatus.INTERNAL_SERVER_ERROR.value(),
                 HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                 ex.getMessage(),
                 request.getRequestURI()));
    }
}
