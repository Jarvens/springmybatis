package com.kunlun.api.web.reim;

import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.service.reim.ReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
