package com.epam.javard.shop.exception;

public class UserLoginExists extends Exception {

    private final String message;

    public UserLoginExists(String login) {
        message = "UserLoginExists\n" + login + ": login is exits";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
