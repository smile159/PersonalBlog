package com.xinxin.service.impl;

import com.xinxin.bean.MeTag;
import com.xinxin.mapper.MeTagMapper;
import com.xinxin.service.MeTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeTagServiceImpl implements MeTagService {
    @Autowired
    MeTagMapper meTagMapper;


    public MeTag getMeTag(Long id){
        return meTagMapper.getMeTag(id);
    }

    public void insertMeTag(MeTag meTag){
        meTagMapper.insertMeTag(meTag);
    }
}
