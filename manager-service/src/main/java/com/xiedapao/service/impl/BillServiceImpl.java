package com.xiedapao.service.impl;

import com.xiedapao.mapper.BillMapper;
import com.xiedapao.pojo.Bill;
import com.xiedapao.service.BillService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BillServiceImpl implements BillService {
    @Resource
    private BillMapper billMapper;
    @Override
    public int addBill(Bill bill) {
        return billMapper.insertBill(bill);
    }
}
