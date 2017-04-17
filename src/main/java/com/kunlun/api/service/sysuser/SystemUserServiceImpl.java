package com.kunlun.api.service.sysuser;

import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.common.result.PageCommon;
import com.kunlun.api.common.result.PageResult;
import com.kunlun.api.dao.sysuser.SystemUserDao;
import com.kunlun.api.domain.SysUser;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kunlun on 2017/4/17.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SystemUserServiceImpl implements SystemUserService, PageCommon {

    @Autowired
    private SystemUserDao systemUserDao;

    /**
     * 关键字搜索   列表查询    分页
     *
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, String key) {
        if (!StringUtils.isNullOrEmpty(key)) {
            key = "%" + key + "%";
        }
        Integer count = this.count(key);
        if (count > 0) {
            List<SysUser> list = systemUserDao.list(rowBounds(pageNo, pageSize), key);
            return new PageResult(list, count, pageNo, pageSize);
        }
        return new PageResult(null, 0);
    }

    /**
     * 查询count数量
     *
     * @param key
     * @return
     */
    @Override
    public Integer count(String key) {
        return systemUserDao.count(key);
    }

    @Override
    public BaseResult add(SysUser sysUser) {
        return null;
    }
}
