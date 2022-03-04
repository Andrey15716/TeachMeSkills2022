package task4;

import java.io.File;

public class Main {

    private static final String OUTPUT_PATH = "Lesson14\\src\\main\\java\\task4\\Car.ser";

    public static void main(String[] args) {
        Car car = new Car("audi", 220, 12000);
        File file = new File(OUTPUT_PATH);
        Serializer.serialize(car, file);
        System.out.println(Serializer.deserializer(file, Car.class));
    }
}