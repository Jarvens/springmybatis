package com.kunlun.api.web.menu;

import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.domain.SysMenu;
import com.kunlun.api.service.menu.SystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 云平台  -  菜单
 * Created by kunlun on 2017/4/14.
 */
@RestController
@RequestMapping("menu")
public class SysMenuController {

    @Autowired
    private SystemMenuService systemMenuService;

    /**
     * 菜单列表
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public BaseResult list(String userId) {
        List<SysMenu> list = systemMenuService.list("0", userId);
        return BaseResult.success(list);
    }

    /**
     * 新增菜单
     *
     * @param sysMenu
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(@Validated SysMenu sysMenu, BindingResult validResult) {
        if (validResult.hasErrors()) {
            return BaseResult.error("param_error",
                    validResult.getAllErrors().get(0).getDefaultMessage());
        }
        return systemMenuService.add(sysMenu);
    }


    /**
     * 删除菜单
     *
     * @param menuId
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public BaseResult delete(String menuId) {
        return null;
    }

    /**
     * 更新菜单信息
     *
     * @param sysMenu
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResult update(SysMenu sysMenu) {
        return null;
    }

}
