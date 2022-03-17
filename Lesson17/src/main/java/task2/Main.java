package task2;

import java.util.*;
import java.util.stream.Collectors;

//Определение количества четных чисел в потоке данных.
//* Создаем коллекцию Set<Integer> в которую добавляем рандомно 50 чисел от 0 до 100
public class Main {
    public static void main(String[] args) {

        Set<Integer> integerSet = new HashSet<>(ExpressionHelper.randomNumber());
        integerSet.stream().filter(n -> n % 2 == 0).collect(Collectors.toSet());
        System.out.println("Количество четных чисел " + (long) integerSet.size());
    }
}