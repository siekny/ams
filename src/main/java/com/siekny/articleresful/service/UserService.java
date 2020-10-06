package com.siekny.articleresful.service;

import com.siekny.articleresful.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getOneUser(int id);
    Boolean deleteUser(int id);
    Boolean updateUser(int id, User user);
    Boolean addUser(User user);
    User getUserByEmail(String email);
}
