package com.screen.service;

import com.screen.pojo.MaxStudioShare;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 大屏分享表 服务类
 * </p>
 *
 * @author yixin
 * @since 2023-07-06
 */
@Service
public interface MaxStudioShareService extends IService<MaxStudioShare> {


    void addShare(Long screenId,String qrcodeAddress);

    void share(String url,String pictureFileName);

    void redirect(String url, String pictureFileName, HttpServletResponse response);
}
