package com.example.shortcoursebms.controllers.restcontrollers;

import com.example.shortcoursebms.models.Category;
import com.example.shortcoursebms.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryRestController {

    private CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategory(String name) {

        List<Category> categories = this.categoryService.getAllCategory(name);

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getCategoryById(@PathVariable("id") Integer id) {

        Map<String, Object> response = new HashMap<>();

        Category category = this.categoryService.getAllCategoryById(id);

        response.put("data", category);
        response.put("message", "Get category successfully!");
        response.put("status", true);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> save(@RequestBody @Valid Category category) {

        Map<String, Object> response = new HashMap<>();

        boolean status = this.categoryService.save(category);

        if (status) {
            response.put("message", "Save category Successfully!!!");
            response.put("category", category);
            response.put("status", true);

            return ResponseEntity.ok(response);
        }

        response.put("message", "ការរក្សារទុក ប្រភេទ មិនបានជោកជយ័");
        response.put("status", false);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/batch", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> saveBatch
            (@RequestBody List<Category> categories) {

        Map<String, Object> response = new HashMap<>();

        boolean status = this.categoryService.saveBatch(categories);

        if (status) {
            response.put("message", "Save batch category Successfully!!!");
            response.put("category", categories);
            response.put("status", true);

            return ResponseEntity.ok(response);
        }

        response.put("message", "ការរក្សារទុក ប្រភេទ មិនបានជោកជយ័");
        response.put("status", false);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }




    @PutMapping("")
    public ResponseEntity<Map<String, Object>> updateCategory(@RequestBody Category category) {
        Map<String, Object> response = new HashMap<>();

        boolean status = this.categoryService.updateCategory(category);

        if (status) {
            response.put("message", "update category looking good!!!");
            response.put("status", true);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteCategory(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();

        Integer status = this.categoryService.deleteCategory(id);

        if (status > 0) {
            response.put("message", "delete category looking good!!!");
            response.put("status", true);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }











}
