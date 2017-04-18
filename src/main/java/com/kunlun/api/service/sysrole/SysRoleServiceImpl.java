package com.kunlun.api.service.sysrole;

import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.common.result.PageCommon;
import com.kunlun.api.common.result.PageResult;
import com.kunlun.api.dao.sysrole.SysRoleDao;
import com.kunlun.api.domain.SysRole;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kunlun on 2017/4/18.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleServiceImpl implements SysRoleService, PageCommon {

    @Autowired
    private SysRoleDao sysRoleDao;

    /**
     * 分页查询  关键字搜索
     *
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, String key) {
        if (StringUtils.isNullOrEmpty(key)) {
            key = "%" + key + "%";
        }
        Integer count = sysRoleDao.count(key);
        if (count <= 0) {
            return new PageResult(0, null);
        }
        List<SysRole> list = sysRoleDao.list(rowBounds(pageNo, pageSize), key);
        return new PageResult(list, pageNo, pageSize, count);
    }

    @Override
    public BaseResult add() {
        return null;
    }

    @Override
    public BaseResult update() {
        return null;
    }

    @Override
    public BaseResult delete() {
        return null;
    }
}
