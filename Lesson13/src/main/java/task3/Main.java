package task3;

public class Main {
    public static void main(String[] args) {
        String[] str2 = "Hello World abc sdv cba gfd cot toc sab cba olleH.".split("\\W");
        palindromes(str2);
    }

    public static void palindromes(String[] str2) {
        for (int i = 0; i < str2.length; i++) {
            for (int j = i + 1; j < str2.length - 1; j++) {
                if (isPalindromes(str2[i], str2[j]))
                    System.out.printf("%s (%d) <> %s (%d)\n", str2[i], i, str2[j], j);
            }
        }
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
