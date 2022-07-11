package by.teachmeskills.eshop.repositories;

import by.teachmeskills.eshop.entities.Order;

import java.util.List;

public interface OrderRepository extends BaseRepository<Order> {
    Order getOrderById(int id);

    List<Integer> getAllOrdersIdsByUserId(int id);

    Order create(Order order);

    Order getOrderByUserId(int id);
}