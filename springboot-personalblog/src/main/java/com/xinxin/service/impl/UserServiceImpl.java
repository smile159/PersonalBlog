package com.xinxin.service.impl;

import cn.hutool.log.Log;
import com.xinxin.bean.User;
import com.xinxin.bean.vo.RegisterUser;
import com.xinxin.mapper.UserMapper;
import com.xinxin.service.UserService;
import com.xinxin.utils.DateTimeUtils;
import com.xinxin.utils.RequestLogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserById(String id) {
        return userMapper.queryUserById(id);
    }


    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }

    /*
    * 注册新用户
    * */
    @Override
    public boolean registerNewUser(RegisterUser user) {
        // 日志输出
        RequestLogUtils.logTimeAndMsg("注册新用户");
        User newUser = new User();
        // 将RegisterUser copy to User
        BeanUtils.copyProperties(user,newUser);
        // 手机号，暂时填充为""
        newUser.setPhone("");
        // 身份状态码，普通用户为1，管理员为2，超级管理员为3
        newUser.setIdentity(1);
        // 头像，初始随机分配
        newUser.setPortraitImg("https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png");
        // 用户创建时间
        Timestamp timestamp = new Timestamp(new Date().getTime());
        newUser.setCreateTime(timestamp);
        // 用户最后活动时间
        newUser.setActivityTime(timestamp);
        // ip地址，功能暂未实现，先给默认值
        newUser.setIpAddress("192.168.1.1");
        // 用户账号状态
        newUser.setStatus(1);
        log.info("newUser = "+newUser);
        userMapper.registerNewUser(newUser);
        return true;
    }
}
