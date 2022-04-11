package com.xinxin.test;

import com.xinxin.bean.User;
import com.xinxin.bean.vo.RegisterUser;
import com.xinxin.utils.DateTimeUtils;
import org.springframework.beans.BeanUtils;

import java.security.SecureRandom;

/**
 * @author smile
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2022年03月29日 14:42:00
 */
public class Test {
    public static void main(String[] args) {
        String str = "123456abc";
        SecureRandom random = new SecureRandom(str.getBytes());
        System.out.println(random);
    }
}
