package com.epam.javard.shop.service.impl;

import com.epam.javard.shop.dto.User;
import com.epam.javard.shop.exception.UserLoginError;
import com.epam.javard.shop.exception.UserLoginExists;
import com.epam.javard.shop.exception.UserLoginNotFound;
import com.epam.javard.shop.repository.UserRepository;
import com.epam.javard.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User authorisation(User user) throws UserLoginNotFound {

        User result = userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword()).stream().findFirst().orElse(null);

        if (result != null) {
            return result;
        }

        throw new UserLoginNotFound(user.getLogin());
    }

    @Override
    public User registration(User user) throws UserLoginError, UserLoginExists {

        if (!validateLogin(user.getLogin())) {
            throw new UserLoginError(user.getLogin());
        }

        if (userRepository.findByLogin(user.getLogin()) != null) {
            throw new UserLoginExists(user.getLogin());
        }

        return userRepository.save(user);
    }

    private boolean validateLogin(String login) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9_]{3,}");
        Matcher matcher = pattern.matcher(login);
        return matcher.find();
    }

    @Override
    public boolean canBeAuthorized(User user) {
        return userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword()) != null;
    }

    @Override
    public boolean canBeRegistered(User user) {
        return user != null
                && user.getLogin() != null
                && user.getPassword() != null
                && validateLogin(user.getLogin())
                && userRepository.findByLogin(user.getLogin()) == null;
    }
}
