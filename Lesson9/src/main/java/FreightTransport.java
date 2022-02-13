import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FreightTransport extends GroundTransport {

    private int loadCapacity;

    public String infoOfFreightTransport() {
        return "Грузоподьемность транспорта,т - " + getLoadCapacity();
    }
}
