package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class User {
    private String login;
    private String password;

    {
        login = "qwe";
        password = "qwe";
    }
}