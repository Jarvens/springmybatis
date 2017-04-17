package com.kunlun.api.web.sysuser;

import com.kunlun.api.common.constants.Constants;
import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.common.utils.PBKUtils;
import com.kunlun.api.domain.SysUser;
import com.kunlun.api.service.sysuser.SystemUserService;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * 云平台  -  用户
 * Created by kunlun on 2017/4/14.
 */
@RestController
@RequestMapping("sys/user")
public class SystemUserController {

    @Autowired
    private SystemUserService systemUserService;

    /**
     * 查询 云平台系统用户列表
     * 分页  条件查询
     *
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public BaseResult list(Integer pageNo, Integer pageSize, String key) {

        return systemUserService.list(pageNo, pageSize, key);
    }

    /**
     * 新增用户
     *
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(@Validated SysUser sysUser, BindingResult validResult) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (validResult.hasErrors()) {
            String errors = validResult.getAllErrors().get(0).getDefaultMessage();
            return BaseResult.error("param_error", errors);
        }
        String encryptPassword = PBKUtils.getEncryptedPassword(sysUser.getPassword(), Constants.ENCRYPT_SALT);
        sysUser.setPassword(encryptPassword);
        return systemUserService.add(sysUser);
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
     *
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public BaseResult delete(String account) {
        return null;
    }


    /**
     * 用户登录
     *
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResult login(String account, String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (StringUtils.isNullOrEmpty(account) || StringUtils.isNullOrEmpty(password)) {
            return BaseResult.error("param_error", "请输入用户名或者密码");
        }
        systemUserService.login(account,password);

        //TODO   生成Token
        return null;
    }

    /**
     * 密码修改
     *
     * @param account
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @RequestMapping(value = "/update-password", method = RequestMethod.POST)
    public BaseResult updatePassword(String account, String oldPassword, String newPassword, String confirmPassword) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (StringUtils.isNullOrEmpty(newPassword)) {
            return BaseResult.error("param_error", "请输入新密码");
        }
        if (StringUtils.isNullOrEmpty(confirmPassword)) {
            return BaseResult.error("param_error", "请输入确认密码");
        }
        return systemUserService.updatePassword(account,oldPassword,newPassword,confirmPassword);
    }


}
