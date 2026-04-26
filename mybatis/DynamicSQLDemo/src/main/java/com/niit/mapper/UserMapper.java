package com.niit.mapper;

import com.niit.model.User;

import java.util.List;

public interface UserMapper {
    //Traditional SQL
    void insertUser(User user);
    //Dynamic SQL
    List<User> getAllUsers(User user);
    //Dynamic SQL Homework
    void updateUser(User user);
    //Traditional SQL Homework
    void deleteUser(int id);

}
