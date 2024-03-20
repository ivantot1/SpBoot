package com.example.spboot.dao;


import com.example.spboot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(int user);

    void updateUser(int id, User user);

    User getUser(int userId);

}
