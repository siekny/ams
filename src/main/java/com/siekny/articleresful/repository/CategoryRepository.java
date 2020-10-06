package com.siekny.articleresful.repository;

import com.siekny.articleresful.model.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository {

    @Select("SELECT * FROM tb_category")
    @Results({
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "categoryName", column = "category_name"),
            @Result(property = "createdDate", column = "created_date"),
    })
    List<Category> getAllCategories();

    @Select("SELECT * FROM tb_category WHERE category_id=#{id}")
    @Results({
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "categoryName", column = "category_name"),
    })
    Category getOneCategory(int id);

    @Delete("DELETE FROM tb_category WHERE category_id=#{id}")
    Boolean deleteCategory(int id);

    @Update("UPDATE tb_category SET category_name = #{category.categoryName}, color = #{category.color} WHERE category_id = #{id}")
    Boolean updateCategory(int id, Category category);

    @Insert("INSERT INTO tb_category(category_name, color) VALUES (#{categoryName}, #{color})")
    Boolean addCategory(Category category);
}
