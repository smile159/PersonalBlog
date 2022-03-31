package com.xinxin;

import com.xinxin.utils.RsaUtils;
import org.junit.jupiter.api.Test;

/**
 * @author smile
 * @ClassName RsaUtilTest.java
 * @Description TODO
 * @createTime 2022年03月31日 16:07:00
 */
public class RsaUtilTest {

    private String privateFilePath = "F:\\auth_key\\id_key_rsa";
    private String publicFilePath = "F:\\auth_key\\id_key_rsa.pub";

    @Test
    public void generateKey() throws Exception {
        RsaUtils.generateKey(publicFilePath,privateFilePath,"Smileya",2048);
    }

    @Test
    public void getPublicKey() throws Exception {
        System.out.println(RsaUtils.getPublicKey(publicFilePath));
    }

    @Test
    public void getPrivateKey() throws Exception {
        System.out.println(RsaUtils.getPrivateKey(privateFilePath));
    }


}
