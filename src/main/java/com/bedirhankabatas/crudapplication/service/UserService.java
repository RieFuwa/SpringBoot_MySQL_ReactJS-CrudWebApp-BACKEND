package com.bedirhankabatas.crudapplication.service;

import com.bedirhankabatas.crudapplication.model.User;

import java.util.List;

public interface UserService {
    User addStudent(User user);
    List<User> getAllUser();
    User getUserById(Long userId);
    String deleteUserById(Long userId);
    User updateUser(Long userId, User user);
}
