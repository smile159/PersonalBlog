package com.xinxin.common;

import com.xinxin.utils.RsaUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author smile
 * @ClassName RsaKeyProperties.java
 * @Description TODO
 * @createTime 2022年03月31日 15:35:00
 */
@Component
@EnableConfigurationProperties(RsaKeyProperties.class)
@Data
@ConfigurationProperties("rsa.key")     //指定配置文件的key
public class RsaKeyProperties {

    private String pubKeyPath;

    private String priKeyPath;

    private PublicKey publicKey;
    private PrivateKey privateKey;

    @PostConstruct
    public void createKey() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }
}

