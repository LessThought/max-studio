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

    /**
     * 根据pid查询目录集合数据
     * @param id
     * @return
     */
    List<MaxStudioCatalogue> getByPid(Long id);

    /**
     * 根据id删除目录数据
     * @param id
     */
    void removeByPid(Long id);


}
