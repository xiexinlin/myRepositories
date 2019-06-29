package com.xiedapao.service;

import com.xiedapao.mapper.TypeMapper;
import com.xiedapao.pojo.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {
    int addCommodity(Type type);

    List<Type> show();

    Type getByName(Type type);
}
