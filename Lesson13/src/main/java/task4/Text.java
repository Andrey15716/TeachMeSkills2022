package task4;

public class Text extends Palindromes {

    public Text(String str2) {
        super(str2);
    }

    public static void txt(String str3) {
        int str4 = str3.split("\\.").length;
        System.out.println(str4);
        int count = 0;
        for (int i = 0; i < str3.length(); i++) {
            count++;
        }
        System.out.println(count);
    }

}