package com.screen;

import com.screen.common.utils.FileUtil;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

/**
 * @author Admin
 * @version 1.0
 * @date 2023/7/11 11:30
 */
public class FileTest {

        @Test
        public void test() {
            String url = "D:\\SoftLocation\\Code\\picture\\xiaochai.jpg";
            InputStream inputStreamByUrl = FileUtil.getInputStreamByUrl(url);
            System.out.println(inputStreamByUrl);
        }
}
