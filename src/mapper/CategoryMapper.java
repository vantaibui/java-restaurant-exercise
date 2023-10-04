package mapper;

import dto.CategoryDTO;
import entity.Category;

public class CategoryMapper {
    private static CategoryMapper INSTANCE;

    private CategoryMapper() {
    }

    public static CategoryMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CategoryMapper();
        }
        return INSTANCE;
    }

    public Category toEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        return category;
    }

    public CategoryDTO toDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        return categoryDTO;
    }
}
