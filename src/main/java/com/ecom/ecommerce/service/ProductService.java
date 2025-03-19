package com.ecom.ecommerce.service;

import com.ecom.ecommerce.model.Product;
import com.ecom.ecommerce.payload.ProductDTO;

public interface ProductService {

    ProductDTO addProduct(Long categoryId, Product product);
}
