package com.epam.javard.shop.web.controller;

import com.epam.javard.shop.dto.Product;
import com.epam.javard.shop.service.CategoryService;
import com.epam.javard.shop.service.ProductService;
import com.epam.javard.shop.web.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "admin/product")
public class AdminProductsController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductValidator validator;
    

    @GetMapping("all")
    public String products (Model model) {

        model.addAttribute("products", productService.findAll());

        return "admin/products";
    }


    @GetMapping("create")
    public String create(Model model) {

        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("action", "create");

        return "admin/product";
    }


    @PostMapping("create")
    public String submitCreate(Product product, BindingResult result) {
        validator.validate(product, result);
        if (!result.hasErrors()) {

            productService.createProduct(product);

            return "redirect:all";
        }
        return "admin/product";
    }


    @GetMapping("{id}/update")
    public String update(Model model, @PathVariable Long id) {

        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("action", "update");

        return "admin/product";
    }


    @PostMapping("{id}/update")
    public String update(Product product, BindingResult result) {
        validator.validate(product, result);
        if (!result.hasErrors()) {

            productService.updateProduct(product);

            return "redirect:../all";
        }
        return "admin/product";
    }


    @GetMapping("{id}/delete")
    public String delete(Model model, @PathVariable Long id) {

        return "admin/product";
    }

}
