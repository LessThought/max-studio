package com.screen.controller;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.screen.pojo.MaxStudioCatalogue;
import com.screen.pojo.MaxStudioScreen;
import com.screen.pojo.vo.MaxStudioCatalogVO;
import com.screen.pojo.vo.MaxStudioCatalogueScreenVO;
import com.screen.result.R;
import com.screen.service.MaxStudioCatalogueService;
import com.screen.service.MaxStudioScreenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        List<MaxStudioCatalogVO> lists = CollUtil.newArrayList();

        //循环遍历目录
        list1.forEach(maxStudioCatalogue -> {
            log.info("catalogue:{}",maxStudioCatalogue);
            MaxStudioCatalogVO catalogVO = new MaxStudioCatalogVO();

//            maxStudioScreenService.getById(maxStudioCatalogue.getId());
            List<MaxStudioCatalogueScreenVO> screens = maxStudioScreenService.getScreens(maxStudioCatalogue.getId());
            MaxStudioCatalogueScreenVO maxStudioCatalogueScreenVO = new MaxStudioCatalogueScreenVO();
            List<MaxStudioCatalogueScreenVO> maxStudioScreens = new ArrayList<>();
            screens.forEach(screen -> {
                BeanUtils.copyProperties(screen,maxStudioCatalogueScreenVO);
                maxStudioScreens.add(maxStudioCatalogueScreenVO);

            });
            catalogVO.setMaxStudioScreens(maxStudioScreens);
            BeanUtils.copyProperties(maxStudioCatalogue, catalogVO);
                    System.out.println(catalogVO.toString());
            lists.add(new MaxStudioCatalogVO(catalogVO.getId(), catalogVO.getPid(),catalogVO.getName(),catalogVO.getMaxStudioScreens() ,null));
        }
    );

        TreeNodeConfig config = new TreeNodeConfig();

        // 树形数据中id的属性名,写成id1方便区分,实际上写AClothClassVo实体类的id属性名
        config.setIdKey("id");

        // 展示目录深度,数据中一共10级目录
        config.setDeep(10);

        /**
         * 入参
         * tree:  最终要返回的数据
         * node:  lists数据
         *
         * 返回
         * Tree<String>
         *   Tree: 转换的实体 为数据源里的对象类型
         *   String: ID类型
         *
         */

        List<Tree<String>> list = TreeUtil.build(lists, "0", config, (node, tree) -> {

            tree.setId(node.getId().toString());
            tree.setName(node.getName());
            tree.setParentId(node.getPid().toString());
            tree.putExtra("screenList",node.getMaxStudioScreens());

        });

        return R.success(list);
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

