package by.tms.model;

import java.util.Scanner;

public class Computer {
    public String processor;
    public String operatingDevice;
    public String hardDisk;
    public static int cycles = 50;
    public static boolean k;

    public Computer(String processor, String operatingDevice, String hardDisk, int cycles) {
        this.processor = processor;
        this.operatingDevice = operatingDevice;
        this.hardDisk = hardDisk;
        Computer.cycles = cycles;
    }

    public Computer() {
        this.hardDisk = "Hitachi";
        this.operatingDevice = "Huawei";
        this.processor = "Intel";
    }

    public static void onComp() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Внимание! Введите 0 или 1");
        int c = scanner.nextInt();
        int d = (int) (Math.random() * 1);
        k = false;

        for (int i = 0; i < 1; i++) {
            if (c == d) {
                System.out.println("Компьютер выключается");
                k = true;
                break;
            } else {
                System.out.println("Компьютер сгорел!");
                k = false;
            }
        }
    }
}

