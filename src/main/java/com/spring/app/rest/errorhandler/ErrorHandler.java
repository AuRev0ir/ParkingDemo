package com.spring.app.rest.errorhandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorHandler {

    // Передалать, когда появятся Exception
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handlerCreateEntityException(RuntimeException ex) {

        Map<String, java.lang.Object> errorMsg = new HashMap<>();

        errorMsg .put("error", "Entity Not Found");
        errorMsg .put("message", ex.getMessage());
        errorMsg .put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMsg);

    }
}
