package task2;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//Текстовый файл hw2/input.txt содержит текст.
//        * После запуска программы в другой файл должны записаться только те предложения, в которых от 3-х до 5-ти слов.
//        * Если в предложении присутствует слово-палиндром, то не имеет значения какое кол-во слов в предложении, оно попадает в output.txt файл.
//        * Пишем все в ООП стиле. Создаем класс TextFormatter
//        * в котором два метода:
//        * 1. Метод принимает строку и возвращает кол-во слов в строке.
//        * 2. Метод принимает строку и проверяет есть ли в строке слово-палиндром. Если есть возвращает true, если нет false
//        * В main считываем файл.
//        * Разбиваем текст на предложения. Используя методы класса TextFormatter определяем подходит ли нам предложение.
//        * Если подходит добавляем его в output.txt файл
public class Main {

    private static final String INPUT_PATH = "Lesson14\\src\\main\\java\\task2\\input.txt";
    private static final String OUTPUT_PATH = "Lesson14\\src\\main\\java\\task2\\output.txt";

    public static void main(String[] args) throws IOException {

        String[] linesIn = Files.readAllLines(Path.of(INPUT_PATH)).toArray(new String[0]);
        String[] palindromes = task1.Main.palindromes(linesIn);

        try (FileWriter fileOutputStream = new FileWriter(OUTPUT_PATH)) {

            for (String value : palindromes) {

                fileOutputStream.write(value);
                fileOutputStream.write(System.lineSeparator());
            }
        }
    }
}
