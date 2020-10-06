package com.siekny.articleresful.repository;

import com.siekny.articleresful.model.Article;
import com.siekny.articleresful.model.Paging;
import com.siekny.articleresful.repository.provider.ArticleProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository {

    @Select("SELECT * FROM tb_article AS a " +
            "INNER JOIN tb_user AS u " +
            "   ON a.user_id = u.user_id")
    @Results({
            @Result(property = "articleId", column = "article_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "createdDate", column = "created_date"),
            @Result(property = "imageUrl", column = "image"),
            @Result(property = "user.userId", column = "user_id"),
            @Result(property = "user.userName", column = "user_name"),
            @Result(property = "user.email", column = "email"),
            @Result(property = "user.profile", column = "profile"),
            @Result(property = "category.categoryId", column = "category_id"),
            @Result(property = "category.categoryName", column = "category_name"),
            @Result(property = "category.color", column = "color"),
    })
    List<Article> getAllArticles();

    @SelectProvider(method = "getOneArticle", type = ArticleProvider.class)
    @Results({
            @Result(property = "articleId", column = "article_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "createdDate", column = "created_date"),
            @Result(property = "imageUrl", column = "image"),
            @Result(property = "user.userId", column = "user_id"),
            @Result(property = "user.userName", column = "user_name"),
            @Result(property = "user.email", column = "email"),
            @Result(property = "user.profile", column = "profile"),
            @Result(property = "category.categoryId", column = "category_id"),
            @Result(property = "category.categoryName", column = "category_name"),
            @Result(property = "category.color", column = "color"),
    })
    Article getOneArticle(int id);

//    @Select(" SELECT * FROM tb_article INNER JOIN " +
//            " tb_category ON tb_article.category_id = tb_category.category_id " +
//            " LIMIT #{limit} OFFSET #{offset}")
    @SelectProvider(method = "selectArticlesByPaging", type = ArticleProvider.class)
    @Results({
            @Result(property = "articleId", column = "article_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "createdDate", column = "created_date"),
            @Result(property = "imageUrl", column = "image"),
            @Result(property = "user.userId", column = "user_id"),
            @Result(property = "user.userName", column = "user_name"),
            @Result(property = "user.email", column = "email"),
            @Result(property = "user.profile", column = "profile"),
            @Result(property = "category.categoryId", column = "category_id"),
            @Result(property = "category.categoryName", column = "category_name"),
            @Result(property = "category.color", column = "color"),
    })
    List<Article> getArticlesByPaging(Integer userId, Integer categoryId, Paging paging, String patternSearch);

    @Delete("DELETE FROM tb_article WHERE article_id=#{id}")
    Boolean deleteArticle(int id);

    @Update("UPDATE tb_article SET title = #{article.title}, description=#{article.description}, image=#{article.imageUrl}, user_id=#{article.user.userId}, category_id=#{article.category.categoryId} WHERE article_id = #{id}")
    Boolean updateArticle(int id, Article article);

    @Insert("INSERT INTO tb_article(title, description, image, user_id, category_id) VALUES (#{title}, #{description}, #{imageUrl}, #{user.userId}, #{category.categoryId})")
    Boolean addArticle(Article article);
}
