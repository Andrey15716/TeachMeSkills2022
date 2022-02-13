import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassengerTransport extends GroundTransport {

    private String bodyType;
    private int passengerQuantity;

    public String infoOfPassengerTransport() {
        return "Пассажировместимость - " + getPassengerQuantity() +
                "Наличие бизнес класса - " + getBodyType();
    }
}
