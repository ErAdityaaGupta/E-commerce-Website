package com.ecom.ecommerce.service;

import com.ecom.ecommerce.exception.ResourceNotFoundException;
import com.ecom.ecommerce.model.Category;
import com.ecom.ecommerce.model.Product;
import com.ecom.ecommerce.payload.ProductDTO;
import com.ecom.ecommerce.repo.CategoryRepo;
import com.ecom.ecommerce.repo.ProductRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDTO addProduct(Long categoryId, Product product) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category","categoryId",categoryId));

//        Product product = modelMapper.map(productDTO, Product.class);

        product.setImage("Default.png");
        product.setCategory(category);
        double specialPrice = product.getPrice() - ((product.getDiscount() * 0.01) * product.getPrice());

        product.setSpecialPrice(specialPrice);

        Product savedProduct = productRepo.save(product);

        return modelMapper.map(savedProduct, ProductDTO.class);
    }
}
