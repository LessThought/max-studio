package com.screen.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.screen.common.constant.MessageConstant;
import com.screen.common.exception.ScreenNotFoundException;
import com.screen.pojo.MaxStudioScreen;
import com.screen.result.R;
import com.screen.service.MaxStudioCatalogueService;
import com.screen.service.MaxStudioScreenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 小柴
 * @since 2023-07-06
 */
@RestController
@RequestMapping("/largeScreen")
@Slf4j
@Api(tags = "大屏管理")
public class MaxStudioScreenController {

    @Autowired
    private MaxStudioScreenService maxStudioScreenService;

    @Autowired
    private MaxStudioCatalogueService maxStudioCatalogueService;

    @PostMapping("/save")
    @ApiOperation("增加大屏")
    public R<MaxStudioScreen> saveScreen(@RequestBody MaxStudioScreen maxStudioScreen) {

        log.info("新增大屏：{}",maxStudioScreen);
        maxStudioScreenService.save(maxStudioScreen);
        return R.success(maxStudioScreen);

    }


    @GetMapping("/getScreen")
    @ApiOperation("大屏名称查询")
    public R<MaxStudioScreen> getScreenByName(@RequestParam("name") String screenName) {
        MaxStudioScreen screen = maxStudioScreenService.getByName(screenName);
        if (screen == null)  {
            throw new ScreenNotFoundException(MessageConstant.SCREEN_NOT_FOUND);
        }
        return R.success(screen);
    }


//    @RequestMapping("/getScreens/{catalogueId}")
//    @ApiOperation("查询大屏")
//    public R<List<MaxStudioScreen>> getScreen(@PathVariable Long catalogueId) {
//        List<MaxStudioScreen> largeScreens = maxStudioScreenService.selectById(catalogueId);
//
//        return R.success(largeScreens);
//    }


    @RequestMapping("/listScreens")
    @ApiOperation("分页查询大屏")
    public R<Page<MaxStudioScreen>> listScreen(Long page , Long pageSize) {
        Page<MaxStudioScreen> maxStudioScreenPage = maxStudioScreenService.pageScreen(page, pageSize);
        return R.success(maxStudioScreenPage);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除大屏")
    public R<String> deleteById(@PathVariable Long id) {
        maxStudioScreenService.removeById(id);
        return R.success("删除成功");
    }


    @PutMapping("/update")
    @ApiOperation("更新大屏")
    public R<MaxStudioScreen> updateScreen(@RequestBody MaxStudioScreen largeScreen) {
        maxStudioScreenService.updateById(largeScreen);
        return R.success(largeScreen);
    }


}

