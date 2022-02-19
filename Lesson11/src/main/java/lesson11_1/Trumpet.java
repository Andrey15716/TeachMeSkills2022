package lesson11_1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Trumpet implements Instrument {
    private int diameter;

    public Trumpet(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public void play() {
        System.out.println("Играет труба с диаметром " + diameter);
    }
}
