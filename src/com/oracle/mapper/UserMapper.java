package com.oracle.mapper;

import com.oracle.model.User;

import java.util.List;

public interface UserMapper {
    int addUser(User user);

    List<User> findAll();

    User findByUsername(String username);

}
