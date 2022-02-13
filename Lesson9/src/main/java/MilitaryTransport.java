import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MilitaryTransport extends AirTransport {
    private boolean availabilityCatapult;
    private int rocketQuantity;

    public String infoOfMilitaryTransport() {
        return "Наличие катапульты - " + availabilityCatapult +
                " Количество боевых ракет - " + rocketQuantity;
    }
}
