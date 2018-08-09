package com.epam.javard.shop.repository;

import com.epam.javard.shop.dto.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByCategoryId(Long id);
}
