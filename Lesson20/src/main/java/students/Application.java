package students;

import students.model.Student;
import students.utils.CRUDUtils;

public class Application {
    public static void main(String[] args) {
        System.out.println("All students : ");
        CRUDUtils.getAllStudents().forEach(System.out::println);

        System.out.println("Save students : ");
        CRUDUtils.saveStudents(new Student(7, 3, "Anna", "Annova", "Minsk", "Minsk", 3))
                .forEach(System.out::println);
        System.out.println("Update Students : ");
        CRUDUtils.updateStudents(2, 3, "Moscow")
                .forEach(System.out::println);
        System.out.println("Delete students : ");
        CRUDUtils.deleteStudents(1)
                .forEach(System.out::println);
    }
}