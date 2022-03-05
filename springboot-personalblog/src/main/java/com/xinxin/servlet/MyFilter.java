package com.xinxin.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = {"/css/*", "/images/*"})
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("开始过滤...");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("doFilter开始工作了");
    }

    @Override
    public void destroy() {
        log.info("销毁了...");
    }
}
