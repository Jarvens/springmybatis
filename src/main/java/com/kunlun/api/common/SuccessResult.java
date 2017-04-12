package com.kunlun.api.common;


import java.io.Serializable;

/**
 * Created by kunlun on 2017/4/12.
 */
public class SuccessResult extends BaseResult implements Serializable {

    private static final long serialVersionUID = 2027041417263957428L;

    private Object data;


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public SuccessResult(Object data) {
        this();
        this.data = data;
    }

    public SuccessResult() {
        super(SUCCESS);
    }
}
