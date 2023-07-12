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
    void saveScreen(MaxStudioScreen management);

    MaxStudioScreen selectByUrl(String url);

    List<MaxStudioScreen> selectById(Long catalogueId);

    List<MaxStudioScreen> selectByPid(Long parentId);

    void removeByScreenPid(Long parentId);

    MaxStudioScreen getByName(String screenName);

    List<MaxStudioCatalogueScreenVO> getScreens(Long id);
}
