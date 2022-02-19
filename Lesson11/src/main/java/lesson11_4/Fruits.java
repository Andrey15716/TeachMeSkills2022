package lesson11_4;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Fruits {
    private double weight;

    public Fruits(double weight) {
        this.weight = weight;
    }

    public final void printManufacturerInfo() {
        System.out.print("Made in Belarus");
    }

    public abstract void getFruitPrice();
}

