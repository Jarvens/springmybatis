package com.kunlun.api.domain;

import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 *
 * 云平台   -  角色
 * Created by kunlun on 2017/4/18.
 */
public class SysRole {

    //主键
    private Long id;

    //角色名称
    @NotBlank(message = "请输入角色名称")
    private String name;

    //角色备注
    private String remark;

    //创建时间
    private Date createTime;

    //操作人
    private String operator;

    //更新时间
    private Date updateTime;

    //角色状态   0:启用  1:禁用
    private String status;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", operator='" + operator + '\'' +
                ", updateTime=" + updateTime +
                ", status='" + status + '\'' +
                '}';
    }
}
