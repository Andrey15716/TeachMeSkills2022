package lesson11_2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Winter implements Season {
    private int temperature;

    public Winter(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public void getDescription() {
        System.out.println("Я люблю зиму, потому что это " + Constants.COLD_SEASON +
                " и средняя температура " + temperature + " градусов");
    }
}
