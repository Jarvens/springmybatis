package com.kunlun.api.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Transient;
import java.util.Date;
import java.util.List;


/**
 * Created by kunlun on 2017/4/12.
 */
public class Reimbursement {

    //主键
    private Long id;

    //献血者姓名
    private String name;

    //献血者电话
    private String phone;

    //献血者证件号
    private String cardNo;

    /**
     * 与献血者关系
     * 01 配偶
     * 02 父母
     * 03 子女
     * 04 兄弟姐妹
     * 05 祖父母
     * 06 外祖父母
     * 07 配偶父母
     * 08 本人
     */
    private String relation;

    //用血者姓名
    private String demandName;

    //用血者证件号
    private String demandCardNo;

    //输血费
    private Long cost;

    //入院时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date admissionTime;

    //出院时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dischargedTime;

    //用血机构
    private String demandMechanism;

    /**
     * 是否本省
     * 0：否
     * 1：是
     */
    private String isLocal;

    //开户人名称
    private String accountHolderName;

    //开户行名称
    private String bankName;

    //开户行卡号
    private String bankNo;

    //实际报销费用
    private Long actualCost;

    //报销记录创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    //审核状态
    private String status;

    //身份证图片地址
    private String cardImgUrl;

    //关系证明图片地址
    private String relationImgUrl;

    //出院证明图片地址
    private String dischargedImgUrl;

    //行政区划代码
    private String cityCode;

    //操作员确认
    private String operatorConfirm;

    //操作人
    private String operator;

    //更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    //领导确认
    private String leaderConfirm;

    //发票集合
    @Transient
    private List<Invoice> invoiceList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getDemandName() {
        return demandName;
    }

    public void setDemandName(String demandName) {
        this.demandName = demandName;
    }

    public String getDemandCardNo() {
        return demandCardNo;
    }

    public void setDemandCardNo(String demandCardNo) {
        this.demandCardNo = demandCardNo;
    }

    public Date getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(Date admissionTime) {
        this.admissionTime = admissionTime;
    }

    public Date getDischargedTime() {
        return dischargedTime;
    }

    public void setDischargedTime(Date dischargedTime) {
        this.dischargedTime = dischargedTime;
    }

    public String getDemandMechanism() {
        return demandMechanism;
    }

    public void setDemandMechanism(String demandMechanism) {
        this.demandMechanism = demandMechanism;
    }

    public String getIsLocal() {
        return isLocal;
    }

    public void setIsLocal(String isLocal) {
        this.isLocal = isLocal;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public String getCardImgUrl() {
        return cardImgUrl;
    }

    public void setCardImgUrl(String cardImgUrl) {
        this.cardImgUrl = cardImgUrl;
    }

    public String getRelationImgUrl() {
        return relationImgUrl;
    }

    public void setRelationImgUrl(String relationImgUrl) {
        this.relationImgUrl = relationImgUrl;
    }

    public String getDischargedImgUrl() {
        return dischargedImgUrl;
    }

    public void setDischargedImgUrl(String dischargedImgUrl) {
        this.dischargedImgUrl = dischargedImgUrl;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getActualCost() {
        return actualCost;
    }

    public void setActualCost(Long actualCost) {
        this.actualCost = actualCost;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getOperatorConfirm() {
        return operatorConfirm;
    }

    public void setOperatorConfirm(String operatorConfirm) {
        this.operatorConfirm = operatorConfirm;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getLeaderConfirm() {
        return leaderConfirm;
    }

    public void setLeaderConfirm(String leaderConfirm) {
        this.leaderConfirm = leaderConfirm;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", relation='" + relation + '\'' +
                ", demandName='" + demandName + '\'' +
                ", demandCardNo='" + demandCardNo + '\'' +
                ", cost=" + cost +
                ", admissionTime=" + admissionTime +
                ", dischargedTime=" + dischargedTime +
                ", demandMechanism='" + demandMechanism + '\'' +
                ", isLocal='" + isLocal + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankNo='" + bankNo + '\'' +
                ", actualCost=" + actualCost +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", cardImgUrl='" + cardImgUrl + '\'' +
                ", relationImgUrl='" + relationImgUrl + '\'' +
                ", dischargedImgUrl='" + dischargedImgUrl + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", operatorConfirm='" + operatorConfirm + '\'' +
                ", operator='" + operator + '\'' +
                ", updateTime=" + updateTime +
                ", leaderConfirm='" + leaderConfirm + '\'' +
                ", invoiceList=" + invoiceList +
                '}';
    }
}
