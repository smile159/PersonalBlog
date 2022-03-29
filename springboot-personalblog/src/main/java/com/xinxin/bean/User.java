package com.xinxin.bean;


import cn.hutool.core.date.DateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//用户表  @Data = get set hashcode equals tostring
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //用户id
    private long id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private int identity;
    private String portraitImg;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activityTime;
    private String ipAddress;
    private int status;
}
