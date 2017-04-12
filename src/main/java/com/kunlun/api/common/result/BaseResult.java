package com.kunlun.api.common.result;

import java.io.Serializable;

/**
 * Created by kunlun on 2017/4/12.
 */
public class BaseResult implements Serializable {

    private static final long serialVersionUID = 615636226960523553L;

    //成功
    public static int SUCCESS = 1;

    //失败
    public static int FAIL = 0;

    //结果状态码
    private int result;

    public BaseResult(int result) {
        this.result = result;
    }

    public static BaseResult success(Object object) {
        return new SuccessResult(object);
    }

    public static BaseResult error(String code, String message) {
        return new ErrorResult(code, message);
    }

    public static BaseResult paramError() {
        return new ErrorResult("0002", "参数错误");
    }

    public static BaseResult notFound() {
        return new ErrorResult("0003", "查无结果");
    }

    public static BaseResult tokenInvalid() {
        return new ErrorResult("0004", "token无效");
    }

    public static BaseResult needToken() {
        return new ErrorResult("0005", "需要token");
    }

    public static BaseResult sysError() {
        return new ErrorResult("0006", "系统错误");
    }


    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
