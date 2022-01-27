public class Test {
    public static void main(String[] args) {
        //вывод на консоль
        printLiterals();
        //Некоторые тесты для проверки задач.
        System.out.println(sum(100, 200));
        System.out.println(sum(Integer.MAX_VALUE, Integer.MAX_VALUE));
        System.out.println(max(56, 349));
        System.out.println(calculateHypotenuse(3, 4));
    }


    private static void printLiterals() {
//        вывести на консоль литералы следующих видов:
        boolean logic = true;
        System.out.println(logic);

        String str1 = "MyProgram";
        System.out.println(str1);

        char symbol = 'n';
        System.out.println(symbol);

        int num2 = 0b101;
        System.out.println(num2);

        int num8 = 06;
        System.out.println(num8);

        int num10 = 878;
        System.out.println(num10);

        int num16 = 0x7ddfffff;
        System.out.println(num16);

        float fl = 2.2f;
        System.out.println(fl);

        double db = 2.2;
        System.out.println(db);
    }


    /**
     * 1. Метод должен вернуть сумму двух чисел a и b
     * 2. Дополнительно: сделать проверку если сумма a и b больше чем максимальное значение int то вернуть -1
     **/
    public static int sum(int a, int b) {

        int sum = a + b;
        System.out.println(sum);

        if (sum > Integer.MAX_VALUE) {
            return -1;
        } else return sum;
    }


    /**
     * Метод должен вернуть максимальное значение из двух чисел
     *
     * <p>
     * Example1:
     * a = 4,
     * b = 5
     * <p>
     * Метод должен вернуть 5
     * Example2:
     * a = 10,
     * b = 10
     * <p>
     * Метод должен вернуть 10
     */
    public static int max(int a, int b) {

        return Math.max(a, b);
    }


    /**
     * Используя теорему Пифагора, вычислите значение гипотенузы. Квадрат гипотенузы = сумме квадратов катетов
     * <p>
     * Example1:
     * 3
     * 4
     * return 5
     * <p>
     * Example2:
     * 12
     * 16
     * return 20
     */
    public static double calculateHypotenuse(int a, int b) {

        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
}

