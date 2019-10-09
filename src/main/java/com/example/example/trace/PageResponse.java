package com.example.example.trace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kcs
 * @date 2019-10-09 15:08
 **/
public class PageResponse<T extends Serializable> implements Serializable {
    private int pageNo;
    private int pageSize;
    private int count;
    private int start;
    private int first;
    private int last;
    private boolean firstPage;
    private boolean lastPage;
    private List<T> list;

    public PageResponse() {
        this.pageNo = 1;
        this.list = new ArrayList();
        this.pageSize = -1;
    }

    public PageResponse(int pageNo, int pageSize) {
        this(pageNo, pageSize, 0);
    }

    public PageResponse(int pageNo, int pageSize, int count) {
        this(pageNo, pageSize, count, new ArrayList());
    }

    public PageResponse(int pageNo, int pageSize, int count, List<T> list) {
        this.pageNo = 1;
        this.list = new ArrayList();
        this.setCount(count);
        this.setPageNo(pageNo);
        this.pageSize = pageSize;
        this.setList(list);
    }

    public void initialize() {
        this.first = 1;
        this.last = this.count / (this.pageSize < 1 ? 20 : this.pageSize) + this.first - 1;
        if (this.count % this.pageSize != 0 || this.last == 0) {
            ++this.last;
        }

        if (this.last < this.first) {
            this.last = this.first;
        }

        if (this.pageNo <= 1) {
            this.pageNo = this.first;
            this.firstPage = true;
        }

        if (this.pageNo >= this.last) {
            this.pageNo = this.last;
            this.lastPage = true;
        }

        if (this.pageNo < this.first) {
            this.pageNo = this.first;
        }

        if (this.pageNo > this.last) {
            this.pageNo = this.last;
        }

    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
        if (this.pageSize >= count) {
            this.pageNo = 1;
        }

    }

    public int getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize <= 0 ? 10 : pageSize;
    }

    public int getFirst() {
        return this.first;
    }

    public int getLast() {
        return this.last;
    }

    public int getTotalPage() {
        return this.getLast();
    }

    public boolean isFirstPage() {
        return this.firstPage;
    }

    public boolean isLastPage() {
        return this.lastPage;
    }

    public int getPrev() {
        return this.isFirstPage() ? this.pageNo : this.pageNo - 1;
    }

    public int getNext() {
        return this.isLastPage() ? this.pageNo : this.pageNo + 1;
    }

    public List<T> getList() {
        return this.list;
    }

    public PageResponse<T> setList(List<T> list) {
        this.list = list;
        this.initialize();
        return this;
    }

    public boolean isDisabled() {
        return this.pageSize == -1;
    }

    public boolean isNotCount() {
        return this.count == -1;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
