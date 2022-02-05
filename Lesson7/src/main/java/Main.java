import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        MilitaryOffice militaryOffice = new MilitaryOffice();

        System.out.println(Arrays.toString(militaryOffice.findByAddress("Belarus")));

    }
}
