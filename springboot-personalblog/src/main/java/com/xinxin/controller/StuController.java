package com.xinxin.controller;

import com.xinxin.bean.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StuController {

    @Autowired
    Stu stu;

    @GetMapping("/getStu")
    public String getStu(){
        return stu.toString();
    }
}
