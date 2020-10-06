package com.siekny.articleresful.service.serviceImp;

import com.siekny.articleresful.model.User;
import com.siekny.articleresful.repository.UserRepository;
import com.siekny.articleresful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getOneUser(int id) {
        return userRepository.getOneUser(id);
    }

    @Override
    public Boolean deleteUser(int id) {
        return userRepository.deleteUser(id);
    }

    @Override
    public Boolean updateUser(int id, User user) {
        return userRepository.updateUser(id, user);
    }

    @Override
    public Boolean addUser(User user) {
        return userRepository.addUser(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}
