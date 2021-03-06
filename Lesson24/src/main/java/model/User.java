package model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    private int id;
    private String name;
    private String surname;
    private String password;
    private LocalDate dateBorn;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(int id, String name, String surname, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public User(String name, String surname, String password) {
        this.name = name;
        this.surname = surname;
        this.password = password;
    }
}