package lesson11_4;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Type;

@Getter
@Setter
public abstract class Fruit {
    private double weight;
    private double price;
    private double totalPricePerWeight;

    public Fruit(double weight, double price) {
        this.weight = weight;
        this.price = price;
    }

    public final void printManufacturerInfo() {
        System.out.print("Made in Belarus");
    }

    public double getFruitPrice() {
        return totalPricePerWeight = price * getWeight() / 1000;
    }
}

