package com.kunlun.api.service.sysuser;

import com.kunlun.api.common.constants.Constants;
import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.common.result.PageCommon;
import com.kunlun.api.common.result.PageResult;
import com.kunlun.api.common.utils.PBKUtils;
import com.kunlun.api.common.utils.TokenUtils;
import com.kunlun.api.dao.sysuser.SystemUserDao;
import com.kunlun.api.domain.SysUser;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by kunlun on 2017/4/17.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SystemUserServiceImpl implements SystemUserService, PageCommon {

    @Autowired
    private SystemUserDao systemUserDao;

    @Autowired
    private RedisTemplate redisTemplate;

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

    /**
     * 添加用户
     *
     * @param sysUser
     * @return
     */
    @Override
    public BaseResult add(SysUser sysUser) {
        SysUser validAccount = systemUserDao.validAccount(sysUser.getAccount());
        if (null != validAccount) {
            return BaseResult.error("account_exist", "账号已存在");
        }
        Integer validName = systemUserDao.validName(sysUser.getName());
        if (validName > 0) {
            return BaseResult.error("name_exist", "名称已存在");
        }
        systemUserDao.add(sysUser);
        return BaseResult.success("register_success");
    }

    /**
     * 登录
     *
     * @param account
     * @param password
     * @return
     */
    @Override
    public BaseResult login(String account, String password) throws Exception {
        String encryptPassword = PBKUtils.getEncryptedPassword(password, Constants.ENCRYPT_SALT);
        SysUser sysUser = systemUserDao.validUser(account, encryptPassword);
        if (null == sysUser) {
            return BaseResult.error("login_fail", "账号或密码不正确");
        }
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(Constants.ON_LINE + account, sysUser.toString(), 300, TimeUnit.SECONDS);
        String token = TokenUtils.aesEncrypt(account + sysUser.getName(), Constants.TOKEN_KEY);
        return BaseResult.success(token);
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
    public BaseResult updatePassword(String account, String oldPassword, String newPassword, String confirmPassword) throws Exception {
        String encryptPassword = PBKUtils.getEncryptedPassword(oldPassword, Constants.ENCRYPT_SALT);
        SysUser sysUser = systemUserDao.validUser(account, encryptPassword);
        if (null == sysUser) {
            return BaseResult.error("update_fail", "账号或密码不正确");
        }
        systemUserDao.updatePassword(account,
                PBKUtils.getEncryptedPassword(newPassword, Constants.ENCRYPT_SALT));
        //生成Token
        String token = TokenUtils.aesEncrypt(sysUser.toString(), Constants.TOKEN_KEY);
        return BaseResult.success(token);
    }

    /**
     * 删除用户信息  逻辑删除
     *
     * @param account
     * @return
     */
    @Override
    public BaseResult deleteUser(String account) {
        Integer result = systemUserDao.deleteUser(account);
        if (result > 0) {
            return BaseResult.success("delete_success");
        }
        return BaseResult.error("delete_fail", "删除失败");
    }

    /**
     * 更新用户信息
     *
     * @param sysUser
     * @return
     */
    @Override
    public BaseResult updateUserInfo(SysUser sysUser) {
        Integer validName = systemUserDao.validName(sysUser.getName());
        if (validName > 0) {
            return BaseResult.error("name_exist", "名称已存在");
        }
        systemUserDao.updateSysUserInfo(sysUser);
        return BaseResult.success("update_success");
    }

    /**
     * 密码重置
     *
     * @param account
     * @return
     */
    @Override
    public BaseResult resetPassword(String account) throws InvalidKeySpecException, NoSuchAlgorithmException {
        SysUser sysUser = systemUserDao.validAccount(account);
        if (null == sysUser) {
            return BaseResult.error("account_not_exist", "账户不存在");
        }
        //查询redis删除相对应的存储  以免修改密码过后该人员还可以继续操作
        redisTemplate.opsForList().remove(Constants.ON_LINE + sysUser.getAccount(), -1, null);
        //PBK加密算法
        String encryptPassword = PBKUtils.getEncryptedPassword(Constants.DEFAULT_PASSWORD, Constants.ENCRYPT_SALT);
        sysUser.setPassword(encryptPassword);
        systemUserDao.updateSysUserInfo(sysUser);
        return BaseResult.success("reset_success");
    }
}
