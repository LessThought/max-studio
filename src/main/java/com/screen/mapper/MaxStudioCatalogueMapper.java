package com.screen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.screen.pojo.MaxStudioCatalogue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 小柴
 * @since 2023-07-06
 */
@Mapper
public interface MaxStudioCatalogueMapper extends BaseMapper<MaxStudioCatalogue> {

    List<MaxStudioCatalogue> getByPid(Long id);

    void removeByPid(Long id);

//    void selectScreens(Long id);
}
