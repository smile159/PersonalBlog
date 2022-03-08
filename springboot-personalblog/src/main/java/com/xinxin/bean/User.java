package com.xinxin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class User {
    //不属于数据库的
    @TableField(exist = false)
    private String uname;
    @TableField(exist = false)
    private String password;

    //以下是数据库的
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
