import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassengerAirTransport extends AirTransport {

    private int passengerQuantity;
    private boolean availabilityOfBusinessClass;

    public String infoPassengerAirTransport() {
        return "Пассажировместимость - " + getPassengerQuantity() +
                "Наличие бизнес класса - " + availabilityOfBusinessClass;
    }
}
