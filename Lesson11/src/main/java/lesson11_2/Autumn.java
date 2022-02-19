package lesson11_2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Autumn implements Season {
    private int temperature;

    public Autumn(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public void getDescription() {
        System.out.println("Я люблю осень, потому что это " + Constants.COLD_SEASON +
                " и средняя температура " + temperature + " градусов");
    }
}
