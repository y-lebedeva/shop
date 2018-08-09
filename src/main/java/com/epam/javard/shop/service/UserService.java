package com.epam.javard.shop.service;

import com.epam.javard.shop.dto.User;
import com.epam.javard.shop.exception.UserLoginError;
import com.epam.javard.shop.exception.UserLoginExists;
import com.epam.javard.shop.exception.UserLoginNotFound;

public interface UserService {

    User authorisation(User user) throws UserLoginNotFound;

    User registration(User user) throws UserLoginError, UserLoginExists;

    boolean canBeAuthorized(User user);

    boolean validLogin(String login);

    boolean loginExists(String login);
}
