package task1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String inputPath = "C:\\Users\\u108\\IdeaProjects\\TeachMeSkills2022\\Lesson14\\src\\main\\java\\task1\\input.txt";
    private static final String outputPath = "C:\\Users\\u108\\IdeaProjects\\TeachMeSkills2022\\Lesson14\\src\\main\\java\\task1\\output.txt";

    public static void main(String[] args) throws IOException {
        String[] linesIn = Files.readAllLines(Path.of(inputPath)).toArray(new String[0]);
        String[] palindrome = palindromes(linesIn);

        try (FileWriter fileOutputStream = new FileWriter(outputPath)) {
            for (String e : palindrome) {
                fileOutputStream.write(e);
                fileOutputStream.write(System.lineSeparator());
            }
        }
    }

    public static String[] palindromes(String[] str2) {
        List<String> p = new ArrayList<>();
        for (int i = 0; i < str2.length; i++) {
            for (int j = i + 1; j < str2.length; j++) {
                boolean result = isPalindromes(str2[i], str2[j]);
                if (result) {
                    System.out.printf("%s (%d) <> %s (%d)\n", str2[i], i, str2[j], j);
                    p.add(str2[i]);
                    p.add(str2[j]);
                }
            }
        }
        return p.toArray(new String[0]);
    }

    public static boolean isPalindromes(String firsts, String seconds) {
        if (firsts.length() != seconds.length()) {
            return false;
        }
        for (int i = 0; i < firsts.length(); i++) {
            if (firsts.charAt(i) != seconds.charAt(seconds.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}


