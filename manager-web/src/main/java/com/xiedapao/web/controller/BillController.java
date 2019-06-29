package com.xiedapao.web.controller;

import com.xiedapao.pojo.Bill;
import com.xiedapao.pojo.Commodity;
import com.xiedapao.pojo.User;
import com.xiedapao.service.BillService;
import com.xiedapao.service.CommodityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping("/bill")
@Controller
public class BillController {
    @Resource
    private BillService billServiceImpl;
    @Resource
    private CommodityService commodityServiceImpl;
    @RequestMapping("/buy")
    public String buy(Bill bill, HttpSession session){
        User user = (User)session.getAttribute("user");
        bill.setUser_id(user.getId());
        Commodity commodity = new Commodity();
        commodity.setId(bill.getCommodity_id());
        Commodity commodity1 = commodityServiceImpl.showOne(commodity);
        bill.setCommodity_id(commodity1.getId());
        bill.setAdmin_id(commodity1.getAdmin_id());
        bill.setPrice(commodity1.getPrice());
        bill.setTotalprice(commodity1.getPrice()*bill.getQuantity());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        bill.setDate(simpleDateFormat.format(date).toString());
        int index = billServiceImpl.addBill(bill);
        int index2 = commodityServiceImpl.updateTotalSale(bill);
        if(index>0){
            return "buySuccess";
        }else{
            return "buyFail";
        }
    }
}
