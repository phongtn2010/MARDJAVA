/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p12.model;

/**
 *
 * @author AnPhucNguyen
 */
public class SearchProductForm {

    private String taxCode;
    private int pageSize;
    private int currentPage;
    private Long inspectionType;
    private Long goodInspectionTypes;
    private Long totalGoods;

    public Long getInspectionType() {
        return inspectionType;
    }

    public void setInspectionType(Long inspectionType) {
        this.inspectionType = inspectionType;
    }

    public Long getGoodInspectionTypes() {
        return goodInspectionTypes;
    }

    public void setGoodInspectionTypes(Long goodInspectionTypes) {
        this.goodInspectionTypes = goodInspectionTypes;
    }

    public Long getTotalGoods() {
        return totalGoods;
    }

    public void setTotalGoods(Long totalGoods) {
        this.totalGoods = totalGoods;
    }
    public SearchProductForm() {
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
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
