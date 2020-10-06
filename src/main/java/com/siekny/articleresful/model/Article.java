package com.siekny.articleresful.model;

import java.time.LocalDate;

public class Article {
    private int articleId;
    private String title;
    private String description;
    private LocalDate createdDate;
    private String imageUrl;
    private User user;
    private Category category;

    public Article() {
    }

    public Article(int articleId, String title, String description, LocalDate createdDate, String imageUrl, User user, Category category) {
        this.articleId = articleId;
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.imageUrl = imageUrl;
        this.user = user;
        this.category = category;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Article1{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", imageUrl=" + imageUrl +
                ", user=" + user +
                ", category=" + category +
                '}';
    }
}
