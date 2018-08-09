package com.epam.javard.shop.web.controller;

import com.epam.javard.shop.dto.Category;
import com.epam.javard.shop.service.CategoryService;
import com.epam.javard.shop.service.ProductService;
import com.epam.javard.shop.web.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductsController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserManager userManager;

    @GetMapping("products")
    public String products(Model model) {

        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);

        model.addAttribute("products", productService.getProductsByCategoryId(null));

        model.addAttribute("user", userManager.getCurrentUser());
        model.addAttribute("pageName", "products");

        return "products";
    }

}
