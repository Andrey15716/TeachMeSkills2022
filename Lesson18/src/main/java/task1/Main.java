package task1;

//Писать код с использованием Stream API
//        * 1) Создать класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
//        * Создать коллекцию, содержащую объекты класса Student. Перебрать всех студентов, вычислить средний балл
//        * каждого студента. Если средний балл >=3, студент переводится на следующий курс, иначе отчисляется.

import java.util.IntSummaryStatistics;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = List.of(
                new Student("Andrey", "Informatics", 3, 2, 1, 4),
                new Student("Ivan", "Informatics", 3, 2, 3, 4),
                new Student("Vladimir", "Informatics", 4, 3, 4, 5),
                new Student("Vlad", "Informatics", 2, 4, 5, 6)
        );
        List<Integer> integerList = studentList.stream().mapToInt(Student::getEstimateForMathematics).boxed().toList();
        double avg = getAverage(integerList);
        System.out.println(avg);
    }

    private static double getAverage(List<Integer> list) {
        IntSummaryStatistics stats = list.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        return stats.getAverage();
    }
}