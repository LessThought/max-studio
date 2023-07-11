package com.screen.service;

import com.screen.pojo.MaxStudioCatalogue;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 大屏管理表 服务类
 * </p>
 *
 * @author yixin
 * @since 2023-07-06
 */
@Service
public interface MaxStudioCatalogueService extends IService<MaxStudioCatalogue> {
    List<MaxStudioCatalogue> getByPid(Long id);

    void removeByPid(Long id);


    void selectScreens(Long id);
}
