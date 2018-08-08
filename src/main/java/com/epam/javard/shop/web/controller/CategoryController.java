package com.epam.javard.shop.web.controller;

import com.epam.javard.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("admin/categories")
    private String getAll(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "categories";
    }

}
