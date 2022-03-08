package com.xinxin.mapper;

import com.xinxin.bean.MeTag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

//有了MapperScan就不用写Mapper
//@Mapper
public interface MeTagMapper {
    public MeTag getMeTag(Long id);

    @Insert("insert into me_tag(avatar,tagname) values(#{avatar},#{tagname})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void insertMeTag(MeTag meTag);
}
