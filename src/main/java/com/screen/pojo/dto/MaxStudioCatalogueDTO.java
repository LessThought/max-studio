package com.screen.pojo.dto;

import lombok.Data;

/**
 * @author Admin
 * @version 1.0
 * @date 2023/7/10 18:17
 */
@Data
public class MaxStudioCatalogueDTO {


    /**
     * 主键
     */

    private Long id;

    /**
     * 目录名称
     */
    private String name;

    /**
     * 父节点id
     */
    private Long pid;
}
