package task2;

public class Main {
    public static void main(String[] args) {

        PrintClass<String, Cat, Double> printClass = new PrintClass<>("Cat",new Cat(),5.1);
        printClass.showTypes();
        System.out.println("Значение T " + printClass.getObT());
        System.out.println("Значение V " + printClass.getObV());
        System.out.println("Значение K " + printClass.getObK());
    }
}
