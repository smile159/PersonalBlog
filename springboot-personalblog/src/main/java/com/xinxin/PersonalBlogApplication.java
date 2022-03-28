package com.xinxin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PersonalBlogApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PersonalBlogApplication.class, args);
        //String[] beanNamesForType = run.getBeanDefinitionNames();
        //for (String s : beanNamesForType) {
        //    System.out.println(s);
        //}
    }
}
