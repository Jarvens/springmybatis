package com.kunlun.api.common.result;

import java.io.Serializable;

/**
 * Created by kunlun on 2017/4/12.
 */
public class PageResult extends SuccessResult implements Serializable {

    private static final long serialVersionUID = 794304989296864241L;

    //记录总数
    private Integer total;

    //当前页码
    private int pageNo;

    //每页条数
    private int pageSize;

    //总页数
    private int pages;

    //是否存在下一页
    private Boolean hasNextPage;

    public PageResult(Object object, Integer total, int pageNo, int pageSize) {
        super(object);
        this.total = total;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.hasNextPage = total > (pageNo * pageSize);
    }

    public PageResult(Object object, Integer total) {
        super(object);
        this.pageNo = 1;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        if (this.getTotal() > 0 && this.pageSize > 0) {
            if (total < pageSize) {
                pages = 1;
            } else {
                pages = (int) Math.ceil(total / Double.valueOf(pageSize));
            }
        } else {
            pages = 0;
        }
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Boolean getHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }
}
