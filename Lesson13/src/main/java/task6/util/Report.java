package task6.util;
import task6.Employee;

public class Report {

    public static void generateReport(Employee[] employees) {
        System.out.printf("|          ФИО          |%s|%n", "Зарплата,byn");
        print();
        for (Employee employee : employees) {
            String[] names = employee.getFullName().split("\\s+");
            System.out.printf("| %s.%s. %-12s|%12.2f|%n",
                    names[0], names[1].charAt(0), names[2].charAt(0), employee.getSalary());
            print();
        }
    }

    private static void print() {
        System.out.printf("|-----------------------+------------|%n");
    }
}