package task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// Проверка на цензуру:
//         * Создаете 2 файла.
//         * 1 - й. Содержит исходный текст.
//         * 2 - й. Содержит слова недопустимые в тексте (black list). Структура файла определите сами, хотите каждое слово на новой строке, хотите через запятую разделяйте.
//         * Задача: необходимо проверить проходит ли текст цензуру. Если в тексте не встретилось ни одного недопустимого слова, то выводите сообщение о том что текст прошел проверку на цензуру.
//         * Если нет, то выводите соответствующее сообщение, кол-во предложений не прошедших проверку и сами предложения подлежащие исправлению.
public class Main {

    private static final String INPUT_PATH = "Lesson14\\src\\main\\java\\task3\\Text.txt";
    private static final String INPUTPATH_OF_BLACKLIST = "Lesson14\\src\\main\\java\\task3\\BlackList.txt";

    public static void main(String[] args) throws IOException {

        String[] text = Files.readAllLines(Path.of(INPUT_PATH)).toArray(new String[0]);
        String[] blackList = Files.readAllLines(Path.of(INPUTPATH_OF_BLACKLIST)).toArray(new String[0]);

        for (String textValue : text) {
            for (String blackListValue : blackList) {
                if (textValue.equalsIgnoreCase(blackListValue)) {
                    System.out.println("Проверку не прошел!");
                }
            }
        }
    }
}