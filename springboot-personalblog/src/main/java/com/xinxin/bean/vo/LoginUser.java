package com.xinxin.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//接受用户发来的参数
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {

    // 定义约束注解

    @NotNull
    @Size(min = 1,max = 8)
    String u;

    // 密码要求，最小6位 最高20位（防止有人恶意设置超长密码）
    @NotNull
    @Size(min = 6,max = 20)
    String p;
}
