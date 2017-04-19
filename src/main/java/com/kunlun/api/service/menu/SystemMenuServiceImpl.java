package com.kunlun.api.service.menu;

import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.common.result.PageCommon;
import com.kunlun.api.common.result.PageResult;
import com.kunlun.api.dao.menu.SystemMenuDao;
import com.kunlun.api.domain.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kunlun on 2017/4/17.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SystemMenuServiceImpl implements SystemMenuService, PageCommon {

    @Autowired
    private SystemMenuDao systemMenuDao;

    /**
     * 分页查询     关键字搜索
     *
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    @Override
    public PageResult pageList(Integer pageNo, Integer pageSize, String key) {
        Integer count = systemMenuDao.count(key);
        if (count <= 0) {
            return new PageResult(null, 0);
        }
        List<SysMenu> list = systemMenuDao.pageList(rowBounds(pageNo, pageSize), key);
        return new PageResult(list, count, pageNo, pageSize);
    }

    /**
     * 递归查询  根据pid查询
     *
     * @return
     */
    @Override
    public List<SysMenu> list(String pid, String userId) {
        List<SysMenu> list = systemMenuDao.list(pid, userId);
        if (null != list && list.size() > 0) {
            list.forEach(item -> {
                item.setLeaf(list(String.valueOf(item.getId()), userId));
            });
        }
        return list;
    }

    /**
     * 新增菜单
     *
     * @param sysMenu
     * @return
     */
    @Override
    public BaseResult add(SysMenu sysMenu) {
        SysMenu valid = systemMenuDao.queryByNameAndUrl(sysMenu.getName(), sysMenu.getUrl());
        if (null != valid) {
            return BaseResult.error("exist", "菜单名称或地址已存在");
        }
        systemMenuDao.add(sysMenu);
        return BaseResult.success("add_success");
    }

    /**
     * 删除菜单
     *
     * @param menuId
     * @return
     */
    @Override
    public BaseResult delete(Long menuId) {
        //TODO 校验菜单是否有角色正在使用
        Integer valid = systemMenuDao.validUse(menuId);
        if (valid > 0) {
            return BaseResult.error("in_use","正在使用中,不可删除");
        }
        systemMenuDao.deleteByMenuId(menuId);
        return null;
    }
}
