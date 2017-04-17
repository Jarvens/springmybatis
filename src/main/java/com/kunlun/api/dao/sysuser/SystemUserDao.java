package com.kunlun.api.dao.sysuser;

import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.domain.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kunlun on 2017/4/17.
 */
@Repository
public interface SystemUserDao {

    List<SysUser> list(RowBounds rowBounds, @Param(value = "key") String key);

    Integer count(@Param(value = "key") String key);

    void add(SysUser sysUser);

    SysUser validUser(@Param(value = "account") String account, @Param(value = "password") String password);

    void updatePassword(@Param(value = "account") String account, @Param(value = "newPassword") String newPassword);

    SysUser validAccount(@Param(value = "account") String account);

    Integer validName(@Param(value = "name") String name);

    Integer deleteUser(@Param(value = "account") String account);

    void updateSysUserInfo(SysUser sysUser);

}
