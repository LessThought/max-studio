package com.screen.controller;


import cn.hutool.core.lang.tree.Tree;
import com.screen.pojo.MaxStudioCatalogue;
import com.screen.pojo.MaxStudioScreen;
import com.screen.result.R;
import com.screen.service.MaxStudioCatalogueService;
import com.screen.service.MaxStudioScreenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 小柴
 * @since 2023-07-06
 */
@RestController
@RequestMapping("/catalog")
@Slf4j
@Api(tags = "文件目录管理")
public class MaxStudioCatalogueController {

    @Autowired
    private MaxStudioScreenService maxStudioScreenService;

    @Autowired
    private MaxStudioCatalogueService maxStudioCatalogueService;

    /**
     * 层级目录查询
     * @return
     */
    @RequestMapping("/list")
    @ApiOperation("目录列表展示")
    public R<List<Tree<String>>> getCatalogue() {

        log.info("----------------------------------");
        List<MaxStudioCatalogue> list1 = maxStudioCatalogueService.list();
        List<Tree<String>> trees = maxStudioCatalogueService.showCatalogue(list1);
        return R.success(trees);
    }


    /**
     * 根据传入的id删除目录
     * @param type
     * @return
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除目录")
    public R<String> deleteByCatalogueId(@RequestParam("id") Long type) {

        MaxStudioCatalogue catalog = maxStudioCatalogueService.getById(type);

        List<MaxStudioCatalogue> children = maxStudioCatalogueService.getByPid(type);
        log.info("children:{}",children.toString());
        if ( catalog != null && children != null ) {
            List<MaxStudioScreen> largeScreens = maxStudioScreenService.selectByPid(type);
            if (largeScreens.size() > 0) {
                maxStudioScreenService.removeByScreenPid(type);
            }
            maxStudioCatalogueService.removeByPid(type);
            maxStudioCatalogueService.removeById(type);
        }

        return R.success();
    }

    /**
     * 传入Json添加目录
     * @param catalog
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("添加目录")
    public R<MaxStudioCatalogue> addCatalogue(@RequestBody MaxStudioCatalogue catalog) {
        maxStudioCatalogueService.save(catalog);
        return R.success();
    }

    /**
     * 对文件进行重命名
     * @param catalog
     * @return
     */
    @PutMapping("/update")
    @ApiOperation("更新目录")
    public R<MaxStudioCatalogue> updateCatalogue(@RequestBody MaxStudioCatalogue catalog) {

        log.info("catalog:{}",catalog);
        maxStudioCatalogueService.updateById(catalog);

        return R.success(catalog);
    }

}

