package com.kunlun.api.web.reim;

import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.domain.Invoice;
import com.kunlun.api.domain.Reimbursement;
import com.kunlun.api.service.reim.ReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by kunlun on 2017/4/12.
 */
@RestController
@RequestMapping("reim")
public class ReimbursementController {

    @Autowired
    private ReimbursementService reimbursementService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public BaseResult list(int pageNo, int pageSize, String status) {
        return reimbursementService.list(pageNo, pageSize, status);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public BaseResult add() {
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setName("测试数据");
        reimbursement.setPhone("13800138000");
        reimbursement.setCardNo("6228480000129890");
        reimbursement.setRelation("1");
        reimbursement.setDemandName("用血者姓名");
        reimbursement.setDemandCardNo("6226869090123456");
        reimbursement.setCost(100l);
        reimbursement.setAdmissionTime(new Date());
        reimbursement.setDischargedTime(new Date());
        reimbursement.setDemandMechanism("用血机构代码");
        reimbursement.setIsLocal("0");
        reimbursement.setAccountHolderName("持卡者姓名");
        reimbursement.setBankName("开户行名称");
        reimbursement.setBankNo("622996996871234");
        reimbursement.setStatus("0");
        reimbursement.setActualCost(200l);
        reimbursement.setCardImgUrl("身份证文件地址");
        reimbursement.setRelationImgUrl("关系证明文件地址");
        reimbursement.setDischargedImgUrl("出院证明文件地址");
        reimbursement.setCityCode("330100");
        reimbursement.setLeaderConfirm("0");
        reimbursement.setOperatorConfirm("0");
        reimbursement.setOperator("值班人员");
        List<Invoice> invoiceList = new ArrayList<>();
        List<String> mock = Arrays.asList("0","1","2");
        mock.forEach(item->{
            Invoice invoice = new Invoice();
            invoice.setCode(item);
            invoice.setCost(100l);
            invoice.setImgUrl("发票文件地址");
            invoiceList.add(invoice);
        });
        reimbursement.setInvoiceList(invoiceList);

        return reimbursementService.add(reimbursement);
    }
}
