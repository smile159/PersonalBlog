package com.xinxin;

import com.xinxin.bean.User;
import com.xinxin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class SpringbootPersonalblogApplicationTests {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from department", Long.class);
        log.info("查询到的记录条数为：{}",aLong);
        log.info("数据源为：{}",dataSource.getClass());
    }



    @Test
    void queryUser(){
        User user = userMapper.selectById(1L);
        log.info("用户的信息为：{}",user);
    }


    @Test
    void testRedis(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("hello","world");
        log.info("值为：{}",valueOperations.get("hello"));
    }
}
