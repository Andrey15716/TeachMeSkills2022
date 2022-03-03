package task3;

public class Main {
    public static void main(String[] args) {
        MinMax<Integer> arraysMinMax = new MinMax<>(new Integer[]{2, 3, 4, 5, 6});
        printMinMaxInfo(arraysMinMax);
        System.out.println();
    }

    public static void printMinMaxInfo(MinMax minMax) {
        System.out.println(minMax);
        System.out.println("Минимальный элемент " + minMax.getMinElement());
        System.out.println("Максимальный элемент " + minMax.getMaxElement());
    }
}
