package repositories;

import entities.Order;

import java.util.List;

public interface OrderRepository extends BaseRepository<Order> {
    Order getOrderById(int id);

    List<Integer> getAllOrdersIdsByUserId(int id);

    //    void create(int productId, int orderId);
    Order create(Order order);

    Order getOrderByUserId(int id);
}