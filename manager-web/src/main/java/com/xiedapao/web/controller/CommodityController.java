package com.xiedapao.web.controller;

import com.xiedapao.mapper.TypeMapper;
import com.xiedapao.pojo.Admin;
import com.xiedapao.pojo.Commodity;
import com.xiedapao.pojo.Page;
import com.xiedapao.pojo.Type;
import com.xiedapao.service.CommodityService;
import com.xiedapao.service.TypeService;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/commodity")
@Controller
public class CommodityController {

    @Resource
    private CommodityService commodityServiceImpl;
    @Resource
    private TypeService typeServiceImpl;

    @RequestMapping("/add")
    public String addCommodity(Commodity commodity, MultipartFile file, HttpServletRequest request, HttpSession session){
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String photo = uuid+suffix;
        String path = request.getServletContext().getRealPath("commodityImages");
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path+"/"+photo));
        } catch (IOException e) {
            e.printStackTrace();
        }
        commodity.setPhoto(photo);
        Admin admin = (Admin)session.getAttribute("admin");
        commodity.setAdmin_id(admin.getId());
        int index = commodityServiceImpl.addCommodity(commodity);
        if(index>0){
            return "redirect:/commodity/show";
        }else {
            return "addCommodityFail";
        }
    }
    @RequestMapping("/show")
    public String show(Model model){
        List<Commodity> list = commodityServiceImpl.show();
        model.addAttribute("commodityList",list);
        return "commodityPage";
    }
    @RequestMapping("/main")
    public String showUser(Model model, Page page){
        List<Commodity> list = commodityServiceImpl.show();
        int totalCount = list.size();
        page.setTotalCount(totalCount);
        int totalPageNumber = 0;
        if(totalCount%page.getPage()==0){
            totalPageNumber = totalCount/page.getPage();
        }else{
            totalPageNumber = totalCount/page.getPage()+1;
        }
        page.setTotalPageNumber(totalPageNumber);
        int pageStart = (page.getPageNumber()-1)*page.getPage();
        page.setPageStart(pageStart);
        List<Commodity> commodityList = commodityServiceImpl.showPage(page);
        List<Type> typeList = typeServiceImpl.show();
        model.addAttribute("commodityList",commodityList);
        model.addAttribute("page",page);
        model.addAttribute("typeList",typeList);
        return "main";
    }
    @RequestMapping("/typeSearch")
    public String typeSearch(int id, Model model, Page page){
        Type type = new Type();
        type.setId(id);
        List<Commodity> list = commodityServiceImpl.showByType(type);
        int totalCount = list.size();
        page.setTotalCount(totalCount);
        int totalPageNumber = 0;
        if(totalCount%page.getPage()==0){
            totalPageNumber = totalCount/page.getPage();
        }else{
            totalPageNumber = totalCount/page.getPage()+1;
        }
        page.setTotalPageNumber(totalPageNumber);
        int pageStart = (page.getPageNumber()-1)*page.getPage();
        page.setPageStart(pageStart);
        List<Commodity> commodityList = commodityServiceImpl.showPageByType(page, type);
        List<Type> typeList = typeServiceImpl.show();
        model.addAttribute("commodityList",commodityList);
        model.addAttribute("page",page);
        model.addAttribute("typeList",typeList);
        return "main";
    }

    @RequestMapping("/detailed")
    public String one(Commodity commodity,Model model) {
        Commodity commodity1 = commodityServiceImpl.showOne(commodity);
        model.addAttribute("commodity", commodity1);
        return "commodityDetailedView";
    }
    @RequestMapping("/upd")
    public String udpCommodity(Commodity commodity,MultipartFile file,HttpServletRequest request){
        if(file==null){
            Commodity commodity1 = commodityServiceImpl.showOne(commodity);
            commodity.setPhoto(commodity1.getPhoto());
        }else{
            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            String uuid = UUID.randomUUID().toString();
            String photo = uuid+suffix;
            String path = request.getServletContext().getRealPath("commodityImages");
            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path+"/"+photo));
            } catch (IOException e) {
                e.printStackTrace();
            }
            commodity.setPhoto(photo);
        }
        int index = commodityServiceImpl.updCommodity(commodity);
        if(index>0){
            return "redirect:/commodity/show";
        }else{
            return "updateFail";
        }
    }
}
