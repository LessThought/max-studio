package com.screen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.screen.common.constant.FileAddressConstant;
import com.screen.common.utils.QrCodeUtils;
import com.screen.mapper.MaxStudioScreenMapper;
import com.screen.mapper.MaxStudioShareMapper;
import com.screen.pojo.MaxStudioScreen;
import com.screen.pojo.MaxStudioShare;
import com.screen.service.MaxStudioShareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 小柴
 * @since 2023-07-06
 */
@Service
@Slf4j
public class MaxStudioShareServiceImpl extends ServiceImpl<MaxStudioShareMapper, MaxStudioShare> implements MaxStudioShareService {

    @Autowired
    private MaxStudioShareMapper maxStudioShareMapper;


    @Autowired
    private MaxStudioScreenMapper maxStudioScreenMapper;

    /**
     * 新增分享
     * @param screenId
     * @param qrcodeAddress
     */
    @Override
    public void addShare(Long screenId,String qrcodeAddress) {


        maxStudioShareMapper.addShare(screenId,qrcodeAddress);
    }

    @Override
    public void share(String url,String pictureFileName) {
        MaxStudioScreen maxStudioScreen = maxStudioScreenMapper.selectByUrl(url);
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
            maxStudioShareMapper.addShare(screenId,qrcodeAddress);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void redirect(String url, String pictureFileName, HttpServletResponse response) {
        MaxStudioScreen Screen = maxStudioScreenMapper.selectByUrl(url);
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
            maxStudioShareMapper.addShare(screenId,qrcodeAddress);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
