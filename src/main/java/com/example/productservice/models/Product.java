package com.example.productservice.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{


    public Product(){}

    private String title;
    private Double price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;
    private String description;
    private String imgUrl;

    public Product(String title, Double price, String description, String imgUrl) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.imgUrl = imgUrl;
    }
}
