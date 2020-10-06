package com.siekny.articleresful.service.serviceImp;

import com.siekny.articleresful.model.Article;
import com.siekny.articleresful.model.Paging;
import com.siekny.articleresful.repository.ArticleRepository;
import com.siekny.articleresful.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImp implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.getAllArticles();
    }

    @Override
    public Article getOneArticle(int id) {
        return articleRepository.getOneArticle(id);
    }

    @Override
    public List<Article> getArticlesByPaging(Integer userId, Integer categoryId, Paging paging, String patternSearch) {
        return articleRepository.getArticlesByPaging(userId, categoryId, paging, patternSearch);
    }

    @Override
    public Boolean deleteArticle(int id) {
        return articleRepository.deleteArticle(id);
    }

    @Override
    public Boolean updateArticle(int id, Article article) {
        return articleRepository.updateArticle(id, article);
    }

    @Override
    public Boolean addArticle(Article article) {
        return articleRepository.addArticle(article);
    }
}