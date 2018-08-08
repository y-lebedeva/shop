package com.epam.javard.shop.web.validator;

import com.epam.javard.shop.dto.User;
import com.epam.javard.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class LoginValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        User user = (User) o;

        if (!userService.canBeAuthorized(user)) {
            errors.rejectValue("login", "label.validate.authError");
        }
    }
}
