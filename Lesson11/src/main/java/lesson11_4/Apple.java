package lesson11_4;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Apple extends Fruit {

    public Apple(double weight, double price) {
        super(weight, price);
    }
}
