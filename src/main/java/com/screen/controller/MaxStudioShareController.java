package com.screen.controller;


import com.screen.common.constant.FileAddressConstant;
import com.screen.common.utils.QrCodeUtils;
import com.screen.pojo.MaxStudioScreen;
import com.screen.pojo.MaxStudioShare;
import com.screen.result.R;
import com.screen.service.MaxStudioScreenService;
import com.screen.service.MaxStudioShareService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小柴
 * @since 2023-07-06
 */
@RestController
@RequestMapping("/maxStudio/share")
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
    @PostMapping("/createLogoQRCodes")
    public R<String> creatQRCodes(String url, String pictureFileName) {
        MaxStudioScreen maxStudioScreen = maxStudioScreenService.selectByUrl(url);

        String destPath = "D:\\SoftLocation\\Code\\picture\\" + pictureFileName + ".jpg";
        try {
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
}

