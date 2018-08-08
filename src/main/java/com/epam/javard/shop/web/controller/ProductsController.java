package com.epam.javard.shop.web.controller;

import com.epam.javard.shop.dto.Product;
import com.epam.javard.shop.service.ProductService;
import com.epam.javard.shop.web.manager.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductsController {

    private static final int SIZE = 10;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductManager productManager;

    @GetMapping("products")
    public ModelAndView products() {
        ModelAndView modelAndView = new ModelAndView("products", "product", new Product());

//        List<Product> products = productService.getPageProducts(productManager.getNextPage(), SIZE);
        List<Product> products = productService.findAll();
        modelAndView.addObject("products", products);

        return modelAndView;

    }

}
