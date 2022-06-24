package utils;

import lombok.Getter;
import lombok.Setter;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CRUDUtils {
    private static String GET_USER_QUERY = "SELECT * FROM user";
    private static String INSERT_USER_QUERY = "INSERT INTO user(name,surname,password) VALUES(?,?,?)";

    public static List<User> getUser() {
        List<User> usersList = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement userPreparedStatement = connection.prepareStatement(GET_USER_QUERY);
            ResultSet rs = userPreparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String password = rs.getString("password");
                int id = rs.getInt("id");
                usersList.add(new User(id, name, surname, password));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return usersList;
    }

    public static void addUser(User user) {
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement addUser = connection.prepareStatement(INSERT_USER_QUERY);

            addUser.setString(1, user.getName());
            addUser.setString(2, user.getSurname());
            addUser.setString(3, user.getPassword());
            addUser.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}