package lesson11_2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Spring implements Season {
    private int temperature;

    public Spring(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public void getDescription() {
        System.out.println("Я люблю весну, потому что это " + Constants.WARM_SEASON +
                " и средняя температура " + temperature + " градусов");

    }
}
