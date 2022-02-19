package lesson11_3;

public class Tie extends Clothes implements MenClothes {
    public Tie(ClothesSize size, String color, int price) {
        super(size, color, price);
    }

    @Override
    public void dressUpMan() {
        System.out.println("Мужской галстук с размером " + getSize().name() + " с цветом " + getColor() + " и ценой " + getPrice());
    }
}
