import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    private String country;
    private String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }
}