package com.kunlun.api.service.sysrole;

import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.common.result.PageResult;

/**
 * Created by kunlun on 2017/4/18.
 */
public interface SysRoleService {

    PageResult list(Integer pageNo,Integer pageSize,String key);

    BaseResult add();

    BaseResult update();

    BaseResult delete();
}
