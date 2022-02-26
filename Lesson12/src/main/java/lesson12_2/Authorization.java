package lesson12_2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Authorization {
    private String login;
    private String password;
    private String confirmPassword;

    public Authorization(String login, String password, String confirmPassword) {
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
}
