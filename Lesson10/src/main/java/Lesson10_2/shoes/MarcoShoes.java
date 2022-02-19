package Lesson10_2.shoes;

public class MarcoShoes implements IShoes {
    @Override
    public void putOn() {
        System.out.println("Надел туфли");
    }

    @Override
    public void takeOff() {
        System.out.println("Снял туфли");
    }
}
