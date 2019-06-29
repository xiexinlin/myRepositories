package com.xiedapao.web.controller;

import com.xiedapao.pojo.User;
import com.xiedapao.service.UsersService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UsersService usersServiceImpl;
    @RequestMapping("/register")
    public String demo1(User user, MultipartFile file, HttpServletRequest request){
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String photo = uuid+suffix;
        String path = request.getServletContext().getRealPath("imagse");
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path+"/"+photo));
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setPhoto(photo);
        int index = usersServiceImpl.register(user);
        if(index>0){
            return "redirect:/index.jsp";
        }else{
            return "registerFail";
        }
    }
    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        User userLogin = usersServiceImpl.login(user);
        if(userLogin==null){
            return "redirect:/index.jsp";
        }else{
            session.setAttribute("user",userLogin);
            return "redirect:/commodity/main";
        }
    }
}
