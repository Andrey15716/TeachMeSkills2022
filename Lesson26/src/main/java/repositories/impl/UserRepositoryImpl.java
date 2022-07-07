package repositories.impl;

import entities.User;
import repositories.UserRepository;
import repositories.utils.ConnectionPool;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private static final String INSERT_USER_QUERY = "INSERT INTO eshop2.user(name,surname,password,date_of_birthday) VALUES(?,?,?,?)";
    private static final String GET_USER_BY_LOG_AND_PASS = "SELECT * FROM eshop2.user WHERE name=? AND password=?";

    @Override
    public User create(User entity) {
        return null;
    }

    @Override
    public List<User> read() {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Optional<User> getUserByLoginAndPass(String login, String password) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        User user = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_LOG_AND_PASS);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String surname = rs.getString("surname");
                String name = rs.getString("name");
                String pass = rs.getString("password");
                LocalDate dateOfBorn = rs.getDate("date_of_birthday").toLocalDate();
                user = new User(userId, name, surname, pass, dateOfBorn);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Optional.ofNullable(user);
    }

    @Override
    public void addUser(User user) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement addUser = connection.prepareStatement(INSERT_USER_QUERY);
            addUser.setString(1, user.getName());
            addUser.setString(2, user.getSurname());
            addUser.setString(3, user.getPassword());
            addUser.setDate(4, Date.valueOf(user.getDateBorn()));
            addUser.executeUpdate();
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}