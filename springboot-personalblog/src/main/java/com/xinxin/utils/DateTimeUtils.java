package com.xinxin.utils;


import org.springframework.boot.logging.java.SimpleFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author smile
 * @ClassName DateTimeUtils.java
 * @Description 日期、时间工具类
 * @createTime 2022年03月29日 14:50:00
 */
public class DateTimeUtils {
    /*
    * 获取当前的时间，格式为：yyyy-MM-dd HH:mm:ss
    * */
    public static String getNowDateTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return dateFormat.format(new Date());
    }
}
