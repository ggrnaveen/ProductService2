package com.example.productservice.exceptions;


import com.example.productservice.models.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> ProductHandlerException(ProductNotFoundException exception){

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> CategoryHandlerException(CategoryNotFoundException exception){

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }


}
