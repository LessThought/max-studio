package com.screen.controller;


import com.screen.pojo.MaxStudioScreen;
import com.screen.pojo.dto.MaxStudioScreenDTO;
import com.screen.result.R;
import com.screen.service.MaxStudioCatalogueService;
import com.screen.service.MaxStudioScreenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小柴
 * @since 2023-07-06
 */
@RestController
@RequestMapping("/maxStudio/screen")
@Slf4j
@Api(tags = "大屏管理")
public class MaxStudioScreenController {

    @Autowired
    private MaxStudioScreenService maxStudioManagementService;

    @Autowired
    private MaxStudioCatalogueService maxStudioCatalogueService;


    @PostMapping("/save")
    public R<MaxStudioScreen> saveScreen(@RequestBody MaxStudioScreenDTO maxStudioScreenDTO) {

        log.info("新增大屏：{}",maxStudioScreenDTO);
        //TODO


        return R.success();
    }


    @PostMapping("/save1")
    @ApiOperation("新增大屏")
    public R<MaxStudioScreen> saveScreen1(@RequestBody MaxStudioScreen management) {


        //TODO

        return R.success();
    }
}

