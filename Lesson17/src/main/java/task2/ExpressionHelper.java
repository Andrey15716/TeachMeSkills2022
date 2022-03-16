package task2;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


@UtilityClass
@Getter
public class ExpressionHelper {

    public static List<Integer> randomNumber() {
        return new Random().ints(50, 0, 101).boxed().collect(Collectors.toList());
    }
}