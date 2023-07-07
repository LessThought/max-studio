package com.screen.common.Handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Admin
 * @version 1.0
 * @date 2023/7/7 11:20
 */
@Component
@Slf4j
public class MyMetaObjectHandle implements MetaObjectHandler {
    /**
     * 插入操作自动填充
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("公共字段自动填充 [insert]...");
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());

    }

    /**
     * 更新操作自动填充
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("公共字段自动填充 [update]...");
        metaObject.setValue("updateTime", LocalDateTime.now());

    }
}
