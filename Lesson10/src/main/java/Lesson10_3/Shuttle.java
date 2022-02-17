package Lesson10_3;

import java.util.Random;

public class Shuttle implements IStart {

    @Override
    public boolean isCheck() {
        Random random = new Random();
        return random.nextInt(11) > 3;
    }

    @Override
    public void startEngines() {
        System.out.println("Двигатели Шатла запущены");
    }

    @Override
    public void start() {
        System.out.println("Отсчет пошел");
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }
        System.out.println("Старт Шатла");
    }
}