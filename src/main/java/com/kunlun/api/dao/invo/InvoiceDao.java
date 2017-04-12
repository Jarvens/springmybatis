package com.kunlun.api.dao.invo;

import com.kunlun.api.domain.Invoice;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kunlun on 2017/4/12.
 */
@Repository
public interface InvoiceDao {

    Integer add(List<Invoice> invoiceList);
}
