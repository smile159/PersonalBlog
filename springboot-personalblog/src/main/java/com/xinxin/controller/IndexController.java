package com.xinxin.controller;

import com.xinxin.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

    @GetMapping("/index")
    public String IndexPage(HttpSession session){
        //System.out.println(session.getAttribute("loginUser"));
        //if (session.getAttribute("loginUser") != null){
        //    log.info("登录状态！！！");
        //    return "index";
        //}else{
        //    log.info("未登录！！！");
        //    return "redirect:/login";
        //}
        return "index";

    }

    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String login(User user,HttpSession session,Model model){
        log.info("用户发送的数据为：{}",user);
        if (StringUtils.hasLength(user.getUname()) && "123456".equals(user.getPass())){
            session.setAttribute("loginUser",user);
            log.info("登录成功！！！");
            return "redirect:/index";
        }else{
            model.addAttribute("msg","账号或密码错误");
            log.info("登录失败！！！");
            return "login";
        }

    }
}
