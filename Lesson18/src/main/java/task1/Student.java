package task1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Student {
    private String name;
    private String group;
    private int numberOfCourse;
    private int estimateForMathematics;
    private int estimateForInformatics;
    private int estimateForBiology;
}