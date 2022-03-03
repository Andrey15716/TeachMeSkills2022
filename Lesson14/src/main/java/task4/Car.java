package task4;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Car implements Serializable {

    private String model;
    private int speed;
    private int price;
    private Engine engine = new Engine("Бензиновый двигатель", 4);
    private GasTank gasTank = new GasTank(95, 60);

    public Car(String model, int speed, int price) {
        this.model = model;
        this.speed = speed;
        this.price = price;
    }

    public static class Engine implements Serializable {
        public String type;
        public transient int cylinder;

        public Engine(String type, int cylinder) {
            this.type = type;
            this.cylinder = cylinder;
        }
    }

    @Getter
    @Setter
    public static class GasTank implements Serializable {
        private int gasType;
        private int totalValue;

        public GasTank(int gasType, int totalValue) {
            this.gasType = gasType;
            this.totalValue = totalValue;
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", speed=" + speed +
                ", price=" + price +
                ", type=" + engine.type +
                ", cylinders=" + engine.cylinder +
                ", gasType=" + gasTank.gasType +
                ", totalValue=" + gasTank.totalValue +
                '}';
    }
}