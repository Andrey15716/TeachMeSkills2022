package students.utils;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
@Setter
public class DbUtils {
    private static String dbUrl = "jdbc:mysql://localhost:3306/students_db";
    private static String dbUsername = "root";
    private static String dbPassword = "qwe345qwe";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}