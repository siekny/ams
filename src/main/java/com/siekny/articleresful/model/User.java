package com.siekny.articleresful.model;

import java.time.LocalDate;

public class User {
    private int userId;
    private String userName;
    private String email;
    private String profile;
    private LocalDate createdDate;

    public User() {
    }

    public User(int userId, String userName, String email, String profile, LocalDate createdDate) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.profile = profile;
        this.createdDate = createdDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", profile='" + profile + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
