package com.xinxin.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//注册Bean
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUser {

    //用户名/昵称
    @Length(min = 1,max = 8,message = "用户长度必须在1-8之间")
    @NotBlank(message = "不能为空，并且至少一个长度")
    String name;
    //用户名密码
    @Length(min = 1,max = 20)
    @NotBlank
    String password;
    //用户名确认密码
    @Length(min = 1,max = 20)
    @NotBlank
    String rPass;
    //用户邮箱
    @Length(min = 1,max = 15)
    @NotBlank
    @Email(message = "请输入正确的邮箱")
    String email;



}
