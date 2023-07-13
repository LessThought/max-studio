package com.screen.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.screen.common.constant.StatusConstant;
import com.screen.mapper.MaxStudioScreenMapper;
import com.screen.pojo.MaxStudioScreen;
import com.screen.pojo.dto.MaxStudioLargeScreenDTO;
import com.screen.pojo.dto.MaxStudioScreenDTO;
import com.screen.pojo.vo.MaxStudioCatalogueScreenVO;
import com.screen.service.MaxStudioScreenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小柴
 * @since 2023-07-06
 */
@Service
@Slf4j
public class MaxStudioScreenServiceImpl extends ServiceImpl<MaxStudioScreenMapper, MaxStudioScreen> implements MaxStudioScreenService {

    @Autowired
    private MaxStudioScreenMapper maxStudioScreenMapper;

    /**
     * 查询大屏集合
     * @return
     */
    @Override
    public List<MaxStudioLargeScreenDTO> listScreen() {

        List<MaxStudioScreen> largeScreens = maxStudioScreenMapper.selectById();


        List<MaxStudioLargeScreenDTO> objects = new ArrayList<>();
        largeScreens.forEach(largeScreen -> {
            MaxStudioLargeScreenDTO largeScreenDTO = new MaxStudioLargeScreenDTO ();
            if (largeScreen.getCurrentStatus() == 1) {
                largeScreenDTO.setCurrentStatus(StatusConstant.DEVELOPING);
            } else if ((largeScreen.getCurrentStatus() == 2)) {
                largeScreenDTO.setCurrentStatus(StatusConstant.TESTING);
            } else {
                largeScreenDTO.setCurrentStatus(StatusConstant.APPLICATION);
            }
//                (largeScreen.getCurrentStatus() == 2 )? largeScreenDTO.setCurrentStatus(StatusConstant.TESTING) :largeScreenDTO.setCurrentStatus(StatusConstant.APPLICATION);

            largeScreenDTO.setId(largeScreen.getId());
            largeScreenDTO.setScreenName(largeScreen.getScreenName());
            largeScreenDTO.setAccessAddress(largeScreen.getAccessAddress());
            largeScreenDTO.setCreateTime(largeScreen.getCreateTime());
            largeScreenDTO.setCatalogId(largeScreen.getCatalogId());
            objects.add(largeScreenDTO);
        });

        return objects;
    }
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
     * @return
     */
    @Override
    public List<MaxStudioScreen> selectById() {

        return maxStudioScreenMapper.selectById();
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


}
