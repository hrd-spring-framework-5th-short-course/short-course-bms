package com.example.shortcoursebms.services.impl;

import com.example.shortcoursebms.models.Category;
import com.example.shortcoursebms.repositories.CategoryRepository;
import com.example.shortcoursebms.services.CategoryService;
import com.example.shortcoursebms.utilities.Paginate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategory(String name) {
        return this.categoryRepository.getAllCategory(name);
    }

    @Override
    public List<Category> getAllCategoryPaginate(String name, Paginate paginate) {
        return this.categoryRepository.getAllCategoryPaginate(name, paginate);
    }

    @Override
    public int count(String name) {
        return this.categoryRepository.count(name);
    }

    @Override
    public Category getAllCategoryById(Integer id) {
        return this.categoryRepository.getAllCategoryById(id);
    }

    @Override
    public boolean save(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public boolean saveBatch(List<Category> categories) {
        return this.categoryRepository.saveBatch(categories);
    }

    @Override
    public boolean updateCategory(Category category) {
        return this.categoryRepository.updateCategory(category);
    }

    @Override
    public Integer deleteCategory(Integer id) {
        return this.categoryRepository.delete(id);
    }
}
