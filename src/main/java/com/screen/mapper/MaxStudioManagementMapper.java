package com.screen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.screen.pojo.MaxStudioManagement;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 小柴
 * @since 2023-07-06
 */
@Mapper
public interface MaxStudioManagementMapper extends BaseMapper<MaxStudioManagement> {
    void saveScreen(MaxStudioManagement management);
}
