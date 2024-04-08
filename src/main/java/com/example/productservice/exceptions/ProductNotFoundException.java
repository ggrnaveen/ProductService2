package com.example.productservice.exceptions;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Component
public class ProductNotFoundException extends Exception{

   public ProductNotFoundException(String message){
        super(message);
   }
   public ProductNotFoundException(){

   }
}