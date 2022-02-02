import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson5 {

    public static void main(String[] args) {
        sum(-2, -3);
        massive();
        inverse();
        randomMassive();
        replaceElement();
        maximumValue();
        arrayEquals();
        matrixArray();
        calculateSumOfDiagonalElements();
        printMatrix();
    }


//        Задачи:

//        1) Напишите реализацию метода sum(int a, int b), вычисляющий a*b, не пользуясь операцией
//        умножения, где a и b целые числа, вызовите метод sum  в методе main и распечатайте на консоль.

    public static void sum(int a, int b) {
        int result = 0;

        if (a == 0 || b == 0) {
            System.out.println(0);
        } else if (a < 0 && b > 0) {
            for (int i = 0; i < b; i++) {
                result = result + a;
            }
        } else if (a > 0 && b < 0) {
            for (int i = 0; i < a; i++) {
                result = result + b;
            }
        } else if (a < 0 && b < 0) {
            for (int i = 0; i > b; i--) {
                result -= a;
            }
        }
        System.out.println(result);
    }


//        2) Дан двухмерный массив размерностью 4 на 4, необходимо нарисовать четыре треугольника вида

//        a)                  b)
//              *        *
//            * *        * *
//          * * *        * * *
//        * * * *        * * * *
//
//        c)                  d)
//        * * * *        * * * *
//          * * *        * * *
//            * *        * *
//              *        *

    public static void massive() {

        String[][] arraya = new String[4][4];
        for (int i = 0; i < arraya.length; i++) {
            for (int j = arraya.length - 1; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        String[][] arrayb = new String[4][4];
        for (int i = 0; i < arrayb.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        String[][] arrayc = new String[4][4];
        for (int i = arrayc.length - 1; i >= 0; i--) {
            for (int j = arrayc.length - 1; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        String[][] arrayd = new String[4][4];
        for (int i = arrayd.length - 1; i >= 0; i--) {
            for (int j = 0; j < arrayd.length; j++) {
                if (j <= i) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }


//        3) Создайте массив из всех нечётных чисел от 1 до 100, выведите его на экран в строку,
//        а затем этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 ... 7 5 3 1).

    public static void inverse() {

        int[] massiveInverse = new int[50];
        for (int i = 0; i < massiveInverse.length; i++) {
            massiveInverse[i] = 2 * i + 1;
        }
        System.out.println(Arrays.toString(massiveInverse));


        for (int j = massiveInverse.length - 1; j >= 0; j--) {
            System.out.println(massiveInverse[j]);
        }
    }


//        4) Создайте массив из int[] mass = new int[12]; Рандомно заполните его значениями от 0 до 15.
//        Определите какой элемент является в этом массиве максимальным и сообщите индекс его последнего вхождения в массив.
//        Пример: {3,4,5,62,7,8,4,-5,7,62,5,1} Максимальный элемент 62, индекс его последнего вхождения в массив = 10

    public static void randomMassive() {

        int[] mass = new int[12];
        Arrays.setAll(mass, operand -> (int) (Math.random() * 15));
        Arrays.sort(mass);
        System.out.println(Arrays.toString(mass));

        int max = getMax(mass);
        int index = getIndex(mass, max);
        System.out.println("Максимальное число массива -  " + max + ", индекс его последнего вхождения в массив = " + index);
    }

    //здесь находим максимум
    public static int getMax(int[] inputArray) {

        int maxValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] > maxValue) {
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }

    //здесь находим индекс
    public static int getIndex(int[] arr, int num) {

        int index = 0;
        if (arr != null) {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] == num) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }


//        5) Создайте массив размера 20, заполните его случайными целыми чиселами из отрезка от 0 до 20.
//        Выведите массив на экран в строку. Замените каждый элемент с нечётным индексом на ноль.
//        Снова выведете массив на экран на отдельной строке.

    public static void replaceElement() {

        int[] replaceArray = new int[20];
        Arrays.setAll(replaceArray, operand -> (int) (Math.random() * 20));
        System.out.println(Arrays.toString(replaceArray));

        for (int i = 0; i < replaceArray.length; i += 2) {
            replaceArray[i] = 0;
        }
        System.out.println(Arrays.toString(replaceArray));
    }


// 6) Найти максимальный элемент в массиве {4,5,0,23,77,0,8,9,101,2} и поменять его местами с нулевым элементом

    public static void maximumValue() {

        int[] maximumNum = {4, 5, 0, 23, 77, 0, 8, 9, 101, 2};
        System.out.println(Arrays.toString(maximumNum));

        int maxValue = getMax(maximumNum);
        System.out.println("Максимальный элемент массива - " + maxValue);
        Array.set(maximumNum, getIndex(maximumNum, 0), 101);

        for (int k = 0; k < 10; k++) {
            if (maximumNum[k] == 0) {
                maximumNum[k] = maxValue;
            }
        }
        System.out.println(Arrays.toString(maximumNum));
    }


//        7) Проверить, различны ли все элементы массива, если не различны то вывести элемент повторяющийся
//        Пример: {0,3,46,3,2,1,2}
//        Массив имеет повторяющиеся элементы 3, 2
//        Пример: {0,34,46,31,20,1,28}
//        Массив не имеет повторяющихся элементов

    public static void arrayEquals() {

        int[] arrayEqual = {0, 3, 46, 3, 2, 1, 2};
        System.out.println(Arrays.toString(arrayEqual));

        for (int i = 0; i < arrayEqual.length; i++) {
            for (int j = i + 1; j < arrayEqual.length; j++) {
                if (arrayEqual[i] == arrayEqual[j]) {
                    System.out.println("Массив имеет повторяющиеся числа " + arrayEqual[i]);
                }
            }
        }
    }


//        8) Создаём квадратную матрицу, размер вводим с клавиатуры.
//        Заполняем случайными числами в диапазоне от 0 до 50. И выводим на консоль(в виде матрицы).
//        Далее необходимо транспонировать матрицу(1 столбец станет 1-й строкой, 2-й столбец - 2-й строкой и т. д.)
//        Пример:
//          1 2 3 4      1 6 3 1
//          6 7 8 9      2 7 3 5
//          3 3 4 5      3 8 4 6
//          1 5 6 7      4 9 5 7

    public static void matrixArray() {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите число для массива");
        int a = input.nextInt();

        int[][] matrix = new int[a][a];
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(50);
            }
            System.out.println(Arrays.deepToString(matrix));
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[j][i] = matrix[i][j];
            }
            System.out.println(Arrays.deepToString(matrix));
        }
    }


    /**
     * заполнить рандомно 2-х мерный массив и посчитать сумму элементов на диагонали
     */

    public static void calculateSumOfDiagonalElements() {
        //пишем логику и выводим результат используя System.out.println
        int[][] calculate = new int[2][2];

        for (int i = 0; i < calculate.length; i++) {
            for (int j = 0; j < calculate[i].length; j++) {
                calculate[i][j] = (int) (Math.random() * 10);
                System.out.println(calculate[i][j] + " ");
            }
            System.out.println();
        }
        int sum = 0;
        for (int i = 0; i < calculate.length; i++) {
            for (int j = 0; j < calculate[i].length; j++) {
                if (i == j) {
                    sum = sum + calculate[i][j];
                }
            }
        }
        System.out.println("Сумма по диагонали массива = " + sum);
    }


    /**
     * Шаги по реализации:
     * - Прочитать два int из консоли
     * - Создайте двумерный массив int (используйте целые числа, которые вы читаете по высоте и ширине консоли)
     * - Заполнить массив случайными значениями (до 100)
     * - Вывести в консоль матрицу заданного размера, но:
     * - Если остаток от деления элемента массива на 3 равен нулю - выведите знак "+" вместо значения элемента массива.
     * - Если остаток от деления элемента массива на 7 равен нулю - выведите знак "-" вместо значения элемента массива.
     * - В противном случае выведите "*"
     * <p>
     * Example:
     * - Значения с консоли - 2 и 3
     * - Массив будет выглядеть так (значения будут разными, потому что он случайный)
     * 6 11 123
     * 1 14 21
     * - Для этого значения вывод в консоли должен быть:
     * <p>
     * + * *
     * * - +
     * <p>
     * Обратите внимание, что 21% 3 == 0 и 21% 7 = 0, но выводить надо не +-, а +
     */

    public static void printMatrix() {
        // тут пишем логику
        Scanner input = new Scanner(System.in);
        System.out.println("Введите число для массива задачи 10 ");
        int a = input.nextInt();

        String[][] print = new String[a][a];
        Random random = new Random();

        for (int i = 0; i < print.length; i++) {
            for (int j = 0; j < print[i].length; j++) {
                print[i][j] = String.valueOf(random.nextInt(100));
                if (Integer.parseInt(print[i][j]) % 3 == 0) {
                    print[i][i] = "+";
                } else if (Integer.parseInt(print[i][j]) % 7 == 0) {
                    print[i][j] = "-";
                } else {
                    print[i][j] = "*";
                }
                System.out.println(print[i][j]);
            }
        }
    }
}
