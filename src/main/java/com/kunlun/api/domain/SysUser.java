package com.kunlun.api.domain;

import com.kunlun.api.common.constants.Constants;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 云平台  -  系统用户
 * Created by kunlun on 2017/4/12.
 */
public class SysUser implements Serializable {

    //主键
    private Long id;

    //账户
    @NotBlank(message = "请输入账户信息")
    private String account;

    //姓名
    private String name;

    //手机号
    @Pattern(regexp = Constants.MOBILE_REGEXP, message = "手机格式错误")
    private String mobilePhone;

    //密码
    @NotBlank(message = "请输入密码信息")
    @Length(min = 6, max = 10, message = "密码长度在6~10位之间")
    private String password;

    //身份证号
    private String cardNo;

    //性别
    private String sex;

    //年龄
    private Integer age;

    //用户类型
    private String type;

    //用户状态
    private String status;

    //操作人
    private String operator;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", password='" + password + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", operator='" + operator + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
