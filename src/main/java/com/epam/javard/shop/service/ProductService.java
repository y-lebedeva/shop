package com.epam.javard.shop.service;

import com.epam.javard.shop.dto.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product createProduct(Product product);

    Product getProductById(Long id);

    void updateProduct(Product product);

    void deleteProductById(Long id);
}
