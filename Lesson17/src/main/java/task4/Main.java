package task4;

import org.codehaus.plexus.util.StringUtils;

import java.util.Arrays;
import java.util.List;

//Создаем класс Car с полями number (номер авто) и year (год выпуска).
//        * List<Car> cars = Arrays.asList(
//        *             new Car("AA1111BX", 2007),
//        *             new Car("AK5555IT", 2010),
//        *             new Car(null, 2012),
//        *             new Car("", 2015),
//        *             new Car("AI3838PP", 2017));
//        *
//        * Необходимо вывести все не пустые номера машин, выпущенных после 2010 года
public class Main {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("AA1111BX", 2007),
                new Car("AK5555IT", 2010),
                new Car(null, 2012),
                new Car("", 2015),
                new Car("AI3838PP", 2017));

        cars.stream()
                .filter(year -> year.getYear() >= 2010)
                .map(Car::getModel)
                .filter(StringUtils::isNotBlank)
                .forEach(System.out::println);
    }
}