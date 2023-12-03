package com.leanplatformtechnologies.assignment.rest;

import com.leanplatformtechnologies.assignment.exceptionhandling.ErrorResponse;
import com.leanplatformtechnologies.assignment.exceptionhandling.GlobalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    //add exception handling code
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(GlobalException exc){

        //create a error response
        ErrorResponse error = new ErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return response entity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exc){
        //create a error response
        ErrorResponse error = new ErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return response entity
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
