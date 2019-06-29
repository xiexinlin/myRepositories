package com.xiedapao.service.impl;

import com.xiedapao.mapper.CommodityMapper;
import com.xiedapao.pojo.Bill;
import com.xiedapao.pojo.Commodity;
import com.xiedapao.pojo.Page;
import com.xiedapao.pojo.Type;
import com.xiedapao.service.CommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Resource
    private CommodityMapper commodityMapper;

    @Override
    public List<Commodity> show() {
        return commodityMapper.selectAll();
    }

    @Override
    public Commodity showOne(Commodity commodity) {
        return commodityMapper.selectById(commodity);
    }

    @Override
    public int addCommodity(Commodity commodity) {
        return commodityMapper.insertCommodity(commodity);
    }

    @Override
    public int updateTotalSale(Bill bill) {
        return commodityMapper.updateTotalSale(bill);
    }

    @Override
    public List<Commodity> showByType(Type type) {
        return commodityMapper.selectByType(type);
    }

    @Override
    public List<Commodity> showPageByType(Page page, Type type) {
        return commodityMapper.selectPageByType(page, type);
    }

    @Override
    public List<Commodity> showPage(Page page) {
        return commodityMapper.selectPage(page);
    }

    @Override
    public int updCommodity(Commodity commodity) {
        return commodityMapper.updCommodity(commodity);
    }
}
