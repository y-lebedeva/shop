package com.epam.javard.shop.web.controller;

import com.epam.javard.shop.dto.User;
import com.epam.javard.shop.exception.UserLoginError;
import com.epam.javard.shop.exception.UserLoginExists;
import com.epam.javard.shop.service.UserService;
import com.epam.javard.shop.web.manager.UserManager;
import com.epam.javard.shop.web.validator.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private RegistrationValidator validator;

    @Autowired
    private UserService userService;

    @GetMapping("registration")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }


    @PostMapping("registration")
    public String registration(Model model, User user, BindingResult result) throws UserLoginError, UserLoginExists {

        validator.validate(user, result);

        if (!result.hasErrors()) {
            User registred = userService.registration(user);
            userManager.setCurrentUser(registred);

            return "redirect:products";
        }
        return "registration";
    }

}
