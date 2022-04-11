package com.xinxin;

import com.xinxin.config.RsaKeyProperties;
import com.xinxin.utils.RsaUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author smile
 * @ClassName RsaUtilTest.java
 * @Description TODO
 * @createTime 2022年03月31日 16:07:00
 */
@SpringBootTest
public class RsaUtilTest {

    @Autowired
    RsaKeyProperties rsaKeyProperties;


    @Test
    public void test(){
        System.out.println(rsaKeyProperties.getPublicKeyPath());
        System.out.println(rsaKeyProperties.getPrivateKeyPath());
    }

}
