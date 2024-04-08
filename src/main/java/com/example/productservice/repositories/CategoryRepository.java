package com.example.productservice.repositories;

import com.example.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Optional<Category> findByTitle(String title);

    public Optional<Category> findById(Long id);

    @Query("SELECT c.title from Category c")
    public List<String> getAllCategories();
}
