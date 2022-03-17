package task5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Задан список сотрудников, которые хранятся в коллекции List<p3.Person>.
//        * Объект p3.Person содержит имя и фамилию(по желанию другие данные)
//        *  a) написать метод, который отображает все фамилии, начинающиеся на букву "Д".
//        *     Внимание! метод должен вернуть объект Optional<String>.
//        *  b*)Со звездочкой. Написать метод, который будет выводить в столбик первую букву фамилии и рядом количество сотрудников,
//        *  у которых фамилия начинается с этой буквы.
//        *  Пример: Антонов, Петров, Сидоров, Александров...
//        *  на экран выведет:
//        *  A - 2 сотрудника
//        *  П - 1 сотрудник
//        *  С - 1 сотрудник
public class Main {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("Петр", "Иванов"),
                new Person("Дмитрий", "Петров"),
                new Person("Владимир", "Владимиров")
        );
        List<Optional<String>> personsNames = personList.stream()
                .map(Person::getName)
                .filter(name -> name.startsWith("Д"))
                .map(Optional::of)
                .toList();
        System.out.println(personsNames);
    }
}
