package com.festival.user.dao;

import com.festival.user.model.User;

import java.util.List;

public interface UserDAO {

    User getUser(String login);
    List<User> listUsers();
    void createUpdate(String login, String password, String firstName, String secondName, String email, String phone);
    void deleteUser(String login);

    }
