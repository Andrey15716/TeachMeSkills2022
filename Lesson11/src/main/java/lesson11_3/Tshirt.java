package lesson11_3;

public class Tshirt extends Clothes implements WomanClothes, MenClothes {
    public Tshirt(ClothesSize size, String color, int price) {
        super(size, color, price);
    }

    @Override
    public void dressUpMan() {
        System.out.println("Мужская майка с размером " + getSize().name() +
                ", цветом " + getColor() + " и ценой " + getPrice());
    }

    @Override
    public void dressUpWoman() {
        System.out.println("Женская майка с размером " + getSize().name() +
                ", цветом " + getColor() + " и ценой " + getPrice());
    }
}
