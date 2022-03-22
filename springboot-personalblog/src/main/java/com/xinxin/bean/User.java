package com.xinxin.bean;


import lombok.Data;

import java.util.Date;

//用户表  @Data = get set hashcode equals tostring
@Data
public class User {

    //用户id
    private String id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private int identity;
    private String portraitImg;
    private Date createTime;
    private Date activityTime;
    private String ipAddress;
    private int status;
}
