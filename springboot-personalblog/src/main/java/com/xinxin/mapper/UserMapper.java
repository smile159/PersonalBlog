package com.xinxin.mapper;

import com.xinxin.PersonalBlogApplication;
import com.xinxin.bean.SysRole;
import com.xinxin.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    public User queryUserById(String id);


    @Select("select u.id,u.name.u.password,u.status from user u where name=#{name}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username",column = "name"),
            @Result(property = "roles", column = "id", javaType = List.class,
                    many = @Many(select = "com.robod.mapper.RoleMapper.findByUid"))
    })
    public User queryUserByName(String name);


    @Select("select * from user where name=#{name}")
    public User findUserByName(String name);


    @Insert("insert into user(name,password,email,phone,identity,portrait_img,create_time,activity_time,ip_address,status) values(#{name},#{password},#{email},#{phone},#{identity},#{portraitImg},#{createTime},#{activityTime},#{ipAddress},#{status}) ")
    public int registerNewUser(User user);



    @Select("SELECT r.id, r.role_name roleName, r.role_desc roleDesc " +
            "FROM sys_role r, sys_user_role ur " +
            "WHERE r.id=ur.rid AND ur.uid=#{uid}")
    public List<SysRole> findByUid(Integer uid);


}
