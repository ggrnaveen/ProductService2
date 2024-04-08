package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundException;

    List<Product> getAllProducts() throws ProductNotFoundException;

    Product addNewProduct(FakeStoreProductDto productDto);
    
    

    void test();

    Product deleteProduct(Long id) throws ProductNotFoundException;

    Product updateProduct(Long id, FakeStoreProductDto dto) throws ProductNotFoundException;
}
