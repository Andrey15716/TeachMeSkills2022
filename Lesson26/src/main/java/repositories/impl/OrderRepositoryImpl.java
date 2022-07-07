package repositories.impl;

import entities.Order;
import entities.Product;
import repositories.OrderRepository;
import repositories.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private static final String INSERT_NEW_ORDER = "INSERT INTO eshop2.orders (price,date,user_id) VALUES (?,?,?)";
    private static final String INSERT_NEW_ORDER_PRODUCT = "INSERT INTO eshop2.order_product (product_id,order_id) VALUES (?,?)";
    private static final String GET_ALL_ORDERS_BY_USER_ID = "SELECT * FROM eshop2.orders WHERE user_id=?";
    private static final String GET_ORDER_BY_USER_ID = "SELECT * FROM eshop2.orders WHERE user_id=?";
    private static final String GET_ORDER_BY_ORDER_ID = "SELECT * FROM eshop2.orders WHERE order_id=?";

    @Override
    public Order create(Order entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Order order = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_ORDER);
            preparedStatement.setInt(1, entity.getPriceOrder());
            preparedStatement.setDate(2, Date.valueOf(entity.getDate()));
            preparedStatement.setInt(3, entity.getUserId());
            preparedStatement.executeUpdate();
            order = getOrderByUserId(entity.getUserId());
            connectionPool.closeConnection(connection);
            List<Product> productsInOrder = entity.getProductList();
            for (Product product : productsInOrder) {
                PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_NEW_ORDER_PRODUCT);
                preparedStatement1.setInt(1, product.getId());
                preparedStatement1.setInt(2, order.getId());
                preparedStatement1.executeUpdate();
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return order;
    }

    @Override
    public List<Order> read() {
        return null;
    }

    @Override
    public Order update(Order entity) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Integer> getAllOrdersIdsByUserId(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Integer> orders = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ORDERS_BY_USER_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                orders.add(order_id);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return orders;
    }

    @Override
    public Order getOrderByUserId(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Order order = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_USER_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idOrder = rs.getInt("order_id");
                int price = rs.getInt("price");
                LocalDate date = rs.getDate("date").toLocalDate();
                int idUser = rs.getInt("user_id");
                order = new Order(idOrder, idUser, date, price);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return order;
    }

    public Order getOrderById(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Order order = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_ORDER_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idOrder = rs.getInt("order_id");
                int price = rs.getInt("price");
                LocalDate date = rs.getDate("date").toLocalDate();
                int idUser = rs.getInt("user_id");
                order = new Order(idOrder, price, date, idUser);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return order;
    }
}