package Lesson16_1;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Shop implements IShop {
    private List<Item> items;

    public Shop() {
        items = new ArrayList<>();
    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    @Override
    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public void deleteItem(int id) {
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            int value = iterator.next().getId();
            if (id == value) {
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public void editItem(Item items) {
        for (Item value : getItems()) {
            if (value.getId() == items.getId()) {
                value.setPrice(items.getPrice());
                value.setName(items.getName());
                value.setCategory(items.getCategory());
                break;
            }
        }
    }

    @Override
    public List<Item> getSortByIncreasePrice() {
        items.sort(Comparator.comparing(Item::getPrice));
        return items;
    }

    @Override
    public List<Item> getSortByDecreasePrice() {
        items.sort(Collections.reverseOrder(Comparator.comparing(Item::getPrice)));
        return items;
    }

    @Override
    public List<Item> getReverseItems() {
        Collections.reverse(items);
        return items;
    }
}