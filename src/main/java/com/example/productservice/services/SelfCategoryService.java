package com.example.productservice.services;


import com.example.productservice.exceptions.CategoryNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class SelfCategoryService implements CategoryService{


    CategoryRepository categoryRepository;

    public SelfCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategoryById(Long id) throws CategoryNotFoundException {

        Optional<Category> categoryOptional = categoryRepository.findById(id);

      if(categoryOptional.isEmpty())
          throw new CategoryNotFoundException("The category with ID "+ id+ " not found");

      return categoryOptional.get();


    }


    public List<String> getAllCategories(){

        List<String> categories = categoryRepository.getAllCategories();

        return categories;
    }


}
