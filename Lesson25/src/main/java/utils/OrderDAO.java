package utils;

import lombok.Getter;
import lombok.Setter;
import model.Order;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderDAO {
    private final static String INSERT_ORDER = "INSERT INTO order (product_id, user_id, order_quantity, order_date) VALUES (?,?,?,?)";
    private final static String GET_USER_ORDER = "SELECT * FROM order WHERE u_id = ? by eshop.order.order_id desc";
    private final static String DELETE_USER_ORDER = "DELETE FROM order WHERE id = ?";

    public boolean insertOrder(Order order) {
        boolean result = false;

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement insertOrderPreparedStatement = connection.prepareStatement(INSERT_ORDER);

            insertOrderPreparedStatement.setInt(1, order.getId());
            insertOrderPreparedStatement.setInt(2, order.getUId());
            insertOrderPreparedStatement.setInt(3, order.getQuantity());
            insertOrderPreparedStatement.setString(4, order.getDate());
            insertOrderPreparedStatement.executeUpdate();
            result = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public List<Order> userOrder(int id) {
        List<Order> orderList = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement userOrderPreparedStatement = connection.prepareStatement(GET_USER_ORDER);
            userOrderPreparedStatement.setInt(1, id);
            ResultSet resultSet = userOrderPreparedStatement.executeQuery();

            while (resultSet.next()) {
                Order order = new Order();
                ProductDAO productDAO = new ProductDAO();
                int productId = resultSet.getInt("product_id");

                Product product = productDAO.getSingleProduct(productId);
                order.setOrderId(resultSet.getInt("order_id"));
                order.setId(productId);
                order.setName(product.getName());
                order.setDescription(product.getDescription());
                order.setQuantity(resultSet.getInt("order_quantity"));
                order.setPrice(product.getPrice() * resultSet.getInt("order_quantity"));
                order.setDate(resultSet.getString("order_date"));
                orderList.add(order);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return orderList;
    }


    public void cancelOrder(int id) {
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement productPreparedStatement = connection.prepareStatement(DELETE_USER_ORDER);
            productPreparedStatement.setInt(1, id);
            productPreparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
