package model;

import java.util.List;

import static utils.CRUDUtils.addUser;

public class AccountData {
    private static List<User> userList;

    public static List<User> getUsersList() {
        return userList;
    }

    public static void setUsers(List<User> users) {
        AccountData.userList = users;
    }

    public static void addUserToList(User user) {
        addUser(user);
    }

    public static boolean checkUser(User user) {
        return getUsersList().stream().anyMatch(
                user1 -> user1.getName().equals(user.getName()) && user1.getPassword()
                        .equals(user.getPassword()));
    }
}