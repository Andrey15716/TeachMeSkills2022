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

@Getter
@Setter
public class ProductDAO {
    private final static String GET_CART_PRODUCT = "SELECT * FROM eshop.products WHERE id = ?";
    private final static String GET_All_PRODUCTS = "SELECT * FROM eshop.products";
    private final static String GET_CART_PRICE = "SELECT price FROM eshop.products WHERE id = ?";

    public List<Product> getAllProducts() {
        List<Product> usersList = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement userPreparedStatement = connection.prepareStatement(GET_All_PRODUCTS);
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

    public List<Cart> getCartProduct(List<Cart> cartList) {
        List<Cart> products = new ArrayList<>();
        if (cartList.size() > 0) {
            for (Cart item : cartList) {
                try (Connection connection = DbUtils.getConnection()) {
                    PreparedStatement cartPreparedStatement = connection.prepareStatement(GET_CART_PRODUCT);
                    cartPreparedStatement.setInt(1, item.getId());
                    ResultSet rs = cartPreparedStatement.executeQuery();
                    while (rs.next()) {
                        Cart cart = new Cart();
                        cart.setId(rs.getInt("id"));
                        cart.setName(rs.getString("name"));
                        cart.setQuantity(item.getQuantity());
                        cart.setPrice(rs.getInt("price") * item.getQuantity());
                        cart.setDescription(rs.getString("description"));
                        cart.setImageName(rs.getString("imageName"));
                        products.add(cart);
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return products;
    }

    public int getTotalPrice(List<Cart> cartList) {
        int sum = 0;
        if (cartList.size() > 0) {
            for (Cart item : cartList) {
                try (Connection connection = DbUtils.getConnection()) {
                    PreparedStatement cartPricePreparedStatement = connection.prepareStatement(GET_CART_PRICE);
                    cartPricePreparedStatement.setInt(1, item.getId());
                    ResultSet rs = cartPricePreparedStatement.executeQuery();
                    while (rs.next()) {
                        sum += rs.getInt("price") * item.getQuantity();
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return sum;
    }

    public Product getSingleProduct(int id) {
        Product singleProduct = null;

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement singleProductPreparedStatement = connection.prepareStatement(GET_CART_PRODUCT);
            singleProductPreparedStatement.setInt(1, id);
            ResultSet resultSet = singleProductPreparedStatement.executeQuery();

            while (resultSet.next()) {
                singleProduct = new Product();
                singleProduct.setId(resultSet.getInt("id"));
                singleProduct.setName(resultSet.getString("name"));
                singleProduct.setDescription(resultSet.getString("description"));
                singleProduct.setPrice(resultSet.getInt("price"));
                singleProduct.setImageName(resultSet.getString("imageName"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return singleProduct;
    }
}