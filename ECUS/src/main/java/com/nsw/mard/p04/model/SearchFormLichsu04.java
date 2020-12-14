package com.nsw.mard.p04.model;

public class SearchFormLichsu04
{
    private Long fiIdHoso;
    private String fiMaHoso;
    private int pageSize;
    private int currentPage;
    
    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }
    
    public void setFiIdHoso(final Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }
    
    public int getPageSize() {
        return this.pageSize;
    }
    
    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }
    
    public int getCurrentPage() {
        return this.currentPage;
    }
    
    public void setCurrentPage(final int currentPage) {
        this.currentPage = currentPage;
    }
    
    public String getFiMaHoso() {
        return this.fiMaHoso;
    }
    
    public void setFiMaHoso(final String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }
}