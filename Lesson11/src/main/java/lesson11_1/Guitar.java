package lesson11_1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Guitar implements Instrument {
    private int guitarString;

    public Guitar(int guitarString) {
        this.guitarString = guitarString;
    }

    @Override
    public void play() {
        System.out.println("Играет гитара с " + guitarString + " струнами");
    }
}
