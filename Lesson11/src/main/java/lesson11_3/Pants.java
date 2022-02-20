package lesson11_3;

public class Pants extends Clothes implements MenClothes, WomanClothes {
    public Pants(ClothesSize size, String color, int price) {
        super(size, color, price);
    }

    @Override
    public void dressUpMan() {
        System.out.println("Мужские штаны с размером " + getSize().name() + getSize().getDescription() +
                ", цветом " + getColor() + " и ценой " + getPrice());
    }

    @Override
    public void dressUpWoman() {
        System.out.println("Женские брюки с размером " + getSize().name() + getSize().getDescription() +
                ", цветом " + getColor() + " и ценой " + getPrice());
    }
}
