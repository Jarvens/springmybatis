package com.kunlun.api.dao.sysrole;

import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.domain.SysRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kunlun on 2017/4/18.
 */
@Repository
public interface SysRoleDao {

    Integer count(@Param(value = "key") String key);

    List<SysRole> list(RowBounds rowBounds, @Param(value = "key") String key);

    BaseResult add(SysRole sysRole);

    SysRole queryRoleByName(@Param(value = "name") String name);

    SysRole queryRoleById(@Param(value = "roleId") String roleId);

    void deleteRoleById(@Param(value = "roleId") String roleId);

    void update(SysRole sysRole);
}
