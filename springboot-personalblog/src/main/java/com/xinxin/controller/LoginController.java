package com.xinxin.controller;

import com.xinxin.bean.vo.LoginUser;
import com.xinxin.common.Result;
import com.xinxin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@Validated
public class LoginController {

    @Autowired
    UserService userService;


    @PostMapping("/login")
    @ResponseBody
    public Result<LoginUser> login(@Validated @RequestBody LoginUser loginUser){//user包含账户和面膜
        //System.out.println("接受到的数据user = "+loginUser);
        // 查询数据库是否存在该用户？
        com.xinxin.bean.User mysqlUser = userService.queryUserByName(loginUser.getU());
        // 判断用户是否注册过？
        if (mysqlUser != null){
            // 密码和数据库比对成功
            if (loginUser.getP().equals(mysqlUser.getPassword())){
                log.info("密码校验正确，数据为："+ loginUser);
                return Result.sussess("登录成功！！！", loginUser);
            }else{
                log.info("密码校验失败，数据为："+ loginUser);
                // 密码对比失败，返回错误请求
                return Result.error("用户名或密码错误");
            }
        }else{
            log.info("此用户不存在");
            //用户不存在
            return Result.error("用户不存在");
        }
    }

}
