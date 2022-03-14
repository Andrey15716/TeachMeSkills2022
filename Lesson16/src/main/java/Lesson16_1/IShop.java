package Lesson16_1;

import java.util.*;

public interface IShop {
    List<Item> getItems();

    void addItem(Item item);

    void deleteItem(int id);

    void editItem(Item items);

    List<Item> getSortByIncreasePrice();

    List<Item> getSortByDecreasePrice();

    List<Item> getReverseItems();
}