package utils;

import entities.User;
import lombok.Getter;

import java.util.List;

@Getter
public class AccountUtils {
    private static List<User> userList;

    public static boolean checkUser(String login, String password) {
        for (User check : userList) {
            if (check.getName().equals(login)
                    && check.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}