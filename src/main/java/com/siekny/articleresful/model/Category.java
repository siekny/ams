package com.siekny.articleresful.model;

import java.time.LocalDate;

public class Category {
    private int categoryId;
    private String categoryName;
    private String color;
    private LocalDate CreatedDate;

    public Category() {
    }

    public Category(int categoryId, String categoryName, String color, LocalDate createdDate) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.color = color;
        CreatedDate = createdDate;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        CreatedDate = createdDate;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", color='" + color + '\'' +
                ", CreatedDate=" + CreatedDate +
                '}';
    }
}
