package com.ecom.ecommerce.service;

import com.ecom.ecommerce.model.Category;
import com.ecom.ecommerce.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

//    private List<Category> categories = new ArrayList<>();

    private long nextId = 1L;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public List<Category> getAllCategories() {
//        return categories;
        return categoryRepo.findAll();
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
//        categories.add(category);
        categoryRepo.save(category);
    }

    @Override
    public String deleteCategoryById(Long categoryId) {

//        Optional<Category> deletedCategoryOptional =

        Category deletedCategory = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

//        category.setCategoryId(categoryId);
        categoryRepo.delete(deletedCategory);

        return "Category deleted successfully";


//        List<Category> categories = categoryRepo.findAll();
//        Category category = categories.stream()
//                .filter(c -> c.getCategoryId() == categoryId)
//                .findFirst()
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
//
//        if (category == null) {
//            return "Category not found";
//        }

//        categories.remove(category);
//        categoryRepo.delete(category);
//        return "Category deleted Successfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {

        Optional<Category> savedCategoryOptional = categoryRepo.findById(categoryId);

        Category savedCategory = savedCategoryOptional
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));

        category.setCategoryId(categoryId);

        savedCategory = categoryRepo.save(category);

        return savedCategory;

//
//        List<Category> categories = categoryRepo.findAll();
//        Optional<Category> optionalCategory = categories.stream()
//                .filter(c -> c.getCategoryId() == categoryId)
//                .findFirst();
//
//        if(optionalCategory.isPresent()) {
//            Category existingCategory = optionalCategory.get();
//            existingCategory.setCategoryName(category.getCategoryName());
//            Category savedCategory = categoryRepo.save(existingCategory);
//            return savedCategory;
//        }
//        else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
//        }
    }
}
