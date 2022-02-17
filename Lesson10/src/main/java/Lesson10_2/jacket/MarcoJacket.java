package Lesson10_2.jacket;

public class MarcoJacket implements IJacket {

    @Override
    public void putOn() {
        System.out.println("Надел куртку Marco");
    }

    @Override
    public void takeOff() {
        System.out.println("Снял куртку Marco");
    }
}
