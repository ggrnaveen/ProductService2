package com.example.productservice.controllers;


import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.services.FakeStoreProductService;
import com.example.productservice.services.ProductService;
import com.example.productservice.services.SelfProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    ProductService productService;

    public ProductController( ProductService productService) {
        this.productService = productService;
    }



    /*   1. Get Single Product using ID    */

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException{


//        System.out.println("getting product");


        Product product = productService.getProductById(id);


      return ResponseEntity.ok(product) ;

    }



    /*   2. Get All Products    */



    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() throws ProductNotFoundException{

        List<Product> productList = productService.getAllProducts();

        if(productList==null){
            throw new ProductNotFoundException();
        }

        return ResponseEntity.ok(productList);
    }

    @PostMapping("/product")
    public  ResponseEntity<Product> addNewProduct(@RequestBody FakeStoreProductDto productDto){

       // productService.addNewProduct();



       Product product= productService.addNewProduct(productDto);

        return ResponseEntity.ok(product);
    }


    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException {

        Product product = productService.deleteProduct(id);

        return ResponseEntity.ok("The product with ID "+id+" is deleted");

    }

    @PatchMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody FakeStoreProductDto productDto) throws ProductNotFoundException {

       Product product =  productService.updateProduct(id, productDto);




        return ResponseEntity.ok(product);

    }



}
