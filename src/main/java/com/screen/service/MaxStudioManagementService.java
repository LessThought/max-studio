package com.screen.service;

import com.screen.pojo.MaxStudioManagement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.screen.pojo.dto.MaxStudioManagementDTO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 大屏管理表 服务类
 * </p>
 *
 * @author yixin
 * @since 2023-07-06
 */
@Service
public interface MaxStudioManagementService extends IService<MaxStudioManagement> {

    void saveScreen(MaxStudioManagementDTO managementDTO);
}
