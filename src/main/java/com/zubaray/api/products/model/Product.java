package com.zubaray.api.products.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private Double price;
    private String brand;
    @Field("category_id")
    private Long categoryId;

    public Product() {}

    public Product(String name, Double price, String brand, Long categoryId) {
        super();
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.categoryId = categoryId;
    }

    public boolean isValid() {
        if(this.name == null || this.name.isEmpty()){
            return false;
        }
        if(this.price == null || this.price.isNaN()) {
            return false;
        }
        if(this.brand == null || this.brand.isEmpty()) {
            return false;
        }
        return this.categoryId != null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", brand=" + brand + ", categoryId=" + categoryId + "]";
    }
}
