package com.xinxin.service.impl;

import com.xinxin.bean.User;
import com.xinxin.mapper.UserMapper;
import com.xinxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
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
}
