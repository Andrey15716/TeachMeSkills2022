import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroundTransport extends Transport {

    private int wheelQuantity;
    private double consumption;

    public String infoOfGroundTransport() {
        return "Модель транспорта - " + getModel() + "Количество колес - " + getWheelQuantity() +
                "Расход топлива - " + getConsumption() + "Мощность двигателя - " + getHorsePower() +
                " Мощность двигателя в килоВатт - " + getKwPower() + "Масса транспорта - " + getWeight() +
                " Максимальная скорость - " + getMaxSpeed();

    }

    public void infoTravelTime(int time) {
        System.out.println(" За время " + time + " ч, автомобиль " + getModel() +
                " двигаясь с максимальной скоростью " + getMaxSpeed() +
                " км/ч проедет " + time * getMaxSpeed() +
                " км и израсходует " + consumption(time) + " литров топлива");
    }

    public double consumption(int time) {
        return time * getMaxSpeed() * (getConsumption() / 100);
    }

    public void infoLoadCapacity(int loadWeight, int loadCapacity) {

        System.out.println(loadCapacity >= loadWeight ? "Вам нужен грузовик побольше" : "Грузовик загружен");
    }
}
