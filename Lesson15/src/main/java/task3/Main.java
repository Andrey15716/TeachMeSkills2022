package task3;

//3)Написать обобщенный класс MinMax, который содержит методы для нахождения минимального и максимального элемента массива.
//        * Массив является переменной класса. Массив должен передаваться в класс через конструктор.
//        * Написать метод принимающий MinMax объект и печатающий информацию об элементах.
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