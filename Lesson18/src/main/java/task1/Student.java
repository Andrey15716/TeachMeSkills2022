package task1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Student {
    private String name;
    private int numberOfCourse;
    private List<Integer> scores;

    public static Map<String, Double> getAverageScoresOfStudents(List<Student> studentList) {
        return studentList.stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(student -> student.getScores()
                        .stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(Double.NaN))));
    }

    public static void studentsInfo(List<Student> studentList) {
        Map<String, Double> map = getAverageScoresOfStudents(studentList);
        map.values().stream()
                .filter(aDouble -> aDouble >= 3.0).toList()
                .forEach(aDouble -> System.out.println("Студент переведен на следующий курс со средним баллом " + aDouble));
    }
}