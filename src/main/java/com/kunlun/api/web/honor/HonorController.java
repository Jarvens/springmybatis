package com.kunlun.api.web.honor;

import com.kunlun.api.common.constants.Constants;
import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.common.utils.FileUploadUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;

/**
 * 云平台 - 荣誉证
 * Created by kunlun on 2017/4/19.
 */
@RestController
@RequestMapping("honor")
public class HonorController {

    /**
     * 测试图片上传  写入到服务器
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public BaseResult upload(@RequestParam CommonsMultipartFile file) throws IOException {
        String url = FileUploadUtils.upload(file, Constants.IMG_PATH);
        return BaseResult.success(url);
    }






}
