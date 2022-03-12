package task2;

//2) Обобщенный класс с тремя параметрами
//        * Создать обобщенный класс с тремя параметрами (T, V, K).
//        * Класс содержит три переменные типа (T, V, K), конструктор, принимающий на вход параметры типа (T, V, K),
//        * методы возвращающие значения трех переменных. Создать метод, выводящий на консоль имена классов для трех переменных класса.
//        * Наложить ограничения на параметры типа: T должен реализовать интерфейс Comparable (String),
//        * V должен реализовать интерфейс Serializable и расширять класс Animal, K должен расширять класс Number.
public class Main {
    public static void main(String[] args) {

        PrintClass<String, Cat, Double> printClass = new PrintClass<>("Cat", new Cat(), 5.1);
        printClass.showTypes();
        System.out.println("Значение T " + printClass.getObT());
        System.out.println("Значение V " + printClass.getObV());
        System.out.println("Значение K " + printClass.getObK());
    }
}