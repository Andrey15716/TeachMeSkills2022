package Lesson16_1;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Item implements Comparable<Item> {
    private int id;
    private int price;
    private String name;
    private Category category;

    public Item(int id, int price, String name, Category category) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Товар : " +
                " id =" + id +
                ", цена = " + price +
                ", наименование = '" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Item item) {
        return name.compareTo(item.getName());
    }
}

