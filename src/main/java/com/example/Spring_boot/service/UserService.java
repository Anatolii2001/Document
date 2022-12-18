package com.example.Spring_boot.service;

import com.example.Spring_boot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void save(User user);
    User findById(int id);
    void update(int id, User updateUser);
    void delete(int id);
//    User isExistById(User user);
}
