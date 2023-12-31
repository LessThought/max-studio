package com.screen.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 小柴
 * @since 2023-07-06
 */
@Data
public class MaxStudioScreen implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 大屏名称
     */
    private String screenName;

    /**
     * 大屏当前状态，1代表开发中，2代表测试中，3代表应用中
     */
    private Integer currentStatus;

    /**
     * 大屏地址
     */
    private String accessAddress;


    /**
     * 逻辑删除
     */
    @TableLogic
    private Long isDeleted;

    /**
     * 所属的目录id
     */
    private Integer catalogId;

    /**
     * 大屏创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 大屏更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}
