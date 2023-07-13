package com.screen.service.impl;

import com.screen.pojo.MaxStudioCatalogue;
import com.screen.mapper.MaxStudioCatalogueMapper;
import com.screen.service.MaxStudioCatalogueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 小柴
 * @since 2023-07-06
 */
@Service
public class MaxStudioCatalogueServiceImpl extends ServiceImpl<MaxStudioCatalogueMapper, MaxStudioCatalogue> implements MaxStudioCatalogueService {

    @Autowired
    private MaxStudioCatalogueMapper catalogueMapper;

    /**
     * 根据id查询目录
     * @param id
     * @return
     */
    @Override
    public List<MaxStudioCatalogue> getByPid(Long id) {
        return catalogueMapper.getByPid(id);
    }

    /**
     * 根据id删除目录
     * @param id
     */
    @Override
    public void removeByPid(Long id) {
        catalogueMapper.removeByPid(id);
    }

//    @Override
//    public void selectScreens(Long id) {
//        catalogueMapper.selectScreens(id);
//    }
}
