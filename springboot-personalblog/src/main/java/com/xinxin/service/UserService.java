package com.xinxin.service;

import com.xinxin.bean.User;
import com.xinxin.bean.vo.RegisterUser;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    public User queryUserById(String id);
    public User queryUserByName(String name);
    public boolean registerNewUser(RegisterUser user);
}
