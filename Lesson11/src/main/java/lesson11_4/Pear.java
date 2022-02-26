package lesson11_4;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pear extends Fruit {

    public Pear(double weight, double price) {
        super(weight, price);
    }
}
