package model;

import lombok.Data;

import java.util.List;

@Data
public class Category {
    private int id;
    private String name;
    private String imageName;
    private List<Product> productList;

    public Category(String name, String imageName,int id) {
        this.name = name;
        this.imageName = imageName;
        this.id= id;
    }
}