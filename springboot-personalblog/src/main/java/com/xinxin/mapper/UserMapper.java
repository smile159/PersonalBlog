package com.xinxin.mapper;

import com.xinxin.bean.User;
import com.xinxin.bean.vo.RegisterUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    public User queryUserById(String id);


    @Select("select * from user where name=#{name}")
    public User queryUserByName(String name);


    @Insert("insert into user(name,password,email,phone,identity,portrait_img,create_time,activity_time,ip_address,status) values(#{name},#{password},#{email},#{phone},#{identity},#{portraitImg},#{createTime},#{activityTime},#{ipAddress},#{status}) ")
    public int registerNewUser(User user);
}
