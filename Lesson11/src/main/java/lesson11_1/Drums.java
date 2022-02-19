package lesson11_1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Drums implements Instrument {
    private int size;

    public Drums(int size) {
        this.size = size;
    }

    @Override
    public void play() {
        System.out.println("Играют барабаны с размером " + size);
    }
}
