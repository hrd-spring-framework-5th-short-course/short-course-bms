package com.example.shortcoursebms.controllers;

import com.example.shortcoursebms.models.Category;
import com.example.shortcoursebms.services.CategoryService;
import com.example.shortcoursebms.utilities.Paginate;
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

    @GetMapping("/all/paginate")
    public String showAllCategoryPaginate(@RequestParam(required = false) String name,
                                          Model model,
                                          Paginate paginate) {

        if (name == null)
            name = "";

        int totalRecord = this.categoryService.count(name);

        paginate.setTotalCount(totalRecord);

        List<Category> categories = this.categoryService.getAllCategoryPaginate(name, paginate);

        model.addAttribute("categories", categories);
        model.addAttribute("paginate", paginate);
        model.addAttribute("filter", name);

        return "/admin/category/all-category";

    }





}
