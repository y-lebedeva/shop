package com.epam.javard.shop.exception;

public class UserLoginError extends Exception {

    private final String message;

    public UserLoginError(String login) {
        message = "UserLoginError\n" + login + ": login not valid";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
