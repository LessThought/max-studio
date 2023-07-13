package com.screen.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.screen.mapper.MaxStudioCatalogueMapper;
import com.screen.mapper.MaxStudioScreenMapper;
import com.screen.pojo.MaxStudioScreen;
import com.screen.pojo.dto.MaxStudioScreenDTO;
import com.screen.pojo.vo.MaxStudioCatalogueScreenVO;
import com.screen.service.MaxStudioScreenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 小柴
 * @since 2023-07-06
 */
@Service
@Slf4j
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
    public void saveScreen(MaxStudioScreenDTO managementDTO) {}

    /**
     * 根据URL查询大屏
     * @param url
     * @return
     */
    @Override
    public MaxStudioScreen selectByUrl(String url) {
       return maxStudioScreenMapper.selectByUrl(url);
    }

    /**
     * 根据目录id查询
     * @param catalogueId
     * @return
     */
    @Override
    public List<MaxStudioScreen> selectById(Long catalogueId) {
        return maxStudioScreenMapper.selectById(catalogueId);
    }

    /**
     * 根据id查询大屏列表
     * @param parentId
     * @return
     */
    @Override
    public List<MaxStudioScreen> selectByPid(Long parentId) {
        return maxStudioScreenMapper.selectByPid(parentId);
    }

    /**
     * 根据id删除大屏
     * @param parentId
     */
    @Override
    public void removeByScreenPid(Long parentId) {
        maxStudioScreenMapper.removeByScreenPid(parentId);
    }

    /**
     * 根据名称查询大屏
     * @param screenName
     * @return
     */
    @Override
    public MaxStudioScreen getByName(String screenName) {
        return maxStudioScreenMapper.getByName(screenName);
    }

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public Page<MaxStudioScreen> pageScreen(Long page, Long pageSize) {
        Page<MaxStudioScreen> page1 = new Page<>(page,pageSize);
        Page<MaxStudioScreen> page2 = maxStudioScreenMapper.selectPage(page1, null);
        return page2;
    }

    /**
     * 联表查询
     * @param id
     */
    @Override
    public List<MaxStudioCatalogueScreenVO> getScreens(Long id) {
        return maxStudioScreenMapper.getScreens(id);
    }


//    /**
//     * 根据id删除大屏
//     * @param id
//     * @return
//     */
//    public R<MaxStudioScreen> deleteById(Long id) {
//        if (maxStudioCatalogueMapper.selectById(id) == null) {
//            throw new DeletionNotAllowedException(MessageConstant.SCREEN_NOT_FOUND);
//        }
//        maxStudioManagementMapper.deleteById(id);
//        return R.success();
//    }
//
//
//    /**
//     * 根据id查询大屏
//     * @param id
//     * @return
//     */
//    public R<MaxStudioScreen> getMaxStudioScreen(Long id) {
//        // TODO
//
//        return R.success();
//    }
//
//    /**
//     * 更新大屏
//     * @param management
//     * @return
//     */
//    public R<MaxStudioScreen> updateByScreenId(MaxStudioScreen management) {
//        // TODO
//        return R.success();
//    }



}
