package com.ecom.ecommerce.service;

import com.ecom.ecommerce.exception.APIExceptions;
import com.ecom.ecommerce.exception.ResourceNotFoundException;
import com.ecom.ecommerce.model.Category;
import com.ecom.ecommerce.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        if(categories.isEmpty()) {
            throw new APIExceptions("No Category created till now");
        }
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        Category savedCategory = categoryRepo.findByCategoryName(category.getCategoryName());
        if(savedCategory != null) {
            throw new APIExceptions("Category with the name (" + category.getCategoryName() + ") already exists!!");
        }
        categoryRepo.save(category);
    }

    @Override
    public String deleteCategoryById(Long categoryId) {
        Category deletedCategory = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId) );
        categoryRepo.delete(deletedCategory);
        return "Category deleted successfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Optional<Category> savedCategoryOptional = categoryRepo.findById(categoryId);
        Category savedCategory = savedCategoryOptional
                .orElseThrow(()  -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        category.setCategoryId(categoryId);
        savedCategory = categoryRepo.save(category);
        return savedCategory;
    }
}
