package com.shop.entity;

import java.util.List;

/**
 * 分页结果类
 */
public class PageResult<T> {
    /**
     * 总记录数
     */
    private Long total;
    /**
     * 记录
     */
    private List<T> rows;

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }


}
