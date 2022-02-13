import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transport {

    private int horsePower;
    private int maxSpeed;
    private int weight;
    private String model;
    private double kwPower;

    public double getKwPower() {
        return kwPower;
    }

    public void setKwPower(double kwPower) {
        this.kwPower = kwPower * 0.74;
    }
}
