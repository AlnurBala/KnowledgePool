package com.example.knowpoolwebsite.handler;

import com.example.knowpoolwebsite.dto.ErrorDetails;
import com.example.knowpoolwebsite.exception.NotDataFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.management.InstanceNotFoundException;
import java.util.Date;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
@Slf4j
public class CustomerGlobalHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorDetails> customerNotFound(NotDataFound ex, WebRequest webRequest) {
        log.error("NotDataFound exception ", ex);
        var errorDetails = ErrorDetails.builder()
                .timestamp(new Date())
                .status(HttpStatus.NOT_FOUND.value())
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(ex.getMessage())
                .errorDetail(ex.toString())
                .path(webRequest.getDescription(false))
                .build();
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDetails> customerNull(MissingServletRequestParameterException ex, WebRequest webRequest) {
        System.out.println("MissingServletRequestParameterException");
        var errorDetails = ErrorDetails.builder()
                .timestamp(new Date())
                .status(BAD_REQUEST.value())
                .error(BAD_REQUEST.getReasonPhrase())
                .message("test")
                .errorDetail(ex.getMessage())
                .path(webRequest.getDescription(false))
                .build();
        return new ResponseEntity<>(errorDetails, BAD_REQUEST);
    }


    @ExceptionHandler
    public ResponseEntity<ErrorDetails> customerNull(InstanceNotFoundException ex, WebRequest webRequest) {
        System.out.println("InstanceNotFoundException");

        var errorDetails = ErrorDetails.builder()
                .timestamp(new Date())
                .status(BAD_REQUEST.value())
                .error(BAD_REQUEST.getReasonPhrase())
                .message("InstanceNotFoundException")
                .errorDetail(ex.getMessage())
                .path(webRequest.getDescription(false))
                .build();
        return new ResponseEntity<>(errorDetails, BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDetails> customerNull(IllegalArgumentException ex, WebRequest webRequest) {
        System.out.println("IllegalArgumentException");
        var errorDetails = ErrorDetails.builder()
                .timestamp(new Date())
                .status(BAD_REQUEST.value())
                .error(BAD_REQUEST.getReasonPhrase())
                .message("illegal")
                .errorDetail(ex.getMessage())
                .path(webRequest.getDescription(false))
                .build();
        return new ResponseEntity<>(errorDetails, BAD_REQUEST);
    }


    @ExceptionHandler
    public ResponseEntity<ErrorDetails> customerNull(MethodArgumentNotValidException ex, WebRequest webRequest) {
        System.out.println("RuntimeException");

        var errorDetails = ErrorDetails.builder()
                .timestamp(new Date())
                .status(BAD_REQUEST.value())
                .error(BAD_REQUEST.getReasonPhrase())
                .message(ex.getBindingResult().getFieldError().getField() + " is required ")
                .errorDetail(ex.toString())
                .path(webRequest.getDescription(false))
                .build();
        return new ResponseEntity<>(errorDetails, BAD_REQUEST);
    }


    @ExceptionHandler
    public ResponseEntity<ErrorDetails> customerNull(RuntimeException ex, WebRequest webRequest) {
        System.out.println("RuntimeException");
        var errorDetails = ErrorDetails.builder()
                .timestamp(new Date())
                .status(BAD_REQUEST.value())
                .error(BAD_REQUEST.getReasonPhrase())
                .message(ex.getMessage())
                .errorDetail(ex.toString())
                .path(webRequest.getDescription(false))
                .build();
        return new ResponseEntity<>(errorDetails, BAD_REQUEST);
    }


    @ExceptionHandler
    public ResponseEntity<ErrorDetails> customerException(Exception ex, WebRequest webRequest) {
        System.out.println("Exception");
        var errorDetails = ErrorDetails.builder()
                .timestamp(new Date())
                .status(BAD_REQUEST.value())
                .error(BAD_REQUEST.getReasonPhrase())
                .message(ex.getMessage())
                .errorDetail(ex.toString())
                .path(webRequest.getDescription(false))
                .build();
        return new ResponseEntity<>(errorDetails, BAD_REQUEST);
    }
}
