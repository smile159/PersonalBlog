package com.xinxin.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author smile
 * @ClassName RequestLogUtils.java
 * @Description 请求的日志打印
 * @createTime 2022年03月29日 15:20:00
 */
@Slf4j
public class RequestLogUtils {
    public static void logTimeAndMsg(String msg){
        log.info(DateTimeUtils.getNowDateTime()+":"+msg);
    }
}
