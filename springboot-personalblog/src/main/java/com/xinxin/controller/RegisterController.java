package com.xinxin.controller;

import com.xinxin.bean.vo.RegisterLogin;
import com.xinxin.common.Result;
import com.xinxin.service.UserService;
import lombok.extern.slf4j.Slf4j;
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
    public Result<String> registerUser(@Validated @RequestBody RegisterLogin registerLogin){
        log.info("接受到的数据为："+registerLogin);
        return Result.sussess("yes");
    }
}
