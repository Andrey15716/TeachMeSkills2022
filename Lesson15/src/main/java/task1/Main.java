package task1;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String catalogName = "Lesson15\\src\\main\\java\\task2";
        File catalog = new File(catalogName);

        if (catalog.isDirectory()) {
            System.out.println("Папка " + catalogName);
            String[] list = catalog.list();
            assert list != null;
            for (String fileName : list) {
                File file = new File(catalogName + "/" + fileName);
                if (file.isDirectory()) {
                    System.out.printf("\t%s каталог%n", fileName);
                } else {
                    System.out.printf("\t%s файл%n", fileName);
                }
            }
        } else {
            System.out.println(catalogName + " не является каталогом");
        }
    }
}
