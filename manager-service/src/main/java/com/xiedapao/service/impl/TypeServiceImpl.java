package com.xiedapao.service.impl;

import com.xiedapao.mapper.TypeMapper;
import com.xiedapao.pojo.Type;
import com.xiedapao.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TypeServiceImpl implements TypeService {

    @Resource
    private TypeMapper typeMapper;
    @Override
    public int addCommodity(Type type) {
        return typeMapper.insertType(type);
    }

    @Override
    public List<Type> show() {
        return typeMapper.selectAll();
    }

    @Override
    public Type getByName(Type type) {
        return typeMapper.selectOne(type);
    }
}
