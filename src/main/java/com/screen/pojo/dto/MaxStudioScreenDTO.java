package com.screen.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 小柴
 * @date 2023/7/6 15:37
 */
@Data
public class MaxStudioScreenDTO implements Serializable {

    /**
     * 主键
     */
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


}
