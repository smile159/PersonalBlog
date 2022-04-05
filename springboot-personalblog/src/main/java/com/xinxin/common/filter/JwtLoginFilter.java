package com.xinxin.common.filter;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xinxin.bean.SysRole;
import com.xinxin.bean.SysUser;
import com.xinxin.common.RsaKeyProperties;
import com.xinxin.utils.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author smile
 * @ClassName JwtLoginFilter.java
 * @Description TODO
 * @createTime 2022年03月31日 15:43:00
 */
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private RsaKeyProperties rsaKeyProperties;

    public JwtLoginFilter(AuthenticationManager authenticationManager, RsaKeyProperties rsaKeyProperties) {
        this.authenticationManager = authenticationManager;
        this.rsaKeyProperties = rsaKeyProperties;
    }

    //这个方法是用来去尝试验证用户的
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            String name = request.getParameter("username");
            System.out.println("u = "+name);
            Map<String, String[]> parameterMap = request.getParameterMap();
            System.out.println(parameterMap);
            SysUser user = JSONObject.parseObject(request.getInputStream(),SysUser.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            user.getPassword())
            );
        } catch (Exception e) {
            try {
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                PrintWriter out = response.getWriter();
                Map<String, Object> map = new HashMap<>();
                map.put("code", HttpServletResponse.SC_UNAUTHORIZED);
                map.put("message", "账号或密码错误！");
                out.write(new ObjectMapper().writeValueAsString(map));
                out.flush();
                out.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            throw new RuntimeException(e);
        }
    }

    //成功之后执行的方法
    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        SysUser sysUser = new SysUser();
        sysUser.setName(authResult.getName());
        sysUser.setRoles((List<SysRole>) authResult.getAuthorities());
        String token = JwtUtils.generateTokenExpireInMinutes(sysUser,rsaKeyProperties.getPrivateKey(),24*60);
        response.addHeader("Authorization", "RobodToken " + token);	//将Token信息返回给用户
        try {
            //登录成功时，返回json格式进行提示
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            PrintWriter out = response.getWriter();
            Map<String, Object> map = new HashMap<String, Object>(4);
            map.put("code", HttpServletResponse.SC_OK);
            map.put("message", "登陆成功！");
            out.write(new ObjectMapper().writeValueAsString(map));
            out.flush();
            out.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}

