package utils;

import lombok.Getter;
import lombok.Setter;
import model.Cart;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class CartDAO {
    private final static String INSERT_QUERY = "INSERT INTO cart (user_id, products_id) VALUES (" +
            "(SELECT id FROM eshop.user WHERE login = ?), " +
            "(SELECT id FROM eshop.products WHERE name = ?), " +
            "?);";
    private final static String DELETE_QUERY = "DELETE FROM cart WHERE user_id = " +
            "(SELECT id FROM user WHERE login = ?)";

    private final static String GET_QUERY = "SELECT * FROM cart INNER JOIN products " +
            "ON cart.id = products.id " +
            "WHERE user_id = " +
            "(SELECT id FROM user WHERE login = ?);";

//    public static void saveCartState(User user) {
//        try (Connection connection = DbUtils.getConnection();
//             PreparedStatement deleteStatement = connection.prepareStatement(DELETE_QUERY);
//             PreparedStatement insertStatement = connection.prepareStatement(INSERT_QUERY)) {
//            deleteStatement.setString(1, user.getName());
//            deleteStatement.executeUpdate();
//            insertStatement.setString(1, user.getName());
//            for (Map.Entry<Product, Integer> entry : Cart.getProducts().entrySet()) {
//                insertStatement.setString(2, entry.getKey().getName());
//                insertStatement.addBatch();
//            }
//            insertStatement.executeBatch();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    public static List<Product> getUsersProduct() {
        List<Product> usersList = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement userPreparedStatement = connection.prepareStatement(GET_QUERY);
            ResultSet rs = userPreparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                String imageName = rs.getString("imageName");
                int id = rs.getInt("id");
                int price = rs.getInt("price");
                usersList.add(new Product(id, name, description, imageName, price));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return usersList;
    }

    public static void addProducts(Product product) {
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement addProduct = connection.prepareStatement(INSERT_QUERY);
            addProduct.setString(1, product.getName());
            for (Map.Entry<Product, Integer> entry : Cart.getProducts().entrySet()) {
                addProduct.setString(2, entry.getKey().getName());
                addProduct.addBatch();
            }
            addProduct.executeBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}