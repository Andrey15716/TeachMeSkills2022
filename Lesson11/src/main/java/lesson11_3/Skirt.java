package lesson11_3;

public class Skirt extends Clothes implements WomanClothes {
    public Skirt(ClothesSize size, String color, int price) {
        super(size, color, price);
    }

    @Override
    public void dressUpWoman() {
        System.out.println("Женская юбка с размером " + getSize().name() +
                ", цветом " + getColor() + " и ценой" + getPrice());
    }
}
