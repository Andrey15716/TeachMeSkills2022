package task4;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("audi", 220, 12000);
        File file = new File("Lesson14\\src\\main\\java\\task4\\Car.ser");
        Serializer.serialize(car, file);
        Car newCar = (Car) Serializer.deserializer(file);
        System.out.println(newCar);
    }
}