package com.chinasoft.forum;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("send")
    public String Send(String userEmail){
        HtmlEmail email=new HtmlEmail();
        int n=userEmail.indexOf('@');
        String hostName=userEmail.substring(n+1);
        email.setHostName("smtp."+hostName);
        email.setCharset("utf-8");
        try {
            email.addTo(userEmail);
            email.setFrom("1194688236@qq.com","聚集地论坛");
            email.setAuthentication("1194688236@qq.com","nlqqmczegpalbagd");
            email.setSubject("邮箱验证");//设置发送主题
            String code=RandomCode();
            email.setMsg("您正在注册聚集地论坛，您的验证码为： "+code+"。 如非本人操作，请忽略本邮件。");//设置发送内容
            email.send();//进行发送
        } catch (EmailException e) {
            e.printStackTrace();
        }
        return "index";
    }

    public String RandomCode(){
        StringBuffer code=new StringBuffer();
        Random random=new Random();
        for(int i=0;i<6;i++){
            code.append(random.nextInt(10)+"");
        }
        return code.toString();
    }
}
