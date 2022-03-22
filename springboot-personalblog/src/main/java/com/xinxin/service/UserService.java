package com.xinxin.service;

import com.xinxin.bean.User;


public interface UserService {
    public User queryUserById(String id);
    public User queryUserByName(String name);
}
