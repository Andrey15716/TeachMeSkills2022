import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
public class Shop implements Serializable {
    private Map<Items, Integer> items;

    public Shop() {
        items = new LinkedHashMap<>();
    }

    public Map<Items, Integer> getItems() {
        return items;
    }

    public void addItems(Items items) {
        if (!getItems().containsKey(items)) {
            getItems().put(items, 1);
        } else {
            getItems().put(items, getItems().get(items) + 1);
        }
    }

    public void deleteItems(Items items) {
        getItems().remove(items);
    }

    public void editItems(Items items) {
        if (getItems().containsKey(items)) {
            items.setPrice(items.getPrice());
            items.setName(items.getName());
            items.setCategory(items.getCategory());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shop shop)) return false;
        return items.equals(shop.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }
}
