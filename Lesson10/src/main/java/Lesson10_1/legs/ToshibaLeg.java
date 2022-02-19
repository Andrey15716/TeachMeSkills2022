package Lesson10_1.legs;

public class ToshibaLeg implements ILeg {
    private int price;

    public ToshibaLeg(int price) {
        this.price = price;
    }

    public ToshibaLeg() {
    }

    @Override
    public void step() {
        System.out.println("Toshiba сделал шаг");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
