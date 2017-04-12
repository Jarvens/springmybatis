package com.kunlun.api.service.reim;

import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.common.result.PageResult;
import com.kunlun.api.domain.Reimbursement;

/**
 * Created by kunlun on 2017/4/12.
 */

public interface ReimbursementService {

    Integer count(String status);

    PageResult list(int pageNo, int pageSize, String status);

    BaseResult add(Reimbursement reimbursement);

    Integer addPart(Reimbursement reimbursement);

}
