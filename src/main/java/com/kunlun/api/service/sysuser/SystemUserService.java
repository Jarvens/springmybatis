package com.kunlun.api.service.sysuser;

import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.common.result.PageResult;
import com.kunlun.api.domain.SysUser;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


/**
 * Created by kunlun on 2017/4/17.
 */
public interface SystemUserService {

    PageResult list(Integer pageNo,Integer pageSize, String key);

    Integer count(String key);

    BaseResult add(SysUser sysUser) throws InvalidKeySpecException, NoSuchAlgorithmException;

    BaseResult login(String account,String password) throws InvalidKeySpecException, NoSuchAlgorithmException;

    BaseResult updatePassword(String account,String oldPassword,String newPassword,String confirmPassword) throws InvalidKeySpecException, NoSuchAlgorithmException;

    BaseResult deleteUser(String account);

}
