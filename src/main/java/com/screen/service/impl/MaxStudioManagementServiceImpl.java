package com.screen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.screen.common.constant.MessageConstant;
import com.screen.common.constant.StatusConstant;
import com.screen.common.exception.DeletionNotAllowedException;
import com.screen.mapper.MaxStudioCatalogueMapper;
import com.screen.mapper.MaxStudioManagementMapper;
import com.screen.pojo.MaxStudioManagement;
import com.screen.pojo.dto.MaxStudioManagementDTO;
import com.screen.result.R;
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


}
