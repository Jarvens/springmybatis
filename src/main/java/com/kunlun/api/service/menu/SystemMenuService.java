package com.kunlun.api.service.menu;

import com.kunlun.api.common.result.PageResult;
import com.kunlun.api.domain.SysMenu;

import java.util.List;

/**
 * Created by kunlun on 2017/4/17.
 */
public interface SystemMenuService {

    PageResult pageList(Integer pageNo, Integer pageSize, String key);

    List<SysMenu> list();
}
