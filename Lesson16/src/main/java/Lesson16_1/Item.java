package Lesson16_1;

import lombok.*;

@Data
@AllArgsConstructor
public class Item implements Comparable<Item> {
    private int id;
    private int price;
    private String name;
    private Category category;

    @Override
    public int compareTo(Item item) {
        return name.compareTo(item.getName());
    }
}