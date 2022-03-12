import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Items implements Comparable<Items> {
    private int id;
    private int price;
    private String name;
    private Category category;

    public Items(int id, int price, String name, Category category) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Items items)) return false;

        if (items.price != price) return false;
        if (!name.equals(items.name)) return false;
        return category ==items.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, name);
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
    public int compareTo(Items items) {
        return name.compareTo(items.getName());
    }
}

