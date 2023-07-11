package com.screen.pojo.dto;

import com.screen.pojo.MaxStudioScreen;
import lombok.Data;

import java.util.List;

/**
 * @author Admin
 * @version 1.0
 * @date 2023/7/11 12:09
 */

@Data
public class MaxStudioCatalogueScreenDTO {
    /**
     * 联表查询大屏集合
     */
   private List<MaxStudioScreen> maxStudioScreens;

}
