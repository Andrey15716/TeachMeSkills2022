package lesson12_1;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Audi", "белый", 10000);
        Car car1 = new Car("bmw", "black", 12000);
        Car car2 = new Car("nissan", "blue", 7000);
        System.out.println(car);
        System.out.println(car1);
        System.out.println(car2);

        try {
            car.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}