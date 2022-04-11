package com.xinxin.service;

import com.xinxin.bean.User;
import com.xinxin.bean.vo.RegisterUser;


public interface UserService {
    public User queryUserById(String id);
    public User queryUserByName(String name);
    public boolean registerNewUser(RegisterUser user);
}
