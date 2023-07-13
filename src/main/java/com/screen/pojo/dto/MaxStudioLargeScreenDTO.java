package com.screen.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Admin
 * @version 1.0
 * @date 2023/7/13 11:51
 */
@Data
public class MaxStudioLargeScreenDTO {

    /**
     * 大屏id
     */
    private Long id;
    /**
     * 大屏名称
     */
    private String screenName;

    /**
     * 大屏当前状态，1代表开发中，2代表测试中，3代表应用中
     */
    private String currentStatus;

    /**
     * 大屏访问地址
     */
    private String accessAddress;

    /**
     * 所属的目录id
     */
    private Integer catalogId;

    /**
     * 大屏创建时间
     */
    private LocalDateTime createTime;
}
