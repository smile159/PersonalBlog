package com.xinxin.controller;

import com.xinxin.bean.vo.User;
import com.xinxin.mapper.UserMapper;
import com.xinxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class LoginController {

    @Autowired
    UserService userService;


    @PostMapping("/login")
    public HashMap<String,String> login(@RequestBody User user){//user包含账户和面膜
        System.out.println("接受到的数据user = "+user);
        com.xinxin.bean.User mysqlUser;
        // 查询数据库是否存在该用户？
        mysqlUser = userService.queryUserByName(user.getU());
        HashMap<String,String> response_data = new HashMap<>();
        if (mysqlUser != null){
            // 对比密码是否正确
            System.out.println("前端数据为："+user.getP()+"后端数据为："+mysqlUser.getPassword());
            if (user.getP().equals(mysqlUser.getPassword())){
                response_data.put("status","1");
                response_data.put("msg","登录成功！！！");
            }else{
                response_data.put("status","2");
                response_data.put("msg","用户名或密码错误");
            }
        }else{
            response_data.put("status","2");
            response_data.put("msg","此用户不存在！！！");
        }
        return response_data;
    }
}
