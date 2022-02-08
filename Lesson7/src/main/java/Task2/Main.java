package Task2;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("audi", "white");
        System.out.println(car);
        car.checkEngine();
        car.start();
    }
}
