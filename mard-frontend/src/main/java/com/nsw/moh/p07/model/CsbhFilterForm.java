/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p07.model;

/**
 *
 * @author Administrator
 */
public class CsbhFilterForm {
    private int currentPage;
    private String fiDiachiCsbh;
    private String fiMst;
    private String fiSdtCdCsbh;    
    private String fiSdtDdCsbh;
    private String fiTenCsbh;
    private int pageSize;    

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getFiDiachiCsbh() {
        return fiDiachiCsbh;
    }

    public void setFiDiachiCsbh(String fiDiachiCsbh) {
        this.fiDiachiCsbh = fiDiachiCsbh;
    }

    public String getFiMst() {
        return fiMst;
    }

    public void setFiMst(String fiMst) {
        this.fiMst = fiMst;
    }

    public String getFiSdtCdCsbh() {
        return fiSdtCdCsbh;
    }

    public void setFiSdtCdCsbh(String fiSdtCdCsbh) {
        this.fiSdtCdCsbh = fiSdtCdCsbh;
    }

    public String getFiSdtDdCsbh() {
        return fiSdtDdCsbh;
    }

    public void setFiSdtDdCsbh(String fiSdtDdCsbh) {
        this.fiSdtDdCsbh = fiSdtDdCsbh;
    }

    public String getFiTenCsbh() {
        return fiTenCsbh;
    }

    public void setFiTenCsbh(String fiTenCsbh) {
        this.fiTenCsbh = fiTenCsbh;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
