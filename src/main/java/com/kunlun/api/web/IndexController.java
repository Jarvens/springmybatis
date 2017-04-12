package com.kunlun.api.web;

import com.kunlun.api.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kunlun on 2017/4/12.
 */
@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        Integer count = indexService.count();
        return "查询到用户总量为---:" + count;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index1() {
        Integer count = indexService.count();
        return "查询到用户总量为---:" + count;
    }
}
