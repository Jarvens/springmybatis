package com.kunlun.api.common.result;

import org.apache.ibatis.session.RowBounds;

/**
 * Created by kunlun on 2017/4/12.
 */
public interface PageCommon {

    default RowBounds rowBounds(Integer pageNo, Integer pageSize) {
        if (null == pageNo) {
            return null;
        }
        return new RowBounds((pageNo - 1) * pageSize, pageSize == null ? 10 : pageSize);
    }
}
