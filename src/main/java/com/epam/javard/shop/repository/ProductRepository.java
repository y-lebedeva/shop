package com.epam.javard.shop.repository;

import com.epam.javard.shop.dto.Product;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
