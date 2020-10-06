package com.siekny.articleresful.service;

import com.siekny.articleresful.model.Article;
import com.siekny.articleresful.model.Paging;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {
    List<Article> getAllArticles();
    Article getOneArticle(int id);
    List<Article> getArticlesByPaging(Integer userId, Integer categoryId, Paging paging, String patternSearch);
    Boolean deleteArticle(int id);
    Boolean updateArticle(int id, Article article);
    Boolean addArticle(Article article);
}
