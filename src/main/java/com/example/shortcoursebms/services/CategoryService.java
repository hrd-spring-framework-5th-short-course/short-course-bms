package com.example.shortcoursebms.services;

import com.example.shortcoursebms.models.Category;
import com.example.shortcoursebms.utilities.Paginate;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategory(String name);


    List<Category> getAllCategoryPaginate(String name, Paginate paginate);

    int count(String name);

    Category getAllCategoryById(Integer id);

    boolean save(Category category);

    boolean saveBatch(List<Category> categories);

    boolean updateCategory(Category category);

    Integer deleteCategory(Integer id);
}
