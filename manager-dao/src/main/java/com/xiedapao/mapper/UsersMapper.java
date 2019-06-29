package com.xiedapao.mapper;

import com.xiedapao.pojo.User;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface UsersMapper {
    int insertUser(User user);

    List<User> selectAll();

    User selectByUsernameAndPassword(User user);
}
