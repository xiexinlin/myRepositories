package com.xiedapao.service;

import com.xiedapao.pojo.Admin;

public interface AdminService {
    int register(Admin admin);

    Admin login(Admin admin);
}
