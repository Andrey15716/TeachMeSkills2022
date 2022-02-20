package lesson11_4;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Apple extends Fruits {

    public Apple(double weight, double price) {
        super(weight, price);
    }
}
