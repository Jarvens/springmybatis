package com.kunlun.api.web.sysrole;

import com.kunlun.api.common.annotations.AccessAnnotation;
import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.common.result.PageResult;
import com.kunlun.api.service.sysrole.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kunlun on 2017/4/18.
 */
@RestController
@RequestMapping("role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;
    /**
     * 角色列表
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    @AccessAnnotation
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageResult list(Integer pageNo,Integer pageSize,String key) {
        return null;
    }

    /**
     * 新增角色
     * @return
     */
    @AccessAnnotation
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add() {
        return null;
    }

    /**
     * 删除角色
     * @return
     */
    @AccessAnnotation
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public BaseResult delete() {
        return null;
    }

    /**
     * 更新角色
     * @return
     */
    @AccessAnnotation
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResult update() {
        return null;
    }
}
