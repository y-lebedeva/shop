package com.epam.javard.shop.web.validator;

import com.epam.javard.shop.dto.User;
import com.epam.javard.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
public class RegistrationValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "label.validate.firstNameEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "label.validate.lastNameEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "label.validate.loginEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "label.validate.passwordEmpty");

        if (!userService.validLogin(user.getLogin())) {
            errors.rejectValue("login", "label.validate.loginIncorrect");
        }

        if (userService.loginExists(user.getLogin())) {
            errors.rejectValue("login", "label.validate.loginExists");
        }

        if (!user.getPassword().equals(user.getConfirm())) {
            errors.rejectValue("confirm", "label.validate.notConfirmed");
        }
    }
}
