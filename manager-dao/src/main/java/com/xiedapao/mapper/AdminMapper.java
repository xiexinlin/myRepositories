package com.xiedapao.mapper;

import com.xiedapao.pojo.Admin;

public interface AdminMapper {
    int insertAdmin(Admin admin);

    Admin selectByAdminnameAndPassword(Admin admin);

}
