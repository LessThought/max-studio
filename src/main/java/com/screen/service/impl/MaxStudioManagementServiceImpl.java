package com.screen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.screen.common.constant.StatusConstant;
import com.screen.mapper.MaxStudioCatalogueMapper;
import com.screen.mapper.MaxStudioManagementMapper;
import com.screen.pojo.MaxStudioManagement;
import com.screen.pojo.dto.MaxStudioManagementDTO;
import com.screen.service.MaxStudioManagementService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 小柴
 * @since 2023-07-06
 */
@Service
public class MaxStudioManagementServiceImpl extends ServiceImpl<MaxStudioManagementMapper, MaxStudioManagement> implements MaxStudioManagementService {

    @Autowired
    private MaxStudioManagementMapper maxStudioManagementMapper;

    @Autowired
    private MaxStudioCatalogueMapper maxStudioCatalogueMapper;

    /**
     * 新增大屏
     * @param managementDTO
     * @return
     */
    @Override
    public void saveScreen(MaxStudioManagementDTO managementDTO) {

        MaxStudioManagement maxStudioManagement = new MaxStudioManagement();
        // TODO
        if (managementDTO.getScreenShare().equals(StatusConstant.SHAREABLE)) {
            maxStudioManagement.setScreenShare(StatusConstant.SHAREABLE);
        } else {
            maxStudioManagement.setScreenShare(StatusConstant.UNSHAREABLE);
        }

        BeanUtils.copyProperties(managementDTO,maxStudioManagement);
        maxStudioManagementMapper.insert(maxStudioManagement);

    }




}
