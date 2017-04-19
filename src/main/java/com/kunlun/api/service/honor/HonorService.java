package com.kunlun.api.service.honor;

import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.domain.Honor;

import java.util.List;

/**
 * Created by kunlun on 2017/4/19.
 */
public interface HonorService {

    List<Honor> list(Integer pageNo,Integer pageSize,Honor honor);

    BaseResult add(Honor honor);

    BaseResult update(Honor honor);
}
