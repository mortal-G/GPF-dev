package com.chinasoft.forum.configure.WebConfig;

import com.chinasoft.forum.configure.Interceptor.SecurityInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigure implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //SecurityInterceptor securityInterceptor=new SecurityInterceptor();
        registry.addInterceptor(new SecurityInterceptor())
                .addPathPatterns("/index");

    }
}
