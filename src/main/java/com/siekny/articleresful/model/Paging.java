package com.siekny.articleresful.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Paging {

    private int page;
    private int limit;
    private Long totalCount;
    private int totalPages;
    private int pagesToShow;
    private int startPage;
    private int endPage;

    @JsonIgnore
    private int offset;

    public Paging() {
        this(1, 20, 0L, 0, 5);
    }

    public Paging(int page, int limit, Long totalCount, int totalPages, int pagesToShow) {
        this.page = page;
        this.limit = limit;
        this.totalCount = totalCount;
        this.totalPages = totalPages;
        this.pagesToShow = pagesToShow;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int currentPage) {
        this.page = (currentPage <= 1) ? 1: currentPage;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getNextPage() {
        return (page >= getTotalPages() ? getTotalPages() : page + 1);
    }
    public int getPreviousPage() {
        return (page <= 1) ? 1 : page - 1;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
        this.startPageEndPage(getTotalPages());
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) this.totalCount / limit);
    }

    public int getPagesToShow() {
        return pagesToShow;
    }


    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getOffset() {
        return (this.page - 1) * this.limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    private void startPageEndPage(int totalPages) {
        int halfPagesToShow = pagesToShow / 2;
        if(totalPages == 0) {
            startPage = 1;
            endPage = 1;
        } else if(totalPages <= pagesToShow) {
            startPage = 1;
            endPage = totalPages;
        } else if (page + halfPagesToShow == totalPages) {
            startPage = page - halfPagesToShow;
            endPage = totalPages;
        } else if (page + halfPagesToShow > totalPages) {
            startPage = totalPages - pagesToShow + 1;
            endPage = totalPages;
        } else {
            if(page <= halfPagesToShow) {
                startPage = 1;
                endPage = pagesToShow;
            }else {
                startPage = page - halfPagesToShow;
                endPage = page + halfPagesToShow;
            }
        }

    }


    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setPagesToShow(int pagesToShow) {
        this.pagesToShow = pagesToShow;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    @Override
    public String toString() {
        return "Paging{" +
                "page=" + page +
                ", limit=" + limit +
                ", totalCount=" + totalCount +
                ", totalPages=" + totalPages +
                ", pagesToShow=" + pagesToShow +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", offset=" + offset +
                '}';
    }
}
