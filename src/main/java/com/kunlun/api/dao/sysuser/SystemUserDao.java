package com.kunlun.api.dao.sysuser;

import com.kunlun.api.domain.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kunlun on 2017/4/17.
 */
@Repository
public interface SystemUserDao {

    List<SysUser> list(RowBounds rowBounds, @Param(value = "key") String key);

    Integer count(@Param(value = "key") String key);
}
