package com.siekny.articleresful.service;

import com.siekny.articleresful.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> getAllCategories();
    Category getOneCategory(int id);
    Boolean deleteCategory(int id);
    Boolean updateCategory(int id, Category category);
    Boolean addCategory(Category category);
}
