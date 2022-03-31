package task1;

//Писать код с использованием Stream API
//        * 1) Создать класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
//        * Создать коллекцию, содержащую объекты класса Student. Перебрать всех студентов, вычислить средний балл
//        * каждого студента. Если средний балл >=3, студент переводится на следующий курс, иначе отчисляется.

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = List.of(
                new Student("Andrey", 2, Arrays.asList(1, 2, 3, 4, 4)),
                new Student("Ivan", 3, Arrays.asList(2, 3, 4, 5)),
                new Student("Vladimir", 3, Arrays.asList(5, 4, 3, 2, 2)),
                new Student("Vlad", 4, Arrays.asList(4, 4, 4, 2, 1, 8))
        );

        Map<String, Double> averageScores = Student.getAverageScoresOfStudents(studentList);
        System.out.println(averageScores);
        Student.studentsInfo(studentList);
    }
}