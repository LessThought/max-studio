package com.screen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.screen.pojo.MaxStudioScreen;
import com.baomidou.mybatisplus.extension.service.IService;
import com.screen.pojo.dto.MaxStudioScreenDTO;
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
public interface MaxStudioScreenService extends IService<MaxStudioScreen> {

    void saveScreen(MaxStudioScreenDTO managementDTO);

    MaxStudioScreen selectByUrl(String url);


    List<MaxStudioScreen> selectById(Long catalogueId);

    List<MaxStudioScreen> selectByPid(Long parentId);

    void removeByScreenPid(Long parentId);

    MaxStudioScreen getByName(String screenName);


    Page<MaxStudioScreen> pageScreen(Long page, Long pageSize);
}
