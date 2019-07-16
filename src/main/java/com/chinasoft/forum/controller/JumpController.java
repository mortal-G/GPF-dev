package com.chinasoft.forum.controller;

import com.chinasoft.forum.dal.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class JumpController {

    @RequestMapping("profile")
    public String toProfile(){
        return "profile";
    }

    @RequestMapping("updateProfile")
    public String toUpdateProfile(ModelMap modelMap, HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("User");
        modelMap.put("User",user);
        return "updateProfile";
    }
}
