package com.xinxin;

import com.xinxin.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan
public class PersonalBlogApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PersonalBlogApplication.class, args);
        String[] beanNamesForType = run.getBeanDefinitionNames();
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        //RsaKeyProperties bean = run.getBean(RsaKeyProperties.class);
        //System.out.println(bean.getPublicKeyPath());
        //System.out.println(bean.getPrivateKeyPath());
    }
}
