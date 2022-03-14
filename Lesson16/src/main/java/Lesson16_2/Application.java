package Lesson16_2;

import Lesson16_1.Category;
import Lesson16_1.IShop;
import Lesson16_1.Item;
import Lesson16_1.Shop;

import java.util.Scanner;

public class Application {
    private final Scanner scanner = new Scanner(System.in);
    private final IShop shop;

    public Application() {
        this.shop = new Shop();
    }

    public void start() {
        System.out.println("Наш магазин компьютерной техники в Минске");
        System.out.println("""
                                    
                Выберите действие, которое хотите выполнить:
                1 Показать товары
                2 Добавить товар
                3 Удалить товар
                4 Редактировать товар по id
                5 Выход из меню
                """);
        switch (scanner.nextInt()) {
            case 1 -> getAllItems();
            case 2 -> addNewItem();
            case 3 -> deleteItem();
            case 4 -> editItem();
            case 5 -> {
                System.out.println("Ваш товар будет скоро доставлен!");
            }
        }
    }

    private void editItem() {
        if (isProduct()) {
            System.out.println("Введите номер товара, который хотите изменить");
            int editIdItem = scanner.nextInt();
            System.out.println("Введите новую цену товара");
            int editPrice = scanner.nextInt();
            System.out.println("Введите новое наименование товара");
            String editName = scanner.next();
            shop.editItem(new Item(editIdItem, editPrice, editName, Category.ALL));
        }
    }

    private void deleteItem() {
        if (isProduct()) {
            System.out.println("Введите номер товара, который Вы хотите удалить");
            int deleteIdItem = scanner.nextInt();
            shop.deleteItem(deleteIdItem);
            System.out.println("Ваш товар был удален");
        } else {
            System.out.println("Вашего товара нету вналичии");
        }
    }

    private void addNewItem() {
        System.out.println("Введите номер товара");
        int addNewId = scanner.nextInt();
        System.out.println("Введите стоимость товара");
        int addNewPrice = scanner.nextInt();
        System.out.println("Введите название товара");
        String addNewName = scanner.next();
        shop.addItem(new Item(addNewId, addNewPrice, addNewName, Category.ALL));
    }

    private void getAllItems() {
        System.out.println("""
                Выберите тип отображения товаров:
                1. По цене возрастанию цены
                2. По убыванию цены
                3. По добавлению (сначала новые, потом более старые)
                """);
        switch (scanner.nextInt()) {

            case 1:
                if (isProduct()) {
                    shop.getSortByIncreasePrice().forEach(System.out::println);
                }
                break;
            case 2:
                if (isProduct()) {
                    shop.getSortByDecreasePrice().forEach(System.out::println);
                }
                break;
            case 3:
                if (isProduct()) {
                    shop.getReverseItems().forEach(System.out::println);
                }
                break;
            case 4:
                break;
        }
    }

    private boolean isProduct() {
        if (shop.getItems().size() == 0) {
            System.out.println("Данный товар отсутствует");
            return false;
        } else {
            return true;
        }
    }
}
