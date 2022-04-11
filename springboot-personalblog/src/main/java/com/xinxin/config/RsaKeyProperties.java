package com.xinxin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author smile
 * @ClassName RsaKeyProperties.java
 * @Description TODO
 * @createTime 2022年04月11日 16:32:00
 */
@Data
//@EnableConfigurationProperties(RsaKeyProperties.class)
@ConfigurationProperties(prefix = "rsa")
public class RsaKeyProperties {
    private String publicKeyPath;
    private String privateKeyPath;
}
