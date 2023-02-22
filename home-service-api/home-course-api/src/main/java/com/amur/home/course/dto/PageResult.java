package com.amur.home.course.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    private int pageNum;
    private int pageSize;
    private long total;
    private long pages;
    private List<T> data;

    public PageResult(int pageNum, int pageSize, long total, long pages, List<T> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.pages = pages;
        this.data = data;
    }
}
