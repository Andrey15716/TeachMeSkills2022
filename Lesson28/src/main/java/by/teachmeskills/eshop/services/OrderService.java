package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.entities.Order;

public interface OrderService extends BaseServices<Order> {
    Order create(Order order);
}