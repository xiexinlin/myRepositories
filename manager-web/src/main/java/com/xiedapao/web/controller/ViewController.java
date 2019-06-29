package com.xiedapao.web.controller;

import com.xiedapao.pojo.Commodity;
import com.xiedapao.pojo.Type;
import com.xiedapao.service.CommodityService;
import com.xiedapao.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ViewController {

    @Resource
    private TypeService typeServiceImpl;
    @Resource
    private CommodityService commodityServiceImpl;

    @RequestMapping("/userRegisterView")
    public String userRegisterView(){
        return "userRegisterView";
    }

    @RequestMapping("/adminRegisterView")
    public String adminRegisterView(){
        return "adminRegisterView";
    }

    @RequestMapping("/adminLoginView")
    public String adminLoginView(){
        return "adminLoginView";
    }

    @RequestMapping("/addCommodityView")
    public String addCommodityView(Model model){
        List<Type> list = typeServiceImpl.show();
        model.addAttribute("list",list);
        return "addCommodityView";
    }
    @RequestMapping("/updCommodityView")
    public String updCommodity(Commodity commodity,Model model){
        Commodity commodity1 = commodityServiceImpl.showOne(commodity);
        model.addAttribute("commodity",commodity1);
        return "updCommodityView";
    }
}
