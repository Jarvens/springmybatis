package com.kunlun.api.web.honor;

import com.kunlun.api.common.constants.Constants;
import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.common.result.PageResult;
import com.kunlun.api.common.utils.FileUploadUtils;
import com.kunlun.api.domain.Honor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
     *
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public BaseResult upload(@RequestParam CommonsMultipartFile file) throws IOException {
        String url = FileUploadUtils.upload(file, Constants.IMG_PATH);
        return BaseResult.success(url);
    }

    /**
     * 荣誉证列表   分页   条件筛选
     *
     * @param pageNo
     * @param pageSize
     * @param honor
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageResult list(Integer pageNo, Integer pageSize, Honor honor) {
        return null;
    }

    /**
     * 荣誉证申请
     *
     * @param honor
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(@Validated Honor honor, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return BaseResult.error("param_error", bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return null;
    }

    /**
     * 荣誉证更新
     *
     * @param honor
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResult update(Honor honor, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return BaseResult.error("param_error", bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return null;
    }

    /**
     * 荣誉证审核
     * @param id
     * @param state
     * @return
     */
    @RequestMapping(value = "/audit", method = RequestMethod.POST)
    public BaseResult audit(Long id, String state) {
        return null;
    }


}
