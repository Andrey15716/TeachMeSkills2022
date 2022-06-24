package model;

import lombok.Getter;

import java.util.List;

import static utils.CRUDUtils.addUser;
import static utils.CRUDUtils.getUser;

@Getter
public class AccountData {
    private static List<User> userList;

    public static void setUsers(List<User> users) {
        AccountData.userList = users;
    }

    public static void addUserToList(User user) {
        addUser(user);
    }

    public static boolean checkUser(String login, String password) {
        for (User check : userList) {
            if (check.getName().equals(login) && check.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isExistUser(User user) {
        return getUser().stream().anyMatch(
                user1 -> user1.getName().equals(user.getName()) && user1.getPassword()
                        .equals(user.getPassword()));
    }
}