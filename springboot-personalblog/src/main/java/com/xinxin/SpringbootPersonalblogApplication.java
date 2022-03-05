package com.xinxin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@ServletComponentScan(basePackages = "com.xinxin")
@SpringBootApplication
public class SpringbootPersonalblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootPersonalblogApplication.class, args);
    }

}
