package com.screen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.screen.pojo.MaxStudioScreen;
import com.screen.pojo.vo.MaxStudioCatalogueScreenVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 小柴
 * @since 2023-07-06
 */
@Mapper
public interface MaxStudioScreenMapper extends BaseMapper<MaxStudioScreen> {
    /**
     * 对大屏数据存储
     * @param management
     */
    void saveScreen(MaxStudioScreen management);

    /**
     *
     * 传入url查询到大屏
     * @param url
     * @return
     */
    MaxStudioScreen selectByUrl(String url);

    /**
     * 根据目录id查询到集合
     * @param catalogueId
     * @return
     */
    List<MaxStudioScreen> selectById(Long catalogueId);

    /**
     * 根据pid查询集合
     * @param parentId
     * @return
     */
    List<MaxStudioScreen> selectByPid(Long parentId);

    /**
     * 根据pid删除大屏
     * @param parentId
     */
    void removeByScreenPid(Long parentId);

    /**
     * 根据大屏名称查询大屏数据对象
     * @param screenName
     * @return
     */
    MaxStudioScreen getByName(String screenName);

    /**
     * 根据id联表查询查询
     * @param id
     * @return
     */
    List<MaxStudioCatalogueScreenVO> getScreens(Long id);
}
