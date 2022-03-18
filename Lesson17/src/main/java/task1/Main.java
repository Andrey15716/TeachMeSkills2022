package task1;

import task2.ExpressionHelper;

import java.util.List;

//Вывести список чисел, умноженных на 2. Список чисел задаем рандомно.
public class Main {
    public static void main(String[] args) {
        List<Integer> numbersList = ExpressionHelper.randomNumber();
        numbersList.stream()
                .map(number -> number * 2)
                .toList()
                .forEach(System.out::println);
    }
}