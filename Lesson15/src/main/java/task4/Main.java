package task4;

//4)Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы - sum, multiply, divide,
//        * subtraction. Параметры этих методов  - два числа разного типа, над которыми должна быть произведена операция.
public class Main {
    public static void main(String[] args) {
        printResults(getCalcOperation());
    }

    private static double[] getCalcOperation() {
        return new double[]{
                Calculator.divide(15, 13.2),
                Calculator.multiply(5, 14L),
                Calculator.subtraction((byte) 12, 11),
                Calculator.sum((short) 11, 1)
        };
    }

    public static void printResults(double[] results) {
        for (double result : results) {
            System.out.println("result = " + result);
        }
    }
}