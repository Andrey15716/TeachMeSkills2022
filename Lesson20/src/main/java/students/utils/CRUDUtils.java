package students.utils;

import lombok.Getter;
import lombok.Setter;
import students.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CRUDUtils {
    private static String GET_ALL_STUDENTS_QUERY = "SELECT * FROM students_db.city inner join students_db.students on id_city = id;";
    private static String INSERT_STUDENTS_QUERY = "INSERT INTO students_db.students(name, surname, course) VALUES(?,?,?)";
    private static String INSERT_CITY_QUERY = "INSERT INTO students_db.city(from_city, study_city) VALUES(?,?)";
    private static String UPDATE_STUDENTS_QUERY = "UPDATE students_db.students SET course = ? WHERE id =?";
    private static String UPDATE_CITY_QUERY = "UPDATE students_db.city SET study_city = ? WHERE id_city =?";
    private static String DELETE_STUDENTS_QUERY = "DELETE FROM students_db.students WHERE id = ?";
    private static String DELETE_CITY_QUERY = "DELETE FROM students_db.city WHERE id_city = ?";

    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_STUDENTS_QUERY);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int course = rs.getInt("course");
                int id_city = rs.getInt("id_city");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String from_city = rs.getString("from_city");
                String study_city = rs.getString("study_city");
                students.add(new Student(id, course, name, surname, from_city, study_city, id_city));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    public static List<Student> saveStudents(Student student) {
        List<Student> saveStudents = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENTS_QUERY);
            PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_CITY_QUERY);

            preparedStatement.setInt(3, student.getCourse());
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());

            preparedStatement1.setString(1, student.getFrom_city());
            preparedStatement1.setString(2, student.getStudy_city());

            preparedStatement.executeUpdate();
            preparedStatement1.executeUpdate();

            saveStudents = getAllStudents();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return saveStudents;
    }

    public static List<Student> updateStudents(int id, int course, String study_city) {
        List<Student> updatedList = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENTS_QUERY);
            PreparedStatement preparedStatement1 = connection.prepareStatement(UPDATE_CITY_QUERY);

            preparedStatement.setInt(1, course);
            preparedStatement.setInt(2, id);

            preparedStatement1.setString(1, study_city);
            preparedStatement1.setInt(2, id);

            preparedStatement.executeUpdate();
            preparedStatement1.executeUpdate();

            updatedList = getAllStudents();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return updatedList;
    }

    public static List<Student> deleteStudents(int id) {
        List<Student> deleteStudents = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENTS_QUERY);
            PreparedStatement preparedStatement1 = connection.prepareStatement(DELETE_CITY_QUERY);

            preparedStatement.setInt(1, id);
            preparedStatement1.setInt(1, id);

            preparedStatement.executeUpdate();
            preparedStatement1.executeUpdate();

            deleteStudents = getAllStudents();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return deleteStudents;
    }
}