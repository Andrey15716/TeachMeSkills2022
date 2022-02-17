package Lesson10_1.heads;

public class SamsungHead implements IHead {
    private int price;

    public SamsungHead(int price) {
        this.price = price;
    }

    public SamsungHead() {
    }

    @Override
    public void speak() {
        System.out.println("Samsung говорит");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
