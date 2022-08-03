package by.teachmeskills.eshop.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Product extends BaseEntity {
    private int categoryId;
    private String name;
    private String description;
    private int price;
    private String imageName;

    public Product(int id, int categoryId, String name, String description, int price, String imageName) {
        super(id);
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageName = imageName;
    }

    public Product(int categoryId, String name, String description, int price, String imageName) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageName = imageName;
    }
}