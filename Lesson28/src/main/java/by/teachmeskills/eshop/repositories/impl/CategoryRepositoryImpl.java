package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.Category;
import by.teachmeskills.eshop.repositories.CategoryRepository;
import by.teachmeskills.eshop.repositories.ConnectionPool;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    private static final String GET_ALL_CATEGORIES = "SELECT * FROM eshop2.categories";
    private static final String GET_CATEGORY_BY_ID = "SELECT * FROM categories WHERE id=?";

    @Override
    public Category create(Category entity) {
        return null;
    }

    @Override
    public List<Category> read() {
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

    @Override
    public Category update(Category entity) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Category getCategoryById(int id) {
        Category category = null;
        try (Connection connection = pool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CATEGORY_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int categoryId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String imageName = resultSet.getString("image");
                category = new Category(categoryId, name, imageName);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return category;
    }
}