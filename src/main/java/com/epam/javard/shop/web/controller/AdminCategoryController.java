package com.epam.javard.shop.web.controller;

import com.epam.javard.shop.dto.Category;
import com.epam.javard.shop.dto.Role;
import com.epam.javard.shop.service.CategoryService;
import com.epam.javard.shop.web.manager.UserManager;
import com.epam.javard.shop.web.validator.CategoryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "admin/category")
public class AdminCategoryController {

    @Autowired
    private CategoryValidator validator;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserManager userManager;

    @GetMapping("all")
    public String products (Model model) {

        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("user", userManager.getCurrentUser());

        return "admin/categories";
    }

    @GetMapping("create")
    public String create(Model model) {

        model.addAttribute("category", new Category());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("action", "create");
        model.addAttribute("user", userManager.getCurrentUser());

        return "admin/category";
    }


    @PostMapping("create")
    public String submitCreate(Model model, Category category, BindingResult result) {

        validator.validate(category, result);
        if (!result.hasErrors()) {

            categoryService.create(category);

            return "redirect:all";
        }

        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("action", "create");
        model.addAttribute("user", userManager.getCurrentUser());

        return "admin/category";
    }


    @GetMapping("{id}/update")
    public String update(Model model, @PathVariable Long id) {

        model.addAttribute("category", categoryService.getCategoryById(id));
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("action", "update");
        model.addAttribute("user", userManager.getCurrentUser());

        return "admin/category";
    }


    @PostMapping("{id}/update")
    public String update(Model model, Category category, BindingResult result) {

        validator.validate(category, result);
        if (!result.hasErrors()) {

            categoryService.update(category);

            return "redirect:../all";
        }

        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("action", "update");
        model.addAttribute("user", userManager.getCurrentUser());

        return "admin/category";
    }


    @GetMapping("{id}/delete")
    public String delete(@PathVariable Long id) {

        categoryService.delete(id);

        return "redirect:../all";
    }


    @ExceptionHandler(Exception.class)
    public String exception(Model model, Exception e) {
        model.addAttribute("message", e.getLocalizedMessage());
        return "error";
    }

}
