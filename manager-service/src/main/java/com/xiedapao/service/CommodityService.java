package com.xiedapao.service;

import com.xiedapao.pojo.Bill;
import com.xiedapao.pojo.Commodity;
import com.xiedapao.pojo.Page;
import com.xiedapao.pojo.Type;

import java.util.List;

public interface CommodityService {
    int addCommodity(Commodity commodity);

    List<Commodity> show();

    Commodity showOne(Commodity commodity);

    int updateTotalSale(Bill bill);

    int updCommodity(Commodity commodity);

    List<Commodity> showPage(Page page);

    List<Commodity> showPageByType(Page page, Type type);

    List<Commodity> showByType(Type type);
}
