package task4;

public class Palindromes {
    public String str2;

    public Palindromes(String str2) {
        this.str2 = str2;
    }

    public static void palindromes(String[] str2) {
        for (int i = 0; i < str2.length; i++) {
            for (int j = i + 1; j < str2.length - 1; j++) {
                if (Palindromes.isPalindromes(str2[i], str2[j]))
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