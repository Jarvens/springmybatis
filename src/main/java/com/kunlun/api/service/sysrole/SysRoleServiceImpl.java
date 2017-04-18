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

    /**
     * 新增角色
     *
     * @param sysRole
     * @return
     */
    @Override
    public BaseResult add(SysRole sysRole) {
        SysRole validRole = sysRoleDao.queryRoleByName(sysRole.getName());
        if (null != validRole) {
            return BaseResult.error("name_exist_exist", "角色名称已存在");
        }
        return sysRoleDao.add(sysRole);
    }

    /**
     * 更新角色信息
     *
     * @param sysRole
     * @return
     */
    @Override
    public BaseResult update(SysRole sysRole) {
        SysRole validRole = sysRoleDao.queryRoleByName(sysRole.getName());
        if (null != validRole) {
            return BaseResult.error("name_exist", "角色名称已存在");
        }
        sysRoleDao.update(sysRole);
        return BaseResult.success("update_success");
    }

    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    @Override
    public BaseResult delete(String roleId) {
        SysRole sysRole = sysRoleDao.queryRoleById(roleId);
        if (null != sysRole) {
            return BaseResult.error("role_used", "启用状态下不可删除");
        }
        sysRoleDao.deleteRoleById(roleId);
        return BaseResult.success("delete_success");
    }
}
