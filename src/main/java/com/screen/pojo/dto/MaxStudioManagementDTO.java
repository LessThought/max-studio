package com.screen.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 小柴
 * @date 2023/7/6 15:37
 */
@Data
public class MaxStudioManagementDTO implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 大屏名称
     */
    private String screenName;

    /**
     * 大屏地址
     */
    private String screenUrl;

    /**
     * 大屏分享 1：可分享 0：不可分享
     */
    private String screenShare;
}
