package Task2;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;
@Getter
@Setter
public class Car {

    private String model;
    private String color;
    private int distance = 50;
    boolean isCarOn;
    private Engine engine = new Engine("Бензиновый двигатель");
    private Benzobak benzobak = new Benzobak(0, 60);


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
            checkEngine();
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
        } else {
            System.out.println("Машина не заведена");
        }
    }

    private void checkDistance() {
        System.out.println("Машина прошла " + distance + " км");
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isCarOn() {
        return isCarOn;
    }

    public void setCarOn(boolean carOn) {
        isCarOn = carOn;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return "Характеристики автомобиля : " +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine.type;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Benzobak getBenzobak() {
        return benzobak;
    }

    public void setBenzobak(Benzobak benzobak) {
        this.benzobak = benzobak;
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

    @Getter
    @Setter
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
