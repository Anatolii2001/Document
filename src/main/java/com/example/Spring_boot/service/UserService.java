package com.example.Spring_boot.service;

import com.example.Spring_boot.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void save(User user);
    User findById(long id);
    void update(long id, User updateUser);
    void delete(long id);
    User isExistById(User user);
}
