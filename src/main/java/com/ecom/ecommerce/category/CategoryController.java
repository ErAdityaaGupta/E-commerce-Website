package com.ecom.ecommerce.category;

import com.ecom.ecommerce.model.Category;
import com.ecom.ecommerce.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/api/public/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> allCategories = categoryService.getAllCategories();
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }

    @PostMapping("/api/public/categories")
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category created", HttpStatus.CREATED);
    }

    @DeleteMapping("/ali/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        categoryService.deleteCategoryById(categoryId);
        return new ResponseEntity<>("Category deleted", HttpStatus.OK);
    }

    @PutMapping("/api/admin/categories{categoryId}")
    public ResponseEntity<String> updateCategory(@Valid @PathVariable Long categoryId, @RequestBody Category category) {
        categoryService.updateCategory(category, categoryId);
        return new ResponseEntity<>("Category updated", HttpStatus.OK);
    }
}