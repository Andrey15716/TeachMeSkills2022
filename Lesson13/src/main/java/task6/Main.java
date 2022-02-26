package task6;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Петров Иван Александрович", 200.2),
                new Employee("Иванов Дмитрий Александрович", 430),
                new Employee("Столяр Алексей Александрович", 860),
        };
        Report.generateReport(employees);
    }
}