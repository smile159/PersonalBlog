package com.xinxin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/getData")
    public String test(){
        return "这是后端发送过来的数据";
    }
}