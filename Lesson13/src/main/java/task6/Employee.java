package task6;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee extends Report {
    private String fullName;
    private double salary;

    public Employee(String fullName, double salary) {
        this.fullName = fullName;
        this.salary = salary;
    }
}
