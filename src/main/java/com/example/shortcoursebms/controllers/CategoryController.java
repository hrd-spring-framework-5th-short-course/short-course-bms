package com.example.shortcoursebms.controllers;

import com.example.shortcoursebms.models.Category;
import com.example.shortcoursebms.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public String showAllCategory(@RequestParam(required = false) String name, Model model) {

        List<Category> categories = this.categoryService.getAllCategory(name);

        model.addAttribute("categories", categories);

        return "/admin/category/all-category";

    }





}
