package com.ecom.ecommerce.service;
import com.ecom.ecommerce.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    void createCategory(Category category);

    String deleteCategoryById(Long categoryId);

    Category updateCategory(Category category, Long categoryId);
}
