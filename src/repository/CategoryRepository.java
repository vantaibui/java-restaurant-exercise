package repository;

import entity.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> finAll();
    Category findById(int id);
    Category save(Category category);
    void delete(int id);
}
