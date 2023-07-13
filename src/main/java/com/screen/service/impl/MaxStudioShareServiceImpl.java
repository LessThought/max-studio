package com.screen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.screen.mapper.MaxStudioShareMapper;
import com.screen.pojo.MaxStudioShare;
import com.screen.service.MaxStudioShareService;
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



    /**
     * 新增分享
     * @param screenId
     * @param qrcodeAddress
     */
    @Override
    public void addShare(Long screenId,String qrcodeAddress) {


        maxStudioShareMapper.addShare(screenId,qrcodeAddress);
    }


}
