package com.epam.javard.shop.web.manager;

import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;

@Service
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductManager {

    private int currentPage;

    @PostConstruct
    private void init() {
        currentPage = 0;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getNextPage() {
        return ++currentPage;
    }
}
