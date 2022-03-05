package com.xinxin.config;

import com.xinxin.interceptor.LoginInterPector;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterPector())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/images/**");
    }
}
