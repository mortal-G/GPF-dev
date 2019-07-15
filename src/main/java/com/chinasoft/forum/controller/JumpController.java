package com.chinasoft.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

    @RequestMapping("profile")
    public String toProfile(){
        return "profile";
    }

    @RequestMapping("updateProfile")
    public String toUpdateProfile(){
        return "updateProfile";
    }
}
