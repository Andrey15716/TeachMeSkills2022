package lesson11_3;

public class Studio {

    public void dressMen(Clothes[] clothes) {
        for (Clothes clothes1 : clothes) {
            if (clothes1 instanceof MenClothes) {
                ((MenClothes) clothes1).dressUpMan();
            }
        }
        System.out.println("Надеть мужчину");
    }

    public void dressWoman(Clothes[] clothes) {
        for (Clothes clothes1 : clothes) {
            if (clothes1 instanceof WomanClothes) {
                ((WomanClothes) clothes1).dressUpWoman();
            }
        }
        System.out.println("Надеть девушку");
    }
}
