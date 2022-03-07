package task4;

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
