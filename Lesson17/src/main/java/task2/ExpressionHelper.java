package task2;

import lombok.Getter;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;


@UtilityClass
@Getter
public class ExpressionHelper {

    public static List<Integer> randomNumber() {
        return new Random().ints(50, 0, 101).boxed().collect(Collectors.toList());
    }

    public static int evenNumbers(Set<Integer> integerList) {
        return (int) integerList.stream().filter(number -> number % 2 == 0).count();
    }
}