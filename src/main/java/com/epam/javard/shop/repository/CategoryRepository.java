package com.epam.javard.shop.repository;

import com.epam.javard.shop.dto.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
