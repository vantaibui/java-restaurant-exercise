package repository.impl;

import entity.Category;
import repository.CategoryRepository;

import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    private static final String CSV_SEPARATOR = ",";
    private static final String FILE_HEADER = "ID,NAME,PARENT_ID";
    @Override
    public List<Category> finAll() {
        return null;
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
