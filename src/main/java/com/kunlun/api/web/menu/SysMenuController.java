package com.kunlun.api.web.menu;

import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.domain.SysMenu;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 云平台  -  菜单
 * Created by kunlun on 2017/4/14.
 */
@RestController
@RequestMapping("menu")
public class SysMenuController {

    /**
     * 菜单列表
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public BaseResult list() {

        return null;
    }

    /**
     * 新增菜单
     *
     * @param sysMenu
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(SysMenu sysMenu) {
        return null;
    }


    /**
     * 删除菜单
     * @param menuId
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public BaseResult delete(String menuId) {
        return null;
    }

    /**
     * 更新菜单信息
     * @param sysMenu
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public BaseResult update(SysMenu sysMenu){
        return null;
    }

}
