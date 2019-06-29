package com.xiedapao.mapper;

import com.xiedapao.pojo.Bill;
import com.xiedapao.pojo.Commodity;
import com.xiedapao.pojo.Page;
import com.xiedapao.pojo.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityMapper {
    int insertCommodity(Commodity commodity);

    List<Commodity> selectAll();

    Commodity selectById(Commodity commodity);

    int updateTotalSale(Bill bill);

    int updCommodity(Commodity commodity);

    List<Commodity> selectPage(Page page);

    List<Commodity> selectPageByType(@Param("page") Page page,@Param("type") Type type);

    List<Commodity> selectByType(Type type);
}
