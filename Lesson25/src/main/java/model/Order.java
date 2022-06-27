package model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order extends Product {
    private int orderId;
    private int uId;
    private int quantity;
    private String date;
    private User user;
}
