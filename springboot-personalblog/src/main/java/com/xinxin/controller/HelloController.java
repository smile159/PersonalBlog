package com.xinxin.controller;


import com.sun.org.apache.regexp.internal.RE;
import com.xinxin.bean.vo.User;
import com.xinxin.common.ApiRestResponse;
import com.xinxin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // 出现406的原因：controller使用了@ResponseBody注解，，而这个注解目的是返回json数据，但我们方法的返回值不一定是json，所以
    //在返回前需要得到你对象的所有属性和值才能转换成json格式的字符串，返回到前端，如果没有get set则会出现406

    @GetMapping("/test")
    public User test(){
        return new User("smile", "123456");
    }
}
