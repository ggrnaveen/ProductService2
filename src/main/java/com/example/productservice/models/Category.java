package com.example.productservice.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@ToString
public class Category extends BaseModel {


    private String title;

    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    private List<Product> productList;


    public Category() {

    }

    public Category(String title){
        this.title=title;
    }


    public void addProduct(Product product){

        if(productList.isEmpty()){
            productList = new ArrayList<>();
        }
        productList.add(product);
    }
}
