package com.xinxin.mapper;

import com.xinxin.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    public User queryUserById(String id);


    @Select("select * from user where name=#{name}")
    public User queryUserByName(String name);
}
