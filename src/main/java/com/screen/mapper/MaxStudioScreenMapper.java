package com.screen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.screen.pojo.MaxStudioScreen;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 小柴
 * @since 2023-07-06
 */
@Mapper
public interface MaxStudioScreenMapper extends BaseMapper<MaxStudioScreen> {
    void saveScreen(MaxStudioScreen management);

    MaxStudioScreen selectByUrl(String url);
}
