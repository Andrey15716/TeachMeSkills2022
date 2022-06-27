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

//    public static boolean isExistUser(User user) {
//        return user.stream().anyMatch(user1 -> user1.getName().equals(user.getName())
//                        && user1.getPassword().equals(user.getPassword()));
//    }
}