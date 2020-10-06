package com.siekny.articleresful.controller;

import com.siekny.articleresful.model.Article;
import com.siekny.articleresful.model.Paging;
import com.siekny.articleresful.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@Api(value="articles", description="Operations pertaining to Articles in Online")
public class ArticleController {
    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

//    @ApiOperation(value = "View a List of Available Article",response = Iterable.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved list"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
//    })
//    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
//    public List<Article> getAllArticles() {
//        List<Article> articles = articleService.getAllArticles();
//        return articles;
//    }

    @ApiOperation(value = "View a List of Available Article",response = Iterable.class)
    @Results({
            @Result(property = "articleId", column = "article_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "createdDate", column = "created_date"),
            @Result(property = "imageUrl", column = "image"),
            @Result(property = "user.userId", column = "user_id"),
            @Result(property = "category.categoryId", column = "category_id"),
    })
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Article> getArticlesByPaging(@RequestParam(value = "userId", required = false) Integer userId,
                                             @RequestParam(value = "categoryId", required = false) Integer categoryId,
                                             @RequestParam(value = "page", required = false) Integer page,
                                             @RequestParam(value = "limit", required = false) Integer limit,
                                             @RequestParam(value = "search", required = false) String patternSearch
    ) {
        page = (page != null) ? page : 1;
        limit = (limit != null) ? limit : 10;

        Paging paging = new Paging();
        paging.setPage(page);
        paging.setLimit(limit);

        List<Article> articles = articleService.getArticlesByPaging(userId, categoryId, paging, patternSearch);
        return articles;
    }

    @ApiOperation(value = "Add a Article")
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveArticle(@RequestBody Article article) {
        System.out.println("article-body" + article);
        articleService.addArticle(article);
        return new ResponseEntity("Article saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Get One Article")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Article getOneArticle(@PathVariable Integer id) {
        Article article = articleService.getOneArticle(id);
        return article;
    }

    @ApiOperation(value = "Delete One Article")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public Boolean deleteArticle(@PathVariable Integer id) {
        System.out.println("articleId" + id);
        Boolean isDeleted = articleService.deleteArticle(id);
        return isDeleted;
    }

    @ApiOperation(value = "Update One Article")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public Boolean updateArticle(@PathVariable Integer id, @RequestBody Article article) {
        System.out.println("articleId : " + id);
        System.out.println("Article : " + article);
        Boolean isUpdated = articleService.updateArticle(id, article);
        return isUpdated;
    }
}
