package entities;

import lombok.EqualsAndHashCode;
import lombok.Data;

@EqualsAndHashCode(callSuper = true)
@Data
public class Category extends BaseEntity {
    private String name;
    private String imageName;

    public Category(int id, String name, String imageName) {
        super(id);
        this.name = name;
        this.imageName = imageName;
    }
}