package com.screen.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.screen.mapper.MaxStudioCatalogueMapper;
import com.screen.mapper.MaxStudioScreenMapper;
import com.screen.pojo.MaxStudioCatalogue;
import com.screen.pojo.vo.MaxStudioCatalogVO;
import com.screen.pojo.vo.MaxStudioCatalogueScreenVO;
import com.screen.service.MaxStudioCatalogueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小柴
 * @since 2023-07-06
 */
@Service
@Slf4j
public class MaxStudioCatalogueServiceImpl extends ServiceImpl<MaxStudioCatalogueMapper, MaxStudioCatalogue> implements MaxStudioCatalogueService {

    @Autowired
    private MaxStudioCatalogueMapper catalogueMapper;


    @Autowired
    private MaxStudioScreenMapper maxStudioScreenMapper;
    @Override
    public List<Tree<String>> showCatalogue(List<MaxStudioCatalogue> list1) {
        List<MaxStudioCatalogVO> lists = CollUtil.newArrayList();

        //循环遍历目录
        list1.forEach(maxStudioCatalogue -> {
                    log.info("catalogue:{}",maxStudioCatalogue);
                    MaxStudioCatalogVO catalogVO = new MaxStudioCatalogVO();

                    //根据id连表查询到大屏
                    List<MaxStudioCatalogueScreenVO> screens = maxStudioScreenMapper.getScreens(maxStudioCatalogue.getId());
                    MaxStudioCatalogueScreenVO maxStudioCatalogueScreenVO = new MaxStudioCatalogueScreenVO();
                    //创建MaxStudioCatalogueScreenVO集合
                    List<MaxStudioCatalogueScreenVO> maxStudioScreens = new ArrayList<>();
                    screens.forEach(screen -> {
                        //大屏对象复制到maxStudioCatalogueScreenVO对象
                        BeanUtils.copyProperties(screen,maxStudioCatalogueScreenVO);
                        //将maxStudioCatalogueScreenVO对象添加到集合中
                        maxStudioScreens.add(maxStudioCatalogueScreenVO);

                    });
                    //将maxStudioCatalogueScreenVO对象集合通过set方法来复制值
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
        return list;
    }

    /**
     * 根据id查询目录
     * @param id
     * @return
     */
    @Override
    public List<MaxStudioCatalogue> getByPid(Long id) {
        return catalogueMapper.getByPid(id);
    }

    /**
     * 根据id删除目录
     * @param id
     */
    @Override
    public void removeByPid(Long id) {
        catalogueMapper.removeByPid(id);
    }


}
