package com.kunlun.api.common.utils;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传工具类
 * Created by kunlun on 2017/4/19.
 */
public class FileUploadUtils {

    public static String upload(CommonsMultipartFile file, String path) throws IOException {
        existDir(path);
        String filePath = path+file.getOriginalFilename();
        File url = new File(filePath);
        file.transferTo(url);
        return filePath;

    }

    /**
     * 检查文件目录是否存在,不存在就创建
     *
     * @param path
     */
    private static void existDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

}
