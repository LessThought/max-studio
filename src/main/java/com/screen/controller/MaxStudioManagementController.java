package com.screen.controller;


import com.screen.pojo.MaxStudioManagement;
import com.screen.pojo.dto.MaxStudioManagementDTO;
import com.screen.result.R;
import com.screen.service.MaxStudioCatalogueService;
import com.screen.service.MaxStudioManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MaxStudioManagementController {

    @Autowired
    private MaxStudioManagementService maxStudioManagementService;

    @Autowired
    private MaxStudioCatalogueService maxStudioCatalogueService;


    @RequestMapping("/save")
    public R<MaxStudioManagement> saveScreen(@RequestBody MaxStudioManagementDTO managementDTO) {

        log.info("新增大屏：{}",managementDTO);
        //TODO
        maxStudioManagementService.saveScreen(managementDTO);
        return R.success();
    }
}

