/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p09.model;

public class GateSearchForm {

    private String fiMaCuakhau;
    private String fiTenCuakhau;
    private int pageSize;
    private int currentPage;

    public GateSearchForm() {
    }

    public String getFiMaCuakhau() {
        return fiMaCuakhau;
    }

    public void setFiMaCuakhau(String fiMaCuakhau) {
        this.fiMaCuakhau = fiMaCuakhau;
    }

    public String getFiTenCuakhau() {
        return fiTenCuakhau;
    }

    public void setFiTenCuakhau(String fiTenCuakhau) {
        this.fiTenCuakhau = fiTenCuakhau;
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


}
