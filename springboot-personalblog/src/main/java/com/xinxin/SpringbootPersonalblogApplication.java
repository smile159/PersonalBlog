package com.xinxin;

import com.xinxin.bean.Stu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringbootPersonalblogApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootPersonalblogApplication.class, args);

        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        //name是类型名词加全报名  stu-com.xinxin.bean.Stu
        Stu stu = run.getBean("stu-com.xinxin.bean.Stu", Stu.class);
        System.out.println(stu);
    }

}
