package shop.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.model.Products;
import shop.model.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CRUDUtils {
    private static String GET_ALL_PRODUCTS_QUERY = "SELECT * FROM product";
    private static String GET_ALL_USERS_QUERY = "SELECT * FROM usr";
    private static String INSERT_PRODUCTS_QUERY = "INSERT INTO product(name, description, available, amount, price) VALUES(?,?,?,?,?)";
    private static String INSERT_USERS_QUERY = "INSERT INTO usr(name, surname, id) VALUES(?,?,?)";
    private static String UPDATE_PRODUCTS_QUERY = "UPDATE product SET amount = ?, available =?, price=? WHERE id =?";
    private static String DELETE_PRODUCTS_QUERY = "DELETE FROM product WHERE id = ?";

    public static List<Products> getAllProducts() {
        List<Products> productsList = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement productPreparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS_QUERY);
            ResultSet rs = productPreparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                String available = rs.getString("available");
                String amount = rs.getString("amount");
                String price = rs.getString("price");
                int id = rs.getInt("id");
                productsList.add(new Products(id, name, description, available, amount, price));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return productsList;
    }

    public static List<Users> getAllUsers() {
        List<Users> usersList = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement userPreparedStatement = connection.prepareStatement(GET_ALL_USERS_QUERY);
            ResultSet rs = userPreparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int id = rs.getInt("id");
                usersList.add(new Users(id, name, surname));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return usersList;
    }

    public static List<Products> saveProducts(Products products) {
        List<Products> savedProducts = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement productPreparedStatement = connection.prepareStatement(INSERT_PRODUCTS_QUERY);
            productPreparedStatement.setString(1, products.getName());
            productPreparedStatement.setString(2, products.getDescription());
            productPreparedStatement.setString(3, products.getAvailable());
            productPreparedStatement.setString(4, products.getAmount());
            productPreparedStatement.setString(5, products.getPrice());
            productPreparedStatement.executeUpdate();

            savedProducts = getAllProducts();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return savedProducts;
    }

    public static List<Products> updateProducts(int id, String amount, String available, String price) {
        List<Products> updatedProducts = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement productPreparedStatement = connection.prepareStatement(UPDATE_PRODUCTS_QUERY);
            productPreparedStatement.setString(1, amount);
            productPreparedStatement.setString(2, available);
            productPreparedStatement.setString(3, price);
            productPreparedStatement.setInt(4, id);
            productPreparedStatement.executeUpdate();

            updatedProducts = getAllProducts();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return updatedProducts;
    }

    public static List<Products> deleteProducts(int id) {
        List<Products> deletedProducts = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement productPreparedStatement = connection.prepareStatement(DELETE_PRODUCTS_QUERY);
            productPreparedStatement.setInt(1, id);
            productPreparedStatement.execute();

            deletedProducts = getAllProducts();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return deletedProducts;
    }

    public static List<Users> saveUsers(Users users) {
        List<Users> savedUsers = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement userPreparedStatement = connection.prepareStatement(INSERT_USERS_QUERY);
            userPreparedStatement.setString(1, users.getName());
            userPreparedStatement.setString(2, users.getSurname());
            userPreparedStatement.setInt(3, users.getId());

            userPreparedStatement.executeUpdate();

            savedUsers = getAllUsers();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return savedUsers;
    }
}