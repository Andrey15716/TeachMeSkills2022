package jdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.model.Products;
import jdbc.model.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CRUDUtils {
    private static String GET_ALL_PRODUCTS_QUERY = "SELECT * FROM product";
    private static String GET_ALL_USERS_QUERY = "SELECT * FROM usr";
    private static String INSERT_PRODUCTS_QUERY = "INSERT INTO product(name, descr,availab,amount,price) VALUES(?,?,?,?,?)";
    private static String INSERT_USERS_QUERY = "INSERT INTO usr(name, surname) VALUES(?,?)";
    private static String UPDATE_PRODUCTS_QUERY = "UPDATE product SET availab = ? WHERE idp =?";
    private static String DELETE_PRODUCTS_QUERY = "DELETE FROM product WHERE idp = ?";

    public static List<Products> getAllProducts() {
        List<Products> productsList = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS_QUERY);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String descr = rs.getString("descr");
                String availab = rs.getString("availab");
                String amount = rs.getString("amount");
                String price = rs.getString("price");
                int idp = rs.getInt("idp");
                productsList.add(new Products(idp, name, descr, availab, amount, price));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return productsList;
    }

    public static List<Products> saveProducts(Products products) {
        List<Products> savedProducts = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS_QUERY);
            preparedStatement.setString(1, products.getName());
            preparedStatement.setString(2, products.getDescr());
            preparedStatement.setString(3, products.getAvailab());
            preparedStatement.setString(4, products.getAmount());
            preparedStatement.setString(5, products.getPrice());
            preparedStatement.executeUpdate();

            savedProducts = getAllProducts();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return savedProducts;
    }

    public static List<Products> updateProducts(int idp, String amount, String availab, String price) {
        List<Products> updatedProducts = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCTS_QUERY);
            preparedStatement.setString(1, amount);
            preparedStatement.setString(2, availab);
            preparedStatement.setString(2, price);
            preparedStatement.setInt(1, idp);
            preparedStatement.executeUpdate();

            updatedProducts = getAllProducts();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return updatedProducts;
    }

    public static List<Products> deleteProducts(int idp) {
        List<Products> deletedProducts = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCTS_QUERY);
            preparedStatement.setInt(1, idp);
            preparedStatement.execute();

            deletedProducts = getAllProducts();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return deletedProducts;
    }

    public static List<Users> getAllUsers() {
        List<Users> usersList = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS_QUERY);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int id_usr = rs.getInt("id_usr");
                usersList.add(new Users(id_usr, name, surname));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return usersList;
    }

    public static List<Users> saveUsers(Users users) {
        List<Users> savedUsers = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_QUERY);
            preparedStatement.setString(2, users.getName());
            preparedStatement.setString(2, users.getSurname());
            preparedStatement.setInt(1, users.getId_usr());
            preparedStatement.executeUpdate();

            savedUsers = getAllUsers();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return savedUsers;
    }
}