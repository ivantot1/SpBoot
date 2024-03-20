package com.example.spboot.service;


import com.example.spboot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(int UserId);

    void updateUser(int id, User user);

    User getUser(int userId);


}
