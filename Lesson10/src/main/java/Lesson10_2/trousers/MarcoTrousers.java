package Lesson10_2.trousers;

public class MarcoTrousers implements ITrousers {
    @Override
    public void putOn() {
        System.out.println("Надел брюки");
    }

    @Override
    public void takeOff() {
        System.out.println("Снял брюки");
    }
}
