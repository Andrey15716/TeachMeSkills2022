package shop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Products {
    private int id;
    private String name;
    private String description;
    private String available;
    private String amount;
    private String price;
}