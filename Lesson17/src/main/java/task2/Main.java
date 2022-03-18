package task2;

import java.util.*;
import java.util.stream.Collectors;

//Определение количества четных чисел в потоке данных.
//* Создаем коллекцию Set<Integer> в которую добавляем рандомно 50 чисел от 0 до 100
public class Main {
    public static void main(String[] args) {

        Set<Integer> integerSet = new HashSet<>(ExpressionHelper.randomNumber());
        System.out.println(integerSet);
        System.out.println("Количество чётных чисел - " + ExpressionHelper.evenNumbers(integerSet));
    }
}