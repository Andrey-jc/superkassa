package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class NoSuchException {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity handleException(NoSuchElementException exception) {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(exception.getMessage());
    }
}
