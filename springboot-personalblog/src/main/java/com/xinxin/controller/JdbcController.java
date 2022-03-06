package com.xinxin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/queryAll")
    public String queryAll(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from department");
        System.out.println(maps);
        return maps.toString();
    }


}
