package com.kunlun.api.web.sysuser;

import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.domain.SysUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 云平台  -  用户
 * Created by kunlun on 2017/4/14.
 */
@RestController
@RequestMapping("sys/user")
public class SystemUserController {

    /**
     * 查询 云平台系统用户列表
     * 分页  条件查询
     *
     * @param pageNo
     * @param pageSize
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public BaseResult list(Integer pageNo, Integer pageSize, SysUser sysUser) {

        return null;
    }

    /**
     * 新增用户
     *
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(SysUser sysUser) {
        return null;
    }

    /**
     * 更新用户信息
     *
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResult update(SysUser sysUser) {
        return null;
    }

    /**
     * 删除用户信息
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public BaseResult delete(SysUser sysUser) {
        return null;
    }


}
