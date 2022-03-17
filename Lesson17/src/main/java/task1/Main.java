package task1;

//Вывести список чисел, умноженных на 2. Список чисел задаем рандомно.
public class Main {
    public static void main(String[] args) {

        Operation calculate = () -> {
            int value = (int) (Math.random() * 10) * 2;
            int value2 = (int) (Math.random() * 10) * 2;
            int value3 = (int) (Math.random() * 10) * 2;
            int value4 = (int) (Math.random() * 10) * 2;
            System.out.println(value);
            System.out.println(value2);
            System.out.println(value3);
            return value4;
        };
        int result = calculate.result();
        System.out.println(result);
    }

    @FunctionalInterface
    interface Operation {
        int result();
    }
}