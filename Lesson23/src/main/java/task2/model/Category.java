package task2.model;

import lombok.Data;

import java.util.List;

@Data
public class Category {
    private String id;
    private String name;
    private String imageName;
    private List<Product> productList;

    public Category(String name, String imageName) {
        this.name = name;
        this.imageName = imageName;
    }
}