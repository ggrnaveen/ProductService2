package com.example.productservice.exceptions;

import org.springframework.stereotype.Component;

@Component
public class CategoryNotFoundException extends Exception{

   public CategoryNotFoundException(String message){
        super(message);
   }
   public CategoryNotFoundException(){

   }
}