package lesson11_2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Summer implements Season {
    private int temperature;

    public Summer(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public void getDescription() {
        System.out.println("Я люблю лето, потому что это " + Constants.WARM_SEASON +
                " и средняя температура " + temperature + " градусов");
    }
}
