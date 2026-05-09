package com.example.baurzhankyzy_aruzhan.AruzhanException;

import com.example.baurzhankyzy_aruzhan.AruzhanDto.BaurzhankyzyAruzhanErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class BaurzhankyzyAruzhanGlobalExceptionHandler {

    // Обработка ошибки "Ресурс не найден"
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<BaurzhankyzyAruzhanErrorResponse> handleRuntimeException(RuntimeException ex, WebRequest request) {
        BaurzhankyzyAruzhanErrorResponse error = new BaurzhankyzyAruzhanErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Resource Not Found",
                ex.getMessage() + " (Handled by Baurzhankyzy Aruzhan)",
                request.getDescription(false)
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Обработка всех остальных непредвиденных ошибок
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaurzhankyzyAruzhanErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
        BaurzhankyzyAruzhanErrorResponse error = new BaurzhankyzyAruzhanErrorResponse(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                "An unexpected error occurred. Please contact Admin Aruzhan.",
                request.getDescription(false)
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}