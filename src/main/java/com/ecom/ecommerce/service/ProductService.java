package com.ecom.ecommerce.service;

import com.ecom.ecommerce.model.Product;
import com.ecom.ecommerce.payload.ProductDTO;
import com.ecom.ecommerce.payload.ProductResponse;

public interface ProductService {

    ProductDTO addProduct(Long categoryId, Product product);

    ProductResponse getAllProducts();

    ProductResponse searchByCategory(Long categoryId);
}
