package com.xiedapao.web.controller;

import com.xiedapao.pojo.Admin;
import com.xiedapao.service.AdminService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RequestMapping("/admin")
@Controller
public class AdminController {
    @Resource
    private AdminService adminServiceImpl;

    @RequestMapping("/register")
    public String register(Admin admin, MultipartFile file, HttpServletRequest request){
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String photo = uuid+suffix;
        String path = request.getServletContext().getRealPath("adminImages");
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path+"/"+photo));
        } catch (IOException e) {
            e.printStackTrace();
        }
        admin.setPhoto(photo);
        int index = adminServiceImpl.register(admin);
        if(index>0){
            return "adminLoginView";
        }else{
            return "registerFail";
        }
    }
    @RequestMapping("/login")
    public String login(Admin admin, HttpSession session){
        Admin adminLogin = adminServiceImpl.login(admin);
        session.setAttribute("admin",adminLogin);
        if(adminLogin!=null){
            return "redirect:/commodity/show";
        }else{
            return "adminLoginView";
        }
    }
}
