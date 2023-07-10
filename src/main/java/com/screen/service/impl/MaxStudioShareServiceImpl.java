package com.screen.service.impl;

import com.screen.mapper.MaxStudioScreenMapper;
import com.screen.pojo.MaxStudioShare;
import com.screen.mapper.MaxStudioShareMapper;
import com.screen.service.MaxStudioShareService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 小柴
 * @since 2023-07-06
 */
@Service
public class MaxStudioShareServiceImpl extends ServiceImpl<MaxStudioShareMapper, MaxStudioShare> implements MaxStudioShareService {

    @Autowired
    private MaxStudioShareMapper maxStudioShareMapper;

    @Autowired
    private MaxStudioScreenMapper maxStudioScreenMapper;
    @Override
    public void addShare(Long screenId,String qrcodeAddress) {


        maxStudioShareMapper.addShare(screenId,qrcodeAddress);
    }


}
