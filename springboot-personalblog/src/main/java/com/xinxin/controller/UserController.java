package com.xinxin.controller;

import com.xinxin.bean.User;
import com.xinxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {


    @Autowired
    //@Resource
    UserService userService;

    @GetMapping("/queryAllUser")
    public List<User> queryAll(){
        List<User> list = userService.list();
        System.out.println(list);
        return list;
    }
}
