package com.xiedapao.mapper;

import com.xiedapao.pojo.Type;

import java.util.List;

public interface TypeMapper {
    int insertType(Type type);

    List<Type> selectAll();

    Type selectOne(Type type);
}
