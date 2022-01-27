import java.util.Scanner;

public class Lesson4 {


    public static void main(String[] args) {

        random();
        ameba();
        array();
        zodiac();


        //Некоторые тесты для проверки задач. Можно также написать свои тесты.
        printArray();
        System.out.println(operation(1));
        System.out.println(operation(0));
        System.out.println(calculateCountOfOddElementsInMatrix(new int[]{1, 2, 3, 4, 5, 6}));
        countDevs(103);
        countDevs(19);
        foobar(6);
        foobar(10);
        foobar(15);
        printPrimeNumbers();
    }


//        1) Задача на оператор switch!
//        Рандомно генерируется число От 1 до 7.
//        Если число равно 1, выводим на консоль “Понедельник”, 2 –”Вторник” и так далее.
//        Если 6 или 7 – “Выходной”.


    private static void random() {
        int random = (int) (Math.random() * 7);

        switch (random) {
            case 1 -> System.out.println("Понедельник");
            case 2 -> System.out.println("Вторник");
            case 3 -> System.out.println("Среда");
            case 4 -> System.out.println("Четверг");
            case 5 -> System.out.println("Пятница");
            case 6, 7 -> System.out.println("Суббота");
        }
    }


//2) Одноклеточная амеба каждые 3 часа делится на 2 клетки. Определить,
//         сколько амеб будет через 3, 6, 9, 12,..., 24 часа

    private static void ameba() {
        int a = 2;

        for (int i = 1; i < 9; i++) {
            System.out.println(a * i);
        }
    }


//3) В переменную записываем число.
//        Надо вывести на экран сколько в этом числе цифр и положительное оно или отрицательное.
//        Например, Введите число: 5
//        "5 - это положительное число, количество цифр = 1"

    private static void array() {
        int[] array = {5};
        String k = " - это положительное число, количество цифр = " + array.length;
        String m = " - это отрицательное число, количество цифр = " + array.length;

        if (array[0] % 2 == 0) {
            System.out.println(array[0] + k);
        } else
            System.out.println(array[0] + m);
    }


//4) Дано 2 числа, день и месяц рождения. Написать программу, которая определяет знак зодиака человека.

    public static void zodiac() {
        int day = 6;
        int month = 2;

        if ((month == 3 && day >= 21) || (month == 4 && day <= 20))
            System.out.println("Овен");
        else if ((month == 4 && day >= 21) || (month == 5 && day <= 20))
            System.out.println("Телец");
        else if ((month == 5 && day >= 21) || (month == 6 && day <= 21))
            System.out.println("Близнецы");
        else if ((month == 6 && day >= 22) || (month == 7 && day <= 22))
            System.out.println("Рак");
        else if ((month == 7 && day >= 23) || (month == 8 && day <= 23))
            System.out.println("Лев");
        else if ((month == 8 && day >= 24) || (month == 9 && day <= 23))
            System.out.println("Дева");
        else if ((month == 9 && day >= 24) || (month == 10 && day <= 22))
            System.out.println("Весы");
        else if ((month == 10 && day >= 23) || (month == 11 && day <= 22))
            System.out.println("Скорпион");
        else if ((month == 11 && day >= 23) || (month == 12 && day <= 21))
            System.out.println("Стрелец");
        else if ((month == 12 && day >= 22) || (month == 1 && day <= 20))
            System.out.println("Козерог");
        else if ((month == 1 && day >= 21) || (month == 2 && day <= 19))
            System.out.println("Водолей");
        else if ((month == 2 && day >= 20) || (month == 3 && day <= 20))
            System.out.println("Рыбы");
    }


    /**
     * Необходимо прочитать с консоли значение числа типа int,
     * сделать проверку что если пользователь ввел не положительное число,
     * то вывести ошибку и отправить пользователя вводить заново новое число!
     * далее создать одномерный массив типа int размера прочитанного с консоли
     * далее заполнить массив случайными значениями
     * далее вывести массив на консоль
     */

    private static void printArray() {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите число для массива");
        int s = input.nextInt();

        if (s >= 0) {
            System.out.println(s);
        } else throw new IllegalArgumentException("Введите новое положительное число!");

        int[] massive = new int[s];
        for (int i = 0; i < massive.length; i++) {
            massive[i] = (int) (Math.random() * s);
            System.out.println(massive[i]);
        }
    }


    /**
     * Метод должен выполнять некоторую операцию с int "number" в зависимости от некоторых условий:
     * - if number положительное число, то необходимо number увеличить на 1
     * - if number отрицательное - уменьшить на 2
     * - if number равно 0 , то замените значение number на 10
     * вернуть number после выполнения операций
     */

    public static int operation(int number) {
        // тут пишем логику

        if (number > 0) {
            System.out.println(number + 1);
        } else if (number < 0) {
            System.out.println(number - 2);
        } else {
            System.out.println(10);
        }
        return number;
    }


    /**
     * На вход приходит массив целых чисел типа int
     * Необходимо найти количество нечетных элементов в массиве и вернуть значение в метод main,
     * в котором это значение распечатается на консоль.
     */
    public static int calculateCountOfOddElementsInMatrix(int[] ints) {
        int sum = 0;

        for (int anInt : ints) {
            if (anInt % 2 != 0) {
                sum++;
            }
        }
        return sum;
    }


    /**
     * На вход приходит число.
     * Вывести в консоль фразу из разряда "_COUNT_ программистов",
     * заменить _COUNT_ на число которое пришло на вход в метод и заменить окончание в слове "программистов" на
     * уместное с точки зрения русского языка.
     * Пример: 1 программист, 42 программиста, 50 программистов
     *
     * @param count - количество программистов
     */


    public static void countDevs(int count) {
        // тут пишем логику
        if ((count >= 10 || count % 10 == 0) & (count <= 100)) {
            System.out.println(count + " программистов");
        } else if (count == 1) {
            System.out.println(count + " программист");
        } else
            System.out.println(count + " программиста");
    }


    /**
     * Метод должен выводить разные строки в консоли в зависимости от некоторых условий:
     * - если остаток от деления на 3 равен нулю - выведите "foo" (example of number - 6)
     * - если остаток от деления на 5 равен нулю - вывести "bar" (example of number - 10)
     * - если остаток от деления на 3 и 5 равен нулю 0 ,то вывести "foobar" (example of number - 15)
     */
    public static void foobar(int number) {
        // тут пишем логику
        if ((number % 3 == 0) & (number % 5 == 0)) {
            System.out.println("foobar");
        } else if (number % 5 == 0) {
            System.out.println("bar");
        } else if (number % 3 == 0) {
            System.out.println("foo");
        }
    }


    /**
     * Задача со звездочкой!
     * Метод должен печатать все простые числа <1000
     * что такое просто число (https://www.webmath.ru/poleznoe/formules_18_5.php)
     */


    public static void printPrimeNumbers() {
        // тут пишем логику

        int i;
        int j;
        boolean primeNumbers;

        for (j = 2; j < 1000; j++) {
            primeNumbers = false;

            for (i = 2; i<= j/i; i++) {

                if (j%i ==0) {
                    primeNumbers = true;
                    break;
                }
            }
            if (!primeNumbers) {
                System.out.print(j + " ");
            }
        }
    }
}





