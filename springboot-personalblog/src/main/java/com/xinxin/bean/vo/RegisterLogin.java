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
public class RegisterLogin {

    //用户名/昵称
    @Length(min = 1,max = 8)
    @NotBlank
    String rName;
    //用户名密码
    @Length(min = 1,max = 20)
    @NotBlank
    String rPass;
    //用户名确认密码
    @Length(min = 1,max = 20)
    @NotBlank
    String rePass;
    //用户邮箱
    @Length(min = 1,max = 15)
    @NotBlank
    @Email
    String email;



}
