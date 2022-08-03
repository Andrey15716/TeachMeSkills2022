package by.teachmeskills.eshop.repositories;

import by.teachmeskills.eshop.entities.Category;

public interface CategoryRepository extends BaseRepository<Category> {
    Category getCategoryById(int id);
}