package com.vaibhao.vk.digitalslambook.exception;

import com.vaibhao.vk.digitalslambook.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .data(null)
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<java.util.Map<String, String>>> handleValidationException(org.springframework.web.bind.MethodArgumentNotValidException ex) {
        java.util.Map<String, String> errors = new java.util.HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        ApiResponse<java.util.Map<String, String>> response = ApiResponse.<java.util.Map<String, String>>builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Validation failed")
                .data(errors)
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGlobalException(Exception ex) {
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .data(null)
                .build();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
