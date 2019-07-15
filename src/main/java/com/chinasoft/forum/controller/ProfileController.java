package com.chinasoft.forum.controller;

import com.chinasoft.forum.configure.OnlineUserList;
import com.chinasoft.forum.dal.entity.User;
import com.chinasoft.forum.service.RedisService;
import com.chinasoft.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @ResponseBody
    @RequestMapping(value = "changePassword",method = RequestMethod.POST)
    public String changePassword(HttpServletRequest request,HttpServletResponse response){
        User user =(User)request.getSession().getAttribute("User");
        String email=user.getUserEmail();
        String password=request.getParameter("password");
        String newPassword=request.getParameter("newPassword");
        String confirmPassword=request.getParameter("confirmPassword");
        if(user.getUserPassword().equals(password)){
            if(newPassword.equals(confirmPassword)){
                userService.update(user);
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (LoginController.COOKIE_NAME.equals(cookie.getName())) {
                            redisService.remove(email+LoginController.COOKIE_NAME);
                            OnlineUserList.remove(email);
                            cookie.setMaxAge(0);
                            cookie.setPath("/");
                            response.addCookie(cookie);
                            request.getSession().removeAttribute("User");
                            user.setUserPassword(newPassword);
                            userService.update(user);
                            return "密码修改成功";
                        }
                    }
                }
            }else {
                return "两次密码不一致";
            }
        }else {
            return "密码错误";
        }
        return "出现错误";
    }
}
