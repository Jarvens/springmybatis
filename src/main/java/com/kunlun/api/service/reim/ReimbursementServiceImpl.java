package com.kunlun.api.service.reim;

import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.common.result.PageCommon;
import com.kunlun.api.common.result.PageResult;
import com.kunlun.api.dao.invo.InvoiceDao;
import com.kunlun.api.dao.reim.ReimbursementDao;
import com.kunlun.api.domain.Invoice;
import com.kunlun.api.domain.Reimbursement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kunlun on 2017/4/12.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ReimbursementServiceImpl implements ReimbursementService, PageCommon {

    @Autowired
    private ReimbursementDao reimbursementDao;

    @Autowired
    private InvoiceDao invoiceDao;


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

    /**
     * 事务操作
     *
     * @param reimbursement
     * @return
     */
    @Override
    public BaseResult add(Reimbursement reimbursement) {
        Integer count = this.addPart(reimbursement);
        if (count <= 0) {
            return BaseResult.sysError();
        }
        List<Invoice> invoiceList = reimbursement.getInvoiceList();
        invoiceList.forEach(item -> {
            item.setReimbursementId(reimbursement.getId());
        });
        Integer iCount = invoiceDao.add(invoiceList);
        if (iCount <= 0) {
            return BaseResult.sysError();
        }
        return BaseResult.success("success");
    }

    @Override
    public Integer addPart(Reimbursement reimbursement) {
        return reimbursementDao.addPart(reimbursement);
    }
}
