package com.kunlun.api.service.reim;

import com.kunlun.api.common.result.PageResult;

/**
 * Created by kunlun on 2017/4/12.
 */

public interface ReimbursementService {

    Integer count(String status);

    PageResult list(int pageNo, int pageSize, String status);

}
