package com.mip.projectbuilder.errorhandler;

import com.mip.projectbuilder.entity.Client;
import com.mip.projectbuilder.exception.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> handleClientNotFoundError(ClientNotFoundException exception) {
        Map<String, String> error = new HashMap<>();
        error.put("errorCode", ClientNotFoundException.getErrorCode());
        error.put("errorMessage", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }
}
