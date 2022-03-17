package com.mycommerce.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Category() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(name);
        return sb.toString();
    }
}
