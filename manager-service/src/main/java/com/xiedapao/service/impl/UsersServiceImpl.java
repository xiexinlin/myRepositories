package com.xiedapao.service.impl;

import com.xiedapao.mapper.UsersMapper;
import com.xiedapao.pojo.User;
import com.xiedapao.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;
    @Override
    public int register(User user) {
       return usersMapper.insertUser(user);
    }

    @Override
    public User login(User user) {
        return usersMapper.selectByUsernameAndPassword(user);
    }

    @Override
    public List<User> show() {
        return usersMapper.selectAll();
    }


}
