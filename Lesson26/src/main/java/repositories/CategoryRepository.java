package repositories;

import entities.Category;

import java.util.List;

public interface CategoryRepository extends BaseRepository<Category> {
    String getCategoryNameByID(int id);

    List<Category> getAllCategories();
}