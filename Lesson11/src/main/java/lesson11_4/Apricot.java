package lesson11_4;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Apricot extends Fruits {

    public Apricot(double weight, double price) {
        super(weight, price);
    }
}
