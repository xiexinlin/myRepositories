package com.xiedapao.service;

import com.xiedapao.pojo.User;

import java.util.List;

public interface UsersService {
    int register(User user);

    List<User> show();

    User login(User user);
}
