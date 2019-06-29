package com.xiedapao.service.impl;

import com.xiedapao.mapper.AdminMapper;
import com.xiedapao.pojo.Admin;
import com.xiedapao.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;
    @Override
    public int register(Admin admin) {
        return adminMapper.insertAdmin(admin);
    }

    @Override
    public Admin login(Admin admin) {
        return adminMapper.selectByAdminnameAndPassword(admin);
    }
}
