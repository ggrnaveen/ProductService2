package com.example.productservice.services;


import com.example.productservice.exceptions.CategoryNotFoundException;
import com.example.productservice.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {

    public Category getCategoryById(Long id) throws CategoryNotFoundException;

    public List<String> getAllCategories();
}
