package com.bjpowernode.pojo;

/**
 * @author jiangrenbao
 * @date 2021/11/27
 * @description
 */
public class PageInfo {

    private int totalPage;
    private int pageNo;
    private int pageSize;
    private int totalSum;

    public int getTotalPage() {
        if (totalSum < pageSize){
            return 1;
        }else{
            if (totalSum / pageSize == 0){
                return totalSum / pageSize;
            }else{
                return totalSum / pageSize + 1;
            }
        }
    }

    public PageInfo setTotalPage(int totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    public int getPageNo() {
        return pageNo;
    }

    public PageInfo setPageNo(int pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageInfo setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getTotalSum() {
        return totalSum;
    }

    public PageInfo setTotalSum(int totalSum) {
        this.totalSum = totalSum;
        return this;
    }

    public PageInfo() {
    }

    public PageInfo( int pageNo, int pageSize, int totalSum) {

        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalSum = totalSum;
    }
}
