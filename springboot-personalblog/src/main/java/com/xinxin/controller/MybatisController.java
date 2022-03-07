package com.xinxin.controller;

import com.xinxin.bean.MeTag;
import com.xinxin.service.MeTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisController {

    @Autowired
    MeTagService meTagService;


    @GetMapping("/metag")
    public MeTag getMeTag(@RequestParam("id") Long id){
        return meTagService.getMeTag(id);
    }

    @PostMapping("/insertMeTag")
    public MeTag insertMeTag(MeTag meTag){
        meTagService.insertMeTag(meTag);
        return meTag;
    }
}
