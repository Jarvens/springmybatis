package com.kunlun.api.service.index;

import com.kunlun.api.dao.index.IndexDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kunlun on 2017/4/12.
 */

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexDao indexDao;

    public Integer count() {
        return indexDao.count();
    }
}
