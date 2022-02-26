package lesson12_2;

import java.util.Objects;

public class Main {
    public static final String NAME_PATTERN = "[a-zA-Z0-9_]{1,20}";

    public static void main(String[] args) {
        checkAuthorization(new Authorization("1422", "123", "123"));
    }

    public static void checkAuthorization(Authorization authorization) {
        try {
            if (!authorization.getLogin().matches(NAME_PATTERN)) {
                throw new WrongLoginException("Введен неверный логин!");
            }

            if (!authorization.getPassword().matches(NAME_PATTERN) | !Objects.equals(authorization.getPassword(), authorization.getConfirmPassword())) {
                throw new WrongPasswordException("Введен неверный пароль!");
            }
            System.out.println("Авторизация прошла успешно");
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
        }
    }
}