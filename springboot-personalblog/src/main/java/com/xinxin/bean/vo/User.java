package com.xinxin.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//接受用户发来的参数
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String u;
    String p;
}
