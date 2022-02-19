package lesson11_4;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pear extends Fruits {
    private double price;
    private double totalPricePerWeight;

    public Pear(double weight, double price) {
        super(weight);
        this.price = price;
    }

    @Override
    public void getFruitPrice() {
        totalPricePerWeight = price * getWeight() / 1000;
        System.out.println("Цена за " + getWeight() + " грамм груш составляет " + totalPricePerWeight + " рубля");
    }
}
