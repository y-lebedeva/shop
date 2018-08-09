package com.epam.javard.shop.web.manager;

import com.epam.javard.shop.dto.Product;
import com.epam.javard.shop.service.ProductService;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BasketManager {

    private double discount = new Random().nextInt(15);

    private Map<Long, Integer> products = new HashMap<>();

    @Autowired
    private ProductService productService;

    public void addItem(long id) {
        int count = products.getOrDefault(id, 0);
        if (count > 0)
            products.replace(id, count + 1);
        else
            products.put(id, 1);
    }

    public void delItem(long id) {
        int count = products.getOrDefault(id, 0);
        if (count > 1)
            products.replace(id, count - 1);
        else
            products.remove(id);
    }

    private double getSum() {
        return products.keySet().stream()
            .mapToDouble(productId -> productService.getProductById(productId).getPrice() * products.get(productId))
            .sum();
    }

    public String toJSON() {
        List<BasketItem> items = new ArrayList<>();
        AtomicInteger productsCount = new AtomicInteger();

        products.keySet().forEach(productId -> {
            Product product = productService.getProductById(productId);
            int count = products.get(productId);
            items.add(new BasketItem(productId, product.getName(), product.getPrice(), count));
            productsCount.addAndGet(count);
        });

        Basket basket = new Basket(getSum(), discount, items, productsCount.get());

        return new GsonBuilder().create().toJson(basket);
    }


    class BasketItem {
        long id;
        String name;
        double price;
        int count;

        BasketItem(long id, String name, double price, int count) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.count = count;
        }
    }

    class Basket {
        double sum;
        double discount;
        List<BasketItem> items;
        int count;

        Basket(double sum, double discount, List<BasketItem> items, int count) {
            this.sum = sum;
            this.discount = discount;
            this.items = items;
            this.count = count;
        }
    }
}