package com.epam.javard.shop.web.controller;

import com.epam.javard.shop.web.manager.BasketManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasketRestController {

    @Autowired
    private BasketManager basketManager;

    @RequestMapping("product/{productId}/add")
    public String add(@PathVariable("productId") long productId) {
        basketManager.addItem(productId);
        return basketManager.toJSON();
    }

    @RequestMapping("product/{productId}/del")
    public String del(@PathVariable("productId") long productId) {
        basketManager.delItem(productId);
        return basketManager.toJSON();
    }

}
