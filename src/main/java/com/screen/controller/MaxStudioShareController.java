package com.screen.controller;


import com.screen.common.constant.FileAddressConstant;
import com.screen.common.utils.QrCodeUtils;
import com.screen.pojo.MaxStudioScreen;
import com.screen.pojo.MaxStudioShare;
import com.screen.result.R;
import com.screen.service.MaxStudioScreenService;
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

    @Autowired
    private MaxStudioScreenService maxStudioScreenService;
    /**
     * 根据url地址生成对应二维码图片,生成地点----目前在本地
     * @param url
     * @param pictureFileName
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("增加分享")
    public R<String> creatQRCodes(@RequestParam("url") String url, @RequestParam("name") String pictureFileName) {
        MaxStudioScreen maxStudioScreen = maxStudioScreenService.selectByUrl(url);
        //二维码图片存放的本地路径
        String destPath = "D:\\SoftLocation\\Code\\picture\\" + pictureFileName + ".jpg";
        try {
            //把url解析为二维码
            QrCodeUtils.encode(url, FileAddressConstant.LOCALPATH, destPath, true);
            Long id = maxStudioScreen.getId();
            MaxStudioShare maxStudioShare = MaxStudioShare.builder()
                    .screenId(id)
                    .qrcodeAddress(destPath)
                    .build();
            log.info("destPath:{}",destPath);
            Long screenId = maxStudioShare.getScreenId();
            String qrcodeAddress = maxStudioShare.getQrcodeAddress();
            maxStudioShareService.addShare(screenId,qrcodeAddress);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
        MaxStudioScreen Screen = maxStudioScreenService.selectByUrl(url);
        //二维码图片存放的本地路径
        String destPath = "D:\\SoftLocation\\Code\\picture\\" + pictureFileName + ".jpg";
        String text = "https://blog.csdn.net/weixin_43763430";
        try {
            //把url解析为二维码
            QrCodeUtils.encode(text,null,response.getOutputStream(),true);
            Long id = Screen.getId();
            MaxStudioShare maxStudioShare = MaxStudioShare.builder()
                    .screenId(id)
                    .qrcodeAddress(destPath)
                    .build();
            log.info("destPath:{}",destPath);
            Long screenId = maxStudioShare.getScreenId();
            String qrcodeAddress = maxStudioShare.getQrcodeAddress();
            maxStudioShareService.addShare(screenId,qrcodeAddress);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  R.success("添加分享成功");
    }

    @RequestMapping("/list")
    @ApiOperation("分享列表")
    public R<List<MaxStudioShare>> listShare() {
        return R.success(maxStudioShareService.list());

    }
}

