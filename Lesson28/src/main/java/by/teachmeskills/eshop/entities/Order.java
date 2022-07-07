package by.teachmeskills.eshop.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Order extends BaseEntity {
    private int userId;
    private LocalDate date;
    private int priceOrder;
    private List<Product> productList;

    public Order(int id, int userId, LocalDate date, int priceOrder) {
        super(id);
        this.userId = userId;
        this.date = date;
        this.priceOrder = priceOrder;
    }

    public Order(int userId, LocalDate date, int priceOrder) {
        this.userId = userId;
        this.date = date;
        this.priceOrder = priceOrder;
    }

    public Order(int userId, LocalDate date, int priceOrder, List<Product> productList) {
        this.userId = userId;
        this.date = date;
        this.priceOrder = priceOrder;
        this.productList = productList;
    }
}