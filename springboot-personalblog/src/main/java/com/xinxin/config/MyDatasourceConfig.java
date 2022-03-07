package com.xinxin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Deprecated
//@Configuration
public class MyDatasourceConfig {


    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setFilters("stat");
        return dataSource;
    }

    @Bean
    public ServletRegistrationBean statViewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(statViewServlet,"/druid/*");
        // 设置账号密码
        HashMap map = new HashMap();
        map.put("loginUsername","xinxin");
        map.put("loginPassword","xinxin");
        statViewServletServletRegistrationBean.setInitParameters(map);
        return statViewServletServletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean druidWebStatFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> webStatFilterFilterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        webStatFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        webStatFilterFilterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return webStatFilterFilterRegistrationBean;
    }

}
