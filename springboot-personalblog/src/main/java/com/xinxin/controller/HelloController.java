package com.xinxin.controller;


import com.xinxin.bean.vo.LoginUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // 出现406的原因：controller使用了@ResponseBody注解，，而这个注解目的是返回json数据，但我们方法的返回值不一定是json，所以
    //在返回前需要得到你对象的所有属性和值才能转换成json格式的字符串，返回到前端，如果没有get set则会出现406

    @GetMapping("/test")
    public LoginUser test(){
        return new LoginUser("smile", "123456");
    }
}
