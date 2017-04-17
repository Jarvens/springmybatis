package com.kunlun.api.service.sysuser;

import com.kunlun.api.common.constants.Constants;
import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.common.result.PageCommon;
import com.kunlun.api.common.result.PageResult;
import com.kunlun.api.common.utils.PBKUtils;
import com.kunlun.api.dao.sysuser.SystemUserDao;
import com.kunlun.api.domain.SysUser;
import com.mysql.jdbc.StringUtils;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

/**
 * Created by kunlun on 2017/4/17.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SystemUserServiceImpl implements SystemUserService, PageCommon {

    @Autowired
    private SystemUserDao systemUserDao;

    /**
     * 关键字搜索   列表查询    分页
     *
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, String key) {
        if (!StringUtils.isNullOrEmpty(key)) {
            key = "%" + key + "%";
        }
        Integer count = this.count(key);
        if (count > 0) {
            List<SysUser> list = systemUserDao.list(rowBounds(pageNo, pageSize), key);
            return new PageResult(list, count, pageNo, pageSize);
        }
        return new PageResult(null, 0);
    }

    /**
     * 查询count数量
     *
     * @param key
     * @return
     */
    @Override
    public Integer count(String key) {
        return systemUserDao.count(key);
    }

    @Override
    public BaseResult add(SysUser sysUser) {
        Integer validAccount = systemUserDao.validAccount(sysUser.getAccount());
        if (validAccount > 0) {
            return BaseResult.error("account_exist", "账号已存在");
        }
        Integer validName = systemUserDao.validName(sysUser.getName());
        if (validName > 0) {
            return BaseResult.error("name_exist", "名称已存在");
        }
        systemUserDao.add(sysUser);
        return BaseResult.success("新增成功");
    }

    /**
     * 登录
     *
     * @param account
     * @param password
     * @return
     */
    @Override
    public BaseResult login(String account, String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        String encryptPassword = PBKUtils.getEncryptedPassword(password, Constants.ENCRYPT_SALT);
        Integer count = systemUserDao.validUser(account, encryptPassword);
        if (count <= 0) {
            return BaseResult.error("login_fail", "账号或密码不正确");
        }
        return null;
    }

    /**
     * 密码修改
     *
     * @param account
     * @param oldPassword
     * @param newPassword
     * @param confirmPassword
     * @return
     */
    @Override
    public BaseResult updatePassword(String account, String oldPassword, String newPassword, String confirmPassword) throws InvalidKeySpecException, NoSuchAlgorithmException {
        String encryptPassword = PBKUtils.getEncryptedPassword(oldPassword, Constants.ENCRYPT_SALT);
        Integer count = systemUserDao.validUser(account, encryptPassword);
        if (count <= 0) {
            return BaseResult.error("update_fail", "账号或密码不正确");
        }

        Integer code = systemUserDao.updatePassword(account,
                PBKUtils.getEncryptedPassword(newPassword, Constants.ENCRYPT_SALT));
        if (code > 0) {
            //TODO  重新生成Token  并且页面跳转到登录页
            return BaseResult.success("密码修改成功");
        }

        return BaseResult.error("update_fail", "密码修改失败");
    }

    /**
     * 删除用户信息
     *
     * @param account
     * @return
     */
    @Override
    public BaseResult deleteUser(String account) {
        return null;
    }
}