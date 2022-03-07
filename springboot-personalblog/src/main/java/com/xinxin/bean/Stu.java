package com.xinxin.bean;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//第一种方法
@ConfigurationProperties(prefix = "stu")

public class Stu {
    private String name;
    public Stu() {
    }
    public Stu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                '}';
    }
}



