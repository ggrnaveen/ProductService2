package com.example.productservice.controllers;


import com.example.productservice.exceptions.CategoryNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.services.CategoryService;
import com.example.productservice.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("category/{id}")
    public Category getCategoryById(@PathVariable("id") Long id) throws CategoryNotFoundException {

        Category category= categoryService.getCategoryById(id);

        System.out.println(category);

        return category;

    }

    @GetMapping("/categories")
    public List<String> getAllCategories(){

        List<String> categories = categoryService.getAllCategories();


        return categories;
    }
}
