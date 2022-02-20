package lesson11_4;

public class Main {

    /**
     * Задача4
     * * Создать абстрактный класс Фрукт и классы Яблоко, Груша, Абрикос расширяющие его.
     * * Класс Фрукт содержит:
     * * а) переменную вес,
     * * б) метод printManufacturerInfo(){System.out.print("Made in Belarus");} который нельзя изменить в наследнике.
     * * в) абстрактный метод, возвращающий стоимость фрукта, который должен быть переопределен в каждом классе наследнике.
     * * Метод должен учитывать вес фрукта(Т.е в зависимости от веса разная цена)
     * * Создать несколько объектов разных классов.
     * * Подсчитать общую стоимость проданных фруктов.
     * * А также общую стоимость отдельно проданных яблок, груш и абрикос.
     */
    public static void main(String[] args) {
        double totalPrice;

        Apple apple = new Apple(150, 50);
        Apricot apricot = new Apricot(234, 24);
        Pear pear = new Pear(324, 86);
        getInfoOrder(apple);
        getInfoOrder(apricot);
        getInfoOrder(pear);

        totalPrice = apple.getTotalPricePerWeight() + apricot.getTotalPricePerWeight() + pear.getTotalPricePerWeight();
        System.out.println("Общая сумма покупок " + (int) totalPrice + " рублей.");

    }

    public static void getInfoOrder(Fruits fruits) {
        System.out.println("Вы заказали " + fruits.getWeight() + " грамм по цене " + fruits.getFruitPrice());
    }
}