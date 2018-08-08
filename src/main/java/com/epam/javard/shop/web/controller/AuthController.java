package com.epam.javard.shop.web.controller;

import com.epam.javard.shop.dto.User;
import com.epam.javard.shop.exception.UserLoginNotFound;
import com.epam.javard.shop.service.UserService;
import com.epam.javard.shop.web.manager.UserManager;
import com.epam.javard.shop.web.validator.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private LoginValidator validator;

    @Autowired
    private UserService userService;

    @GetMapping("login")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }


    @PostMapping("login")
    public String login(User user, BindingResult result) throws UserLoginNotFound {
        validator.validate(user, result);

        if (!result.hasErrors()) {
            User authorized = userService.authorisation(user);
            userManager.setCurrentUser(authorized);

            return "redirect:products";
        }
        return "login";
    }


    @GetMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        userManager.setCurrentUser(null);
        return "redirect:login";
    }

}
