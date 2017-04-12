package com.kunlun.api.common;

import java.io.Serializable;

/**
 * Created by kunlun on 2017/4/12.
 */
public class ResultData implements Serializable {

    private static final long serialVersionUID = 615636226960523553L;

    //成功
    private static  int SUCCESS=1;

    //失败
    private static int FAIL=0;

    //结果状态码
    private int result;


    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
