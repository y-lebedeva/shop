package com.epam.javard.shop.web.controller;

import com.epam.javard.shop.dto.Product;
import com.epam.javard.shop.dto.Role;
import com.epam.javard.shop.service.CategoryService;
import com.epam.javard.shop.service.ProductService;
import com.epam.javard.shop.web.manager.UserManager;
import com.epam.javard.shop.web.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "admin/product")
public class AdminProductsController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductValidator validator;

    @Autowired
    private UserManager userManager;
    

    @GetMapping("all")
    public String products (Model model) {

        model.addAttribute("products", productService.findAll());
        model.addAttribute("user", userManager.getCurrentUser());

        return "admin/products";
    }


    @GetMapping("create")
    public String create(Model model) {

        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("action", "create");
        model.addAttribute("user", userManager.getCurrentUser());

        return "admin/product";
    }


    @PostMapping("create")
    public String submitCreate(Model model, Product product, BindingResult result) {

        validator.validate(product, result);
        if (!result.hasErrors()) {

            productService.createProduct(product);

            return "redirect:all";
        }

        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("action", "create");
        model.addAttribute("user", userManager.getCurrentUser());

        return "admin/product";
    }


    @GetMapping("{id}/update")
    public String update(Model model, @PathVariable Long id) {

        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("action", "update");
        model.addAttribute("user", userManager.getCurrentUser());

        return "admin/product";
    }


    @PostMapping("{id}/update")
    public String update(Model model, Product product, BindingResult result) {

        validator.validate(product, result);
        if (!result.hasErrors()) {

            productService.updateProduct(product);

            return "redirect:../all";
        }

        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("action", "update");
        model.addAttribute("user", userManager.getCurrentUser());

        return "admin/product";
    }


    @GetMapping("{id}/delete")
    public String delete(@PathVariable Long id) {

        productService.deleteProductById(id);

        return "redirect:../all";
    }


    @ExceptionHandler(Exception.class)
    public String exception(Model model, Exception e) {
        model.addAttribute("message", e.getLocalizedMessage());
        return "error";
    }

}
