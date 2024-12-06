package com.ecom.ecommerce.repo;

import com.ecom.ecommerce.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    Category findByCategoryName(@NotBlank @Size(min = 5, message = "Category name must contain atLeast 5 characters") String categoryName);
}
