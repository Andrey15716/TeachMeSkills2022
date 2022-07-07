package repositories.impl;

import entities.Category;
import repositories.CategoryRepository;
import repositories.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    private static final String GET_ALL_CATEGORIES = "SELECT * FROM eshop2.categories";
    private static final String GET_CATEGORY_NAME_BY_ID = "SELECT eshop2.categories.name FROM eshop2.categories WHERE id=?";

    @Override
    public Category create(Category entity) {
        return null;
    }

    @Override
    public List<Category> read() {
        return null;
    }

    @Override
    public Category update(Category entity) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public String getCategoryNameByID(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        String result = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CATEGORY_NAME_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                result = rs.getString("name");
            }
            connectionPool.closeConnection(connection);
        } catch (
                Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public List<Category> getAllCategories() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Category> categories = new ArrayList<>();

        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CATEGORIES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String imageName = resultSet.getString("image");
                categories.add(new Category(id, name, imageName));
            }
            connectionPool.closeConnection(connection);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return categories;
    }
}