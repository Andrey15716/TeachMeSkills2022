import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirTransport extends Transport {

    private int wingSpan;
    private int minRunwayLength;

    public String infoOfAirTransport() {
        return "Модель транспорта - " + getModel() +
                "Мощность двигателя - " + getHorsePower() +
                "Мощность двигателя в килоВатт - " + getKwPower() +
                "Масса транспорта - " + getWeight() +
                "Максимальная скорость - " + getMaxSpeed() +
                "Размах крыльев,метры - " + getWingSpan() +
                "Минимальная длина взлетно-посадочной полосы -" + getMinRunwayLength();
    }

    public void infoPassengerCapacity(int passengers, int passengerQuantity,
                                      boolean availabilityOfBusinessClass) {
        System.out.println("Количество пассажиров - " + passengers);
        System.out.println(passengerQuantity >= passengers ? "Самолет загружен" :
                "Вам нужен самолет побольше");
    }

    public void infoRocket(int rocket, int rocketQuantity) {
        System.out.println(rocketQuantity >= rocket ? "Ракета пошла!" :
                "Боеприпасы отсутствуют");
    }

    public void infoCatapulta(boolean availabilityCatapult) {
        System.out.println(availabilityCatapult ? "Катапультирование сработало" :
                "Нету катапульты");
    }
}
