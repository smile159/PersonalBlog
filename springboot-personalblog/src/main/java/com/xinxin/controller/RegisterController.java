package com.xinxin.controller;

import com.xinxin.bean.vo.RegisterUser;
import com.xinxin.common.Result;
import com.xinxin.service.UserService;
import com.xinxin.utils.RequestLogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RegisterController {

    @Autowired
    UserService userService;


    @PostMapping("/register")
    public Result<String> registerUser(@Validated @RequestBody RegisterUser registerUser){
        RequestLogUtils.logTimeAndMsg("注册请求，路径为：/register");
        log.info("接受到的数据为："+ registerUser);
        userService.registerNewUser(registerUser);
        return Result.sussess("yes");
    }
}
