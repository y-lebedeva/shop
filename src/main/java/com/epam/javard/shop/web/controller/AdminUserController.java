package com.epam.javard.shop.web.controller;

import com.epam.javard.shop.dto.Role;
import com.epam.javard.shop.dto.User;
import com.epam.javard.shop.service.UserService;
import com.epam.javard.shop.web.manager.UserManager;
import com.epam.javard.shop.web.validator.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "admin/user")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RegistrationValidator validator;

    @Autowired
    private UserManager userManager;

    @GetMapping("all")
    public String index(Model model) {

        model.addAttribute("users", userService.getAll());
        model.addAttribute("user", userManager.getCurrentUser());

        return "admin/users";
    }

    @GetMapping("create")
    public String create(Model model) {

        model.addAttribute("newUser", new User());
        model.addAttribute("roles", Role.values());
        model.addAttribute("action", "create");
        model.addAttribute("user", userManager.getCurrentUser());

        return "admin/user";
    }


    @PostMapping("create")
    public String submitCreate(Model model, @ModelAttribute("newUser") User newUser, BindingResult result) {

        validator.validate(newUser, result);
        if (!result.hasErrors()) {

            userService.create(newUser);

            return "redirect:all";
        }

        model.addAttribute("users", userService.getAll());
        model.addAttribute("action", "create");
        model.addAttribute("user", userManager.getCurrentUser());

        return "admin/user";
    }


    @GetMapping("{id}/update")
    public String update(Model model, @PathVariable Long id) {

        model.addAttribute("newUser", userService.getUserById(id));
        model.addAttribute("roles", Role.values());
        model.addAttribute("action", "update");
        model.addAttribute("user", userManager.getCurrentUser());

        return "admin/user";
    }


    @PostMapping("{id}/update")
    public String update(Model model, @ModelAttribute("newUser") User newUser, BindingResult result) {

        //validator.validate(newUser, result);
        //if (!result.hasErrors()) {

            userService.update(newUser);

            return "redirect:../all";
        //}

        //model.addAttribute("users", userService.getAll());
        //model.addAttribute("action", "update");
        //model.addAttribute("user", userManager.getCurrentUser());

        //return "admin/user";
    }


    @GetMapping("{id}/delete")
    public String delete(@PathVariable Long id) {

        userService.delete(id);

        return "redirect:../all";
    }


    @ExceptionHandler(Exception.class)
    public String exception(Model model, Exception e) {
        model.addAttribute("message", e.getLocalizedMessage());
        return "error";
    }

}
