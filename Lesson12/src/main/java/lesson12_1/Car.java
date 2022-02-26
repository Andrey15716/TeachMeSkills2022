package lesson12_1;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Car {

    private String model;
    private String color;
    private int price;

    public Car(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    public void start() throws Exception {
        Random random = new Random();
        int a = random.nextInt(20);

        if (a % 2 == 0) {
            throw new Exception("Вывод исключения");
        } else {
            System.out.println("Завелся");
        }
    }

    @Override
    public String toString() {
        return "Автомобиль " +
                " модели '" + model + '\'' +
                " ценой '" + price + '\'' +
                ", цвета '" + color + '\'';
    }
}
