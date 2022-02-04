package by.tms.model;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer("AMD", "Huawei", "Seagate", 3);
        Computer.onComp();

        for (int i = 0; i < 1; i++) {
            if (Computer.isComputerAlive) {
                Computer.resourceValue();
                System.out.println("Выключение компьютера");
                System.out.println(Computer.cycles - 1);
            } else {
                System.out.println("Компьютер " + computer.processor + " сгорел");
            }
        }
    }
}

