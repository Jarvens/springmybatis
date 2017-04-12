package com.kunlun.api.common;

import java.io.Serializable;

/**
 * Created by kunlun on 2017/4/12.
 */
public class ErrorResult extends BaseResult implements Serializable {

    private static final long serialVersionUID = -5293449661281736651L;


    private Error error;

    public ErrorResult() {
        super(FAIL);
    }

    public ErrorResult(String code, String message) {
        this();
        this.error = new Error();
        this.error.setCode(error.getCode());
        this.error.setMessage(message);
    }
}
