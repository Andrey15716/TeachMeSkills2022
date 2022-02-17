package Lesson10_1.hands;

public class SamsungHand implements IHand {
    private int price;

    public SamsungHand(int price) {
        this.price = price;
    }

    public SamsungHand() {
    }

    @Override
    public void upHand() {
        System.out.println("Samsung поднял руки");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
