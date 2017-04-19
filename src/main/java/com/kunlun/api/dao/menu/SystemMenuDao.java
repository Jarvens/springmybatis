package com.kunlun.api.dao.menu;

import com.kunlun.api.common.result.PageResult;
import com.kunlun.api.domain.SysMenu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kunlun on 2017/4/17.
 */
@Repository
public interface SystemMenuDao {

    List<SysMenu> pageList(RowBounds rowBounds, @Param(value = "key") String key);

    List<SysMenu> list(@Param(value = "pid") String pid, @Param(value = "userId") String userId);

    Integer count(@Param(value = "key") String key);

    SysMenu queryByNameAndUrl(@Param(value = "name") String name, @Param(value = "url") String url);

    void add(SysMenu sysMenu);
}
