package Task2;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Audi", "White");
        System.out.println(car);
        car.checkEngine();
        car.start();
    }
}
