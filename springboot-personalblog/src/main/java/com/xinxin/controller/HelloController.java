package com.xinxin.controller;

import com.xinxin.bean.User;
import com.xinxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public User hello(@RequestParam String id){
        return userService.queryUserById(id);
    }


    @GetMapping("/test")
    public String test(){
        return "yes";
    }
}
