package com.kunlun.api.service.invo;

import com.kunlun.api.domain.Invoice;

import java.util.List;

/**
 * Created by kunlun on 2017/4/12.
 */
public interface InvoiceService {

    Integer add(List<Invoice> invoiceList);
}
