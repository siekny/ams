package com.siekny.articleresful.controller;

import com.siekny.articleresful.model.Category;
import com.siekny.articleresful.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Api(value="categories", description="Operations pertaining to categories in Online")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ApiOperation(value = "View a list of available users",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<Category> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return categories;
    }

    @ApiOperation(value = "Add a category")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveProduct(@RequestBody Category category) {
        System.out.println("category-body" + category);
        categoryService.addCategory(category);
        return new ResponseEntity("Category saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Get one category")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Category getOneCategory(@PathVariable Integer id) {
        Category category = categoryService.getOneCategory(id);
        return category;
    }

    @ApiOperation(value = "Delete one category")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public Boolean deleteCategory(@PathVariable Integer id) {
        System.out.println("categoryId" + id);
        Boolean isDeleted = categoryService.deleteCategory(id);
        return isDeleted;
    }

    @ApiOperation(value = "Update one category")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public Boolean updateCategory(@PathVariable Integer id, @RequestBody Category category) {
        System.out.println("categoryId : " + id);
        System.out.println("Category : " + category);
        Boolean isUpdated = categoryService.updateCategory(id, category);
        return isUpdated;
    }
}
