/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mt.qlpt.model;

import java.io.Serializable;

public class FilterForm implements Serializable {

    private String biensoxe;
    private String tenchuxe;
    private String nguoiTao;
    private int pageSize;
    private int currentPage;

    public FilterForm() {
    }

    public FilterForm(String biensoxe, String tenchuxe, String nguoiTao, int pageSize, int currentPage) {
        this.biensoxe = biensoxe;
        this.tenchuxe = tenchuxe;
        this.nguoiTao = nguoiTao;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }

    public String getBiensoxe() {
        return biensoxe;
    }

    public void setBiensoxe(String biensoxe) {
        this.biensoxe = biensoxe;
    }

    public String getTenchuxe() {
        return tenchuxe;
    }

    public void setTenchuxe(String tenchuxe) {
        this.tenchuxe = tenchuxe;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
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
