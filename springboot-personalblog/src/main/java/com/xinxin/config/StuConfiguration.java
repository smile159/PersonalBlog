package com.xinxin.config;


import com.xinxin.bean.Stu;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(Stu.class)
public class StuConfiguration {

    @Bean
    public Stu stu(){
        return new Stu();
    }
}
