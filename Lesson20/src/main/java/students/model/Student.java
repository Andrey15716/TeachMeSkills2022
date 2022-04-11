package students.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Student {
    private int id;
    private int course;
    private String name;
    private String surname;
    private String from_city;
    private String study_city;
    private int city_id;
}