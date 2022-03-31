package com.xinxin.config;

import com.xinxin.common.RsaKeyProperties;
import com.xinxin.common.filter.JwtLoginFilter;
import com.xinxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author smile
 * @ClassName WebSecurityConfig.java
 * @Description TODO
 * @createTime 2022年03月31日 15:44:00
 */
@Configuration
@EnableWebSecurity      //这个注解的意思是这个类是Spring Security的配置类
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService UserService;
    @Autowired
    private RsaKeyProperties rsaKeyProperties;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //认证用户的来源
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(UserService).passwordEncoder(passwordEncoder());
    }

    //配置SpringSecurity相关信息
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()  //关闭csrf
                .addFilter(new JwtLoginFilter(super.authenticationManager(), rsaKeyProperties))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);    //禁用session
    }

}
