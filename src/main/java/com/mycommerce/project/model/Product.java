package com.mycommerce.project.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;
@Entity
@Setter@Getter
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    private float price;
    @ManyToOne
    Category category;

    public Product() {
    }
    public Product(String name, String content, float price) {
        this.name = name;
        this.content = content;
        this.price = price;
    }


}
