package Task2;

import lombok.Data;

import java.util.Scanner;

@Data
public class Car {

    private String model;
    private String color;
    private int distance = 50;
    boolean isCarOn;
    private Engine engine = new Engine("Бензиновый двигатель");
    private Benzobak benzobak = new Benzobak(12, 60);

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public void start() {
        if (benzobak.value > 0 && isCarOn) {
            System.out.println("Машина поехала");
            checkDistance();
            checkFuel();
        } else if (benzobak.value > 0 && !isCarOn) {
            checkDistance();
            checkFuel();
        } else {
            System.out.println("Нет топлива в бензобаке!");
            engine.stop();
            fillUp();
            engine.start();
            System.out.println("Машина поехала");
        }
    }

    public void fillUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество литров для заправки");
        int fillUp = scanner.nextInt();
        benzobak.setValue(fillUp + benzobak.getValue());
    }

    public void checkFuel() {
        System.out.println("В бензобаке " + benzobak.value + " литров ");
    }


    public void stop() {
        engine.stop();
    }

    public void checkEngine() {
        System.out.println("Чтобы завести машину введите 1");
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        if (start == 1) {
            engine.start();
            isCarOn = true;
        } else{
            System.out.println("Машина не заведена");
            checkEngine();
            isCarOn= false;
        }
    }

    private void checkDistance() {
        System.out.println("Машина прошла " + distance + " км");
    }

    @Override
    public String toString() {
        return "Характеристики автомобиля : " +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine.type;
    }

    public class Engine {

        public String type;

        public Engine(String type) {
            this.type = type;
        }

        public void info() {
            System.out.println(model + color + type);
        }

        public void start() {
            System.out.println("Двигатель завелся");
        }

        public void stop() {
            System.out.println("Двигатель остановился");
        }
    }

    @Data
    public class Benzobak {
        private int value;
        private int totalValue;

        public Benzobak(int value, int totalValue) {
            this.value = value;
            this.totalValue = totalValue;
        }

        public Benzobak(int value) {
            this.value = value;
        }
    }
}

