package com.example.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;






@Getter
@Setter
@MappedSuperclass
public class BaseModel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createAt;
    private Date lastUpdatedAt;
    private boolean isDeleted;


}
