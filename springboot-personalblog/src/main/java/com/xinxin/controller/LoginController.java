package com.xinxin.controller;

import com.xinxin.bean.vo.User;
import com.xinxin.common.ApiRestResponse;
import com.xinxin.mapper.UserMapper;
import com.xinxin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@Slf4j
public class LoginController {

    @Autowired
    UserService userService;


    @PostMapping("/login")
    @ResponseBody
    public ApiRestResponse<User> login(@RequestBody User user){//user包含账户和面膜
        //System.out.println("接受到的数据user = "+user);
        // 查询数据库是否存在该用户？
        com.xinxin.bean.User mysqlUser = userService.queryUserByName(user.getU());
        // 判断用户是否注册过？
        if (mysqlUser != null){
            // 密码和数据库比对成功
            if (user.getP().equals(mysqlUser.getPassword())){
                log.info("密码校验正确，数据为："+user);
                return ApiRestResponse.sussess("登录成功！！！",user);
            }else{
                log.info("密码校验失败，数据为："+user);
                // 密码对比失败，返回错误请求
                return ApiRestResponse.error("用户名或密码错误");
            }
        }else{
            log.info("此用户不存在");
            //用户不存在
            return ApiRestResponse.error("用户不存在");
        }
    }

}
