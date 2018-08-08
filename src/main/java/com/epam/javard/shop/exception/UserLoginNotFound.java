package com.epam.javard.shop.exception;

public class UserLoginNotFound extends Exception {

    private final String message;

    public UserLoginNotFound(String login) {
        message = login + ": user not found";
    }

    @Override
    public String getMessage() {
        return message;
    }
}