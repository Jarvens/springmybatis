package com.kunlun.api.service.invo;

import com.kunlun.api.dao.invo.InvoiceDao;
import com.kunlun.api.domain.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kunlun on 2017/4/12.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceDao invoiceDao;

    @Override
    public Integer add(List<Invoice> invoiceList) {
        return invoiceDao.add(invoiceList);
    }
}
