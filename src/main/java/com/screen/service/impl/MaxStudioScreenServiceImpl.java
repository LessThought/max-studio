package com.screen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.screen.common.constant.MessageConstant;
import com.screen.common.exception.DeletionNotAllowedException;
import com.screen.mapper.MaxStudioCatalogueMapper;
import com.screen.mapper.MaxStudioScreenMapper;
import com.screen.pojo.MaxStudioScreen;
import com.screen.pojo.dto.MaxStudioScreenDTO;
import com.screen.result.R;
import com.screen.service.MaxStudioScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 小柴
 * @since 2023-07-06
 */
@Service
public class MaxStudioScreenServiceImpl extends ServiceImpl<MaxStudioScreenMapper, MaxStudioScreen> implements MaxStudioScreenService {

    @Autowired
    private MaxStudioScreenMapper maxStudioManagementMapper;

    @Autowired
    private MaxStudioCatalogueMapper maxStudioCatalogueMapper;

    @Autowired
    private MaxStudioScreenMapper maxStudioScreenMapper;

    /**
     * 新增大屏
     * @param managementDTO
     * @return
     */
    @Override
    public void saveScreen(MaxStudioScreenDTO managementDTO) {



    }

    @Override
    public MaxStudioScreen selectByUrl(String url) {
       return maxStudioScreenMapper.selectByUrl(url);
    }

    /**
     * 根据id删除大屏
     * @param id
     * @return
     */
    public R<MaxStudioScreen> deleteById(Long id) {
        if (maxStudioCatalogueMapper.selectById(id) == null) {
            throw new DeletionNotAllowedException(MessageConstant.SCREEN_NOT_FOUND);
        }
        maxStudioManagementMapper.deleteById(id);
        return R.success();
    }


    /**
     * 根据id查询大屏
     * @param id
     * @return
     */
    public R<MaxStudioScreen> getMaxStudioScreen(Long id) {
        // TODO

        return R.success();
    }

    /**
     * 更新大屏
     * @param management
     * @return
     */
    public R<MaxStudioScreen> updateByScreenId(MaxStudioScreen management) {
        // TODO
        return R.success();
    }



}
