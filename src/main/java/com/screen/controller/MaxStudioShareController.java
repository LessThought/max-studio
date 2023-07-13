package com.screen.controller;


import com.screen.pojo.MaxStudioShare;
import com.screen.result.R;
import com.screen.service.MaxStudioShareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 小柴
 * @since 2023-07-06
 */
@RestController
@RequestMapping("/share")
@Slf4j
@Api(tags = "分享管理")
public class MaxStudioShareController {

    @Autowired
    private MaxStudioShareService maxStudioShareService;

    /**
     * 根据url地址生成对应二维码图片,生成地点----目前在本地
     * @param url
     * @param pictureFileName
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("增加分享")
    public R<String> creatQRCodes(@RequestParam("url") String url, @RequestParam("name") String pictureFileName) {
        maxStudioShareService.share(url,pictureFileName);
        return  R.success("添加分享成功");
    }

    /**
     * 根据url生成二维码图片并跳转到二维码url
     * @param url
     * @param pictureFileName
     * @param response
     * @return
     */
    @PutMapping("/save")
    @ApiOperation("增加分享")
    public R<String> creatQRCodeTOUrl(@RequestParam("url") String url, @RequestParam("name") String pictureFileName, HttpServletResponse response) {
        maxStudioShareService.redirect(url,pictureFileName,response);
        return  R.success("添加分享成功");
    }

    @RequestMapping("/list")
    @ApiOperation("分享列表")
    public R<List<MaxStudioShare>> listShare() {
        return R.success(maxStudioShareService.list());

    }
}

