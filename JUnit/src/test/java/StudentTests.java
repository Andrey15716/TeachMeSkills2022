import model.Sex;
import model.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StudentTests {
    private static Student student1;
    private static Student student2;
    private static Student student3;

    private static List<Student> actual;
    private static List<Student> actualBySex;

    @BeforeAll
    public static void setUp() {
        student1 = new Student("Ivan", 17, Sex.MALE);
        student2 = new Student("Anna", 19, Sex.FEMALE);
        student3 = new Student("Polina", 18, Sex.FEMALE);

        actual = new ArrayList<>();
        actual.add(student1);
        actual.add(student2);
        actual.add(student3);

        actualBySex = new ArrayList<>();
        actualBySex.add(student1);
    }

    @Test
    public void checkAllStudentsReturned() {
        List<Student> expected = Student.getAllStudents();
        assertEquals(expected, actual);
    }

    @Test
    public void checkAllStudentsReturned_NotNull() {
        List<Student> expected = Student.getAllStudents();
        assertNotNull(expected);
    }

    @Test
    public void getStudentsCountWithSex() {
        int expected = Student.getStudentsCountWithSex(Sex.MALE);
        assertEquals(expected, 1);
    }

    @Test
    public void getStudentsCount() {
        int expected = Student.getStudentsCount();
        assertEquals(expected, 3);
    }

    @Test
    public void getSumOfAllStudentsAge() {
        int expected = Student.getSumOfAllStudentsAge();
        assertEquals(expected, 54);
    }

    @Test
    public void getSumOfAllStudentsAgeBySex() {
        int expected = Student.getSumOfAllStudentsAgeBySex(Sex.MALE);
        assertEquals(expected, 17);
    }

    @Test
    public void getAverageAgeOfAllStudents() {
        int expected = Student.getAverageAgeOfAllStudents();
        assertEquals(expected, 18);
    }

    @Test
    public void getAverageOfAllStudentsBySex() {
        int expected = Student.getAverageOfAllStudentsBySex(Sex.MALE);
        assertEquals(expected, 17);
    }

}

