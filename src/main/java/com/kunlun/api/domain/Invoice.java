package com.kunlun.api.domain;

/**
 * Created by kunlun on 2017/4/12.
 */
public class Invoice {

    //主键
    private Long sid;

    //发票号
    private String code;

    //发票金额
    private Long cost;

    //还血报销ID
    private Long reimbursementId;

    //发票图片地址
    private String imgUrl;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(Long reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "sid=" + sid +
                ", code='" + code + '\'' +
                ", cost=" + cost +
                ", reimbursementId=" + reimbursementId +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
