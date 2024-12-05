package com.ecom.ecommerce.category;

import com.ecom.ecommerce.model.Category;
import com.ecom.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }

    @GetMapping("/api/public/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> allCategories = categoryService.getAllCategories();
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }

    @PostMapping("/api/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category) {

        categoryService.createCategory(category);

        return new ResponseEntity<>("Category created", HttpStatus.CREATED);
    }

    @DeleteMapping("/ali/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){

        try {
            categoryService.deleteCategoryById(categoryId);
            return new ResponseEntity<>("Category deleted", HttpStatus.OK);
        }
        catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("/api/admin/categories{categoryId}")
    public ResponseEntity<String> updateCategory(@PathVariable Long categoryId, @RequestBody Category category) {
        try{
            categoryService.updateCategory(category,categoryId);
            return new ResponseEntity<>("Category updated", HttpStatus.OK);
        }
        catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

}