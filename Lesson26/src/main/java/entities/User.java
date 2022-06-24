package entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BaseEntity {
    private String name;
    private String surname;
    private String password;
    private LocalDate dateBorn;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String surname, String password, LocalDate dateBorn) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.dateBorn = dateBorn;
    }

    public User(int id, String name, String surname, String password, LocalDate dateBorn) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.dateBorn = dateBorn;
    }
}