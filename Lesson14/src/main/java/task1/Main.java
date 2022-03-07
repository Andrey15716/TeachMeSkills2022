package task1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String INPUT_PATH = "Lesson14\\src\\main\\java\\task1\\input.txt";
    private static final String OUTPUT_PATH = "Lesson14\\src\\main\\java\\task1\\output.txt";

    public static void main(String[] args) throws IOException {
        List<String> linesIn = Files.readAllLines(Path.of(INPUT_PATH));
        String[] palindrome = palindromes(linesIn);

        try (FileWriter fileOutputStream = new FileWriter(OUTPUT_PATH)) {
            for (String e : palindrome) {
                fileOutputStream.write(e);
                fileOutputStream.write(System.lineSeparator());
            }
        }
    }

    public static String[] palindromes(List<String> str2) {
        List<String> p = new ArrayList<>();
        for (int i = 0; i < str2.size(); i++) {
            for (int j = i + 1; j < str2.size(); j++) {
                boolean result = isPalindromes(str2.get(i), str2.get(j));
                if (result) {
                    System.out.printf("%s (%d) <> %s (%d)\n", str2.get(i), i, str2.get(j), j);
                    p.add(str2.get(i));
                    p.add(str2.get(j));
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


