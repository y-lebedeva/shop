package com.epam.javard.shop.dto;

public enum Role {
    ADMIN,
    MANAGER,
    USER;

    private final String name;

    private Role() {
        this.name = this.name();
    }

    public String getName() {
        return name;
    }
}
