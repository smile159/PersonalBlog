package com.xinxin.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author smile
 * @ClassName Payload.java
 * @Description JWT负载
 * @createTime 2022年03月31日 15:33:00
 */
@Data
public class Payload<T> {
    // id
    private String id;
    // 用户信息
    private T userInfo;
    // 过期时间
    private Date expiration;
}

