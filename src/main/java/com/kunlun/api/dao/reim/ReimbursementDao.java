package com.kunlun.api.dao.reim;

import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.domain.Reimbursement;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kunlun on 2017/4/12.
 */
@Repository
public interface ReimbursementDao {

    Integer count(@Param(value = "status") String status);

    List<Reimbursement> list(RowBounds rowBounds, @Param(value = "status") String status);

    BaseResult add(Reimbursement reimbursement);

    Integer addPart(Reimbursement reimbursement);
}
