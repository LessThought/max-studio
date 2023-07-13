package com.screen.mapper;

import com.screen.pojo.MaxStudioShare;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 小柴
 * @since 2023-07-06
 */
@Mapper
public interface MaxStudioShareMapper extends BaseMapper<MaxStudioShare> {
    void addShare(Long screenId,String qrcodeAddress);


}
