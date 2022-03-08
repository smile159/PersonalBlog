package com.xinxin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xinxin.bean.User;
import com.xinxin.mapper.UserMapper;
import com.xinxin.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
