package task6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Email {
    private String email;
    private String additionalInformation;

    public Email(String email) {
        this.email = email;
    }
}
