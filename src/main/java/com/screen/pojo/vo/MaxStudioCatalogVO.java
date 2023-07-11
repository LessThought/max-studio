package com.screen.pojo.vo;

import com.screen.pojo.MaxStudioScreen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaxStudioCatalogVO {


    private Long id;

    /**
     * 父节点id
     */
    private Long pid;

    /**
     * 目录名称
     */
    private String name;

    /**
     * 联表查询大屏集合
     */
    private List<MaxStudioScreen> maxStudioScreens;

    /**
     * 子目录列表
     */
    private List<MaxStudioCatalogVO> treeNode;

}
