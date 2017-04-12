package com.kunlun.api.web;

import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.common.result.PageResult;
import com.kunlun.api.domain.User;
import com.kunlun.api.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kunlun on 2017/4/12.
 */
@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

    /**
     * 错误示例
     *
     * @return
     */
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public BaseResult error() {
        Integer count = indexService.count();
        User user = new User();
        user.setAddress("浙江省杭州市");
        user.setName("张三");
        user.setAge(10);
        return BaseResult.paramError();
    }

    /**
     * 成功示例
     *
     * @return
     */
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public BaseResult success() {
        User user = new User();
        user.setAddress("浙江省杭州市");
        user.setName("张三");
        user.setAge(10);
        return BaseResult.success(user);
    }

    /**
     * 分页示例
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageResult list(int pageNo, int pageSize) {
        List<User> userList = new ArrayList<>();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.forEach(item -> {
            User user = new User();
            user.setAge(item);
            user.setName("张三" + item);
            user.setAddress("杭州" + item);
            userList.add(user);
        });
        return new PageResult(userList, Long.valueOf(userList.size()), pageNo, pageSize);
    }
}
