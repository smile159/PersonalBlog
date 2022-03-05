package com.xinxin.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyRegistConfig {
    @Bean
    public ServletRegistrationBean myServlet(){
        TestServlet testServlet = new TestServlet();
        return new ServletRegistrationBean(testServlet,"/my01","/my02");
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        MyFilter myFilter = new MyFilter();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/css/*"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        MyListener myListener = new MyListener();
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean(myListener);
        return servletListenerRegistrationBean;
    }

}
