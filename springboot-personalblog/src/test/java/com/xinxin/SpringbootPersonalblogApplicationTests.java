package com.xinxin;

import com.xinxin.bean.User;
import com.xinxin.bean.vo.RegisterUser;
import com.xinxin.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootPersonalblogApplicationTests {

    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        RegisterUser registerUser = new RegisterUser();
        registerUser.setName("测试用户名");
        registerUser.setPassword("123456");
        registerUser.setRPass("123456");
        registerUser.setEmail("1174@qq.com");
        userService.registerNewUser(registerUser);
    }

}
