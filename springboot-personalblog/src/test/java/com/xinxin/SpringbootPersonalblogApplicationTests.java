package com.xinxin;

import com.xinxin.bean.User;
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
        User user = userService.queryUserById("2");
        System.out.println(user);
    }

}
