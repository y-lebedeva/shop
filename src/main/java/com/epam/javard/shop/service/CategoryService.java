package com.epam.javard.shop.service;

import com.epam.javard.shop.dto.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    void create(Category category);

    Category getCategoryById(Long id);

    void update(Category category);

    void delete(Long id);
}
