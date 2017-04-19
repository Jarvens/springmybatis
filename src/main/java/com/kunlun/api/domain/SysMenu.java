package com.kunlun.api.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * 云平台  -  菜单
 * Created by kunlun on 2017/4/14.
 */
public class SysMenu {

    //主键
    private Long id;

    //菜单名称
    @NotBlank(message = "菜单名称不为空")
    private String name;

    //父节点ID
    @NotBlank(message = "菜单父节点不为空")
    private String pid;

    //菜单描述
    private String description;

    //菜单地址
    @NotBlank(message = "菜单地址不为空")
    private String url;

    //状态
    private String status;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;

    //操作人
    private String operator;

    @Transient
    private List<SysMenu> leaf;


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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SysMenu> getLeaf() {
        return leaf;
    }

    public void setLeaf(List<SysMenu> leaf) {
        this.leaf = leaf;
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid='" + pid + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", operator='" + operator + '\'' +
                ", leaf=" + leaf +
                '}';
    }
}
