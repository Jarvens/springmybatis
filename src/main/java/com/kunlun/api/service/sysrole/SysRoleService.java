package com.kunlun.api.service.sysrole;

import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.common.result.PageResult;
import com.kunlun.api.domain.SysRole;

/**
 * Created by kunlun on 2017/4/18.
 */
public interface SysRoleService {

    PageResult list(Integer pageNo,Integer pageSize,String key);

    BaseResult add(SysRole sysRole);

    BaseResult update(SysRole sysRole);

    BaseResult delete(String roleId);
}
