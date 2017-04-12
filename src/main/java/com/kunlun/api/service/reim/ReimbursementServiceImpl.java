package com.kunlun.api.service.reim;

import com.kunlun.api.common.result.PageCommon;
import com.kunlun.api.common.result.PageResult;
import com.kunlun.api.dao.reim.ReimbursementDao;
import com.kunlun.api.domain.Reimbursement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kunlun on 2017/4/12.
 */
@Service
public class ReimbursementServiceImpl implements ReimbursementService, PageCommon {

    @Autowired
    private ReimbursementDao reimbursementDao;

    @Override
    public Integer count(String status) {
        return reimbursementDao.count(status);
    }

    @Override
    public PageResult list(int pageNo, int pageSize, String status) {
        Integer count = this.count(status);
        if (count <= 0) {
            return new PageResult(null, 0);
        }
        List<Reimbursement> list = reimbursementDao.list(rowBounds(pageNo, pageSize), status);

        return new PageResult(list, count, pageNo, pageSize);
    }
}
