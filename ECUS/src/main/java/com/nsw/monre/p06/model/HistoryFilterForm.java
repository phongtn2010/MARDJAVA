/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.monre.p06.model;

/**
 *
 * @author AnPhucNguyen
 */
public class HistoryFilterForm {
    private Long FiIdHoso;
    private String fiMaHoso;
    private int pageSize;
    private int currentPage;

    public HistoryFilterForm() {
    }

    public Long getFiIdHoso() {
        return FiIdHoso;
    }

    public void setFiIdHoso(Long FiIdHoso) {
        this.FiIdHoso = FiIdHoso;
    }
    
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }
}
