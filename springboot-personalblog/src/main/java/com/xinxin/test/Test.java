package com.xinxin.test;

import com.xinxin.bean.User;
import com.xinxin.bean.vo.RegisterUser;
import com.xinxin.utils.DateTimeUtils;
import org.springframework.beans.BeanUtils;

/**
 * @author smile
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2022年03月29日 14:42:00
 */
public class Test {
    public static void main(String[] args) {
        //System.out.println(Integer.MAX_VALUE);
        //System.out.println(Long.MAX_VALUE);
        //System.out.println(DateTimeUtils.getNowDateTime());
        RegisterUser registerUser = new RegisterUser();
        User user = new User();
        registerUser.setName("测试用户名");
        registerUser.setPassword("123456");
        registerUser.setRPass("123456");
        registerUser.setEmail("1174@qq.com");
        BeanUtils.copyProperties(registerUser,user);
        System.out.println(user);
    }
}
