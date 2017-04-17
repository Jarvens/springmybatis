package com.kunlun.api.service.menu;

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

    @Override
    public List<SysMenu> list() {
        return null;
    }
}
