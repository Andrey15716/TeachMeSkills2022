package lesson11_3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Clothes {
    private ClothesSize size;
    private String color;
    private int price;

    public Clothes(ClothesSize size, String color, int price) {
        this.size = size;
        this.color = color;
        this.price = price;
    }
}
