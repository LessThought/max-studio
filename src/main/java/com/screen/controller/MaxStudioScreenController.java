package com.screen.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.screen.common.constant.MessageConstant;
import com.screen.common.exception.ScreenNotFoundException;
import com.screen.pojo.MaxStudioScreen;
import com.screen.pojo.dto.MaxStudioLargeScreenDTO;
import com.screen.result.R;
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
@RequestMapping("/screen")
@Slf4j
@Api(tags = "大屏管理")
public class MaxStudioScreenController {

    @Autowired
    private MaxStudioScreenService maxStudioScreenService;


    /**
     * 传入Json添加大屏
     * @param maxStudioScreen
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("增加大屏")
    public R<MaxStudioScreen> saveScreen(@RequestBody MaxStudioScreen maxStudioScreen) {

        log.info("新增大屏：{}",maxStudioScreen);
        maxStudioScreenService.save(maxStudioScreen);
        return R.success(maxStudioScreen);

    }


    /**
     * 根据名称查询大屏对象
     * @param screenName
     * @return
     */
    @GetMapping("/listByName")
    @ApiOperation("大屏名称查询")
    public R<MaxStudioScreen> getScreenByName(@RequestParam("name") String screenName) {
        MaxStudioScreen screen = maxStudioScreenService.getByName(screenName);
        if (screen == null)  {
            throw new ScreenNotFoundException(MessageConstant.SCREEN_NOT_FOUND);
        }
        return R.success(screen);
    }
    /**
     * 查询list
     * @return
     */
    @RequestMapping("/list")
    @ApiOperation("查询所有大屏")
    public R<List<MaxStudioLargeScreenDTO>> getScreen() {

        List<MaxStudioLargeScreenDTO> maxStudioLargeScreenDTOS = maxStudioScreenService.listScreen();

        return R.success(maxStudioLargeScreenDTOS);
    }



    /**
     * 分页查询大屏
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/listScreens")
    @ApiOperation("分页查询大屏")
    public R<Page<MaxStudioScreen>> listScreen(Long page , Long pageSize) {
        Page<MaxStudioScreen> maxStudioScreenPage = maxStudioScreenService.pageScreen(page, pageSize);
        return R.success(maxStudioScreenPage);
    }

    /**
     * 根据id删除大屏
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除大屏")
    public R<String> deleteById(@PathVariable Long id) {
        maxStudioScreenService.removeById(id);
        return R.success("删除成功");
    }


    /**
     * 传入Json大屏
     * @param largeScreen
     * @return
     */
    @PutMapping("/update")
    @ApiOperation("更新大屏")
    public R<MaxStudioScreen> updateScreen(@RequestBody MaxStudioScreen largeScreen) {
        maxStudioScreenService.updateById(largeScreen);
        return R.success(largeScreen);
    }


}

