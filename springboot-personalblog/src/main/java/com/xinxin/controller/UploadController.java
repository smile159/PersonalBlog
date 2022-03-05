package com.xinxin.controller;

import com.xinxin.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class UploadController {
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam String uname,
                        @RequestParam String pass,
                        @RequestPart("headimg")MultipartFile headimg,
                        @RequestPart("wallpaper") MultipartFile[] wallpapaer) throws IOException {
        log.info("user =>{},pass =>{},headimg =>{},wallpaper =>{}",uname,pass,headimg.getName(),wallpapaer.length);
        //保存文件->头像
        String originalFilename = headimg.getOriginalFilename();
        headimg.transferTo(new File("F:/uploadtest/"+originalFilename));
        if (wallpapaer.length > 0){
            for (MultipartFile multipartFile : wallpapaer) {
                String originalFilename1 = multipartFile.getOriginalFilename();
                multipartFile.transferTo(new File("F:/uploadtest/"+originalFilename1));
            }
        }
        return "success";
    }
}
