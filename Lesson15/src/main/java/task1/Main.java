package task1;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String catalogName = "Lesson15\\src\\main\\java\\task5";
        File catalog = new File(catalogName);

        if (catalog.isDirectory()) {
            System.out.println("Папка " + catalogName);

            String[] list = catalog.list();
            if (list != null) {
                for (String fileName : list) {
                    File file = new File(catalogName + "/" + fileName);
                    if (file.isDirectory()) {
                        System.out.printf("\t%s каталог%n", fileName);
                        search(file);

                    } else {
                        System.out.printf("\t%s файл%n", fileName);
                    }
                }
            }
        } else {
            System.out.println(catalogName + " не является каталогом");
        }
    }

    public static void search(File catalog) {
        if (catalog.isDirectory()) {
            File[] files = catalog.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        search(file);
                    }
                }
            }
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("\t\tПапка " + catalog.getName());
                        System.out.printf("\t\t%s файл%n \n", file.getName());
                    }
                }
            }
        }
    }
}