package com.xinxin.service;

import com.xinxin.bean.MeTag;
import com.xinxin.mapper.MeTagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeTagService {

    @Autowired
    MeTagMapper meTagMapper;


    public MeTag getMeTag(Long id){
        return meTagMapper.getMeTag(id);
    }

    public void insertMeTag(MeTag meTag){
        meTagMapper.insertMeTag(meTag);
    }

}
