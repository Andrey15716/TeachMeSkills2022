package task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    private static final String inputPath = "C:\\Users\\u108\\IdeaProjects\\TeachMeSkills2022\\Lesson14\\src\\main\\java\\task3\\Text.txt";
    private static final String inputPathOfBlackList = "C:\\Users\\u108\\IdeaProjects\\TeachMeSkills2022\\Lesson14\\src\\main\\java\\task3\\BlackList.txt";

    public static void main(String[] args) throws IOException {

        String[] text = Files.readAllLines(Path.of(inputPath)).toArray(new String[0]);
        String[] blackList = Files.readAllLines(Path.of(inputPathOfBlackList)).toArray(new String[0]);

        for (String textValue : text) {
            for (String blackListValue : blackList) {
                if (textValue.equalsIgnoreCase(blackListValue)) {
                    System.out.println("Проверку не прошел!");
                }
            }
        }
    }
}