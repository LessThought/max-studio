package com.screen.service;

import com.screen.pojo.MaxStudioScreen;
import com.baomidou.mybatisplus.extension.service.IService;
import com.screen.pojo.dto.MaxStudioScreenDTO;
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
public interface MaxStudioScreenService extends IService<MaxStudioScreen> {

    void saveScreen(MaxStudioScreenDTO managementDTO);

    MaxStudioScreen selectByUrl(String url);

}
