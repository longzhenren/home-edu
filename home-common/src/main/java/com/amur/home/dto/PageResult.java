package com.amur.home.dto;

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

    public static <T> PageResult<T> of(int pageNum, int pageSize, long total, long pages, List<T> data) {
        return new PageResult<>(pageNum, pageSize, total, pages, data);
    }

    public static <T> PageResult<T> of(int pageNum, int pageSize, long total, List<T> data) {
        return new PageResult<>(pageNum, pageSize, total, total / pageSize + 1, data);
    }

    public static <T> PageResult<T> of(int pageNum, int pageSize, long total, long pages) {
        return new PageResult<>(pageNum, pageSize, total, pages, null);
    }

    public static <T> PageResult<T> of(int pageNum, int pageSize, long total) {
        return new PageResult<>(pageNum, pageSize, total, total / pageSize + 1, null);
    }

    public static <T> PageResult<T> of(List<T> data, int pageNum, int pageSize, long total, long pages) {
        return new PageResult<>(pageNum, pageSize, total, pages, data);
    }

    public static <T> PageResult<T> of(List<T> data, int pageNum, int pageSize, long total) {
        return new PageResult<>(pageNum, pageSize, total, total / pageSize + 1, data);
    }

    public static <T> PageResult<T> of(List<T> data, int pageNum, int pageSize) {
        return new PageResult<>(pageNum, pageSize, data.size(), data.size(), data);
    }


    public static <T> PageResult<T> of(List<T> data) {
        return new PageResult<>(1, data.size(), data.size(), 1, data);
    }

    public static <T> PageResult<T> empty(int pageNum, int pageSize, long total) {
        return new PageResult<>(pageNum, pageSize, total, total / pageSize + 1, null);
    }

    public static <T> PageResult<T> empty(int pageNum, int pageSize, long total, long pages) {
        return new PageResult<>(pageNum, pageSize, total, pages, null);
    }

    public static <T> PageResult<T> empty() {
        return new PageResult<>(1, 0, 0, 1, null);
    }

    public static <T> PageResult<T> empty(int pageNum, int pageSize) {
        return new PageResult<>(pageNum, pageSize, 0, 1, null);
    }

}
