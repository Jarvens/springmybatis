package com.kunlun.api.service.honor;

import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.common.result.PageCommon;
import com.kunlun.api.domain.Honor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kunlun on 2017/4/19.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class HonorServiceImpl implements HonorService,PageCommon {

    /**
     * 荣誉证列表    分页查询   筛选
     * @param pageNo
     * @param pageSize
     * @param honor
     * @return
     */
    @Override
    public List<Honor> list(Integer pageNo, Integer pageSize, Honor honor) {
        return null;
    }

    /**
     * 荣誉证   申请
     * @param honor
     * @return
     */
    @Override
    public BaseResult add(Honor honor) {
        return null;
    }

    /**
     * 荣誉证更新
     * @param honor
     * @return
     */
    @Override
    public BaseResult update(Honor honor) {
        return null;
    }
}
