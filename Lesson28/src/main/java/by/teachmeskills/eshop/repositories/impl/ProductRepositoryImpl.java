package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.repositories.ConnectionPool;
import by.teachmeskills.eshop.repositories.ProductRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static final String GET_ALL_PRODUCTS_BY_CATEGORY_ID = "SELECT * FROM eshop2.products WHERE category_id=?";
    private static final String GET_ALL_PRODUCTS_BY_ORDER_ID = "SELECT eshop2.products.*\n" +
            "FROM eshop2.products\n" +
            "INNER JOIN eshop2.order_product\n" +
            "ON order_product.product_id = eshop2.products.id\n" +
            "INNER JOIN eshop2.orders\n" +
            "ON eshop2.orders.order_id = eshop2.order_product.order_id\n" +
            "WHERE eshop2.order_product.order_id = ?";
    private static final String GET_PRODUCT_BY_ID = "SELECT * FROM eshop2.products WHERE id=?";
    private static final String GET_PRODUCTS_BY_SEARCH_REQUEST = " SELECT * FROM eshop2.products WHERE name LIKE ? or description LIKE ?";

    @Override
    public Product create(Product entity) {
        return null;
    }

    @Override
    public List<Product> read() {
        return null;
    }

    @Override
    public Product update(Product entity) {
        return null;
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public List<Product> getAllProductsByOrderId(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS_BY_ORDER_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int price = rs.getInt("price");
                int categoryId = rs.getInt("category_id");
                String imageName = rs.getString("image_name");
                Product product = new Product(productId, categoryId, name, description, price, imageName);
                products.add(product);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    @Override
    public List<Product> getProductsBySearchRequest(String param) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCTS_BY_SEARCH_REQUEST);
            String s = '%' + param + '%';
            preparedStatement.setString(1, s);
            preparedStatement.setString(2, s);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int price = rs.getInt("price");
                int categoryId = rs.getInt("category_id");
                String imageName = rs.getString("image_name");
                products.add(new Product(productId, categoryId, name, description, price, imageName));
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    @Override
    public Product getProductById(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Product product = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int price = rs.getInt("price");
                int categoryId = rs.getInt("category_id");
                String imageName = rs.getString("image_name");
                product = new Product(productId, categoryId, name, description, price, imageName);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return product;
    }

    @Override
    public List<Product> getAllProductsByCategoryId(int categoryId) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS_BY_CATEGORY_ID);
            preparedStatement.setInt(1, categoryId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int price = rs.getInt("price");
                int idCategory = rs.getInt("category_id");
                String imageName = rs.getString("image_name");
                products.add(new Product(productId, idCategory, name, description, price, imageName));
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return products;
    }
}