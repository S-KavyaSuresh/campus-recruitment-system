package com.example.Campus_Recruitment.service;

import java.util.List;

import com.example.Campus_Recruitment.model.User;

public interface UserService {
    User addUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, User user);
}
