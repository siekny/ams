package com.siekny.articleresful.service.serviceImp;

import com.siekny.articleresful.model.Category;
import com.siekny.articleresful.repository.CategoryRepository;
import com.siekny.articleresful.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    @Override
    public Category getOneCategory(int id) {
        return categoryRepository.getOneCategory(id);
    }

    @Override
    public Boolean deleteCategory(int id) {
        return categoryRepository.deleteCategory(id);
    }

    @Override
    public Boolean updateCategory(int id, Category category) {
        return categoryRepository.updateCategory(id, category);
    }

    @Override
    public Boolean addCategory(Category category) {
        return categoryRepository.addCategory(category);
    }
}
