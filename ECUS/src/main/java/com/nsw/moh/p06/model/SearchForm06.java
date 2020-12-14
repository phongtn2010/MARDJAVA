/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p06.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nsw.util.CustomJsonDateDeserializer;
import java.util.Date;
/**
 *
 * @author Nhan
 */
public class SearchForm06 {
    private String maHoso;
    private Long trangThaiHoSo;
    private Date ngayTaoTuNgay;
    private Date ngayTaoDenNgay;
    private int pageSize;
    private int currentPage;
    private String nguoiTao;

    public SearchForm06() {
    }

    public SearchForm06(String maHoSo, Long trangThaiHoSo, Date ngayTaoTuNgay, Date ngayTaoDenNgay, int pageSize, int currentPage, String nguoiTao) {
        this.maHoso = maHoSo;
        this.trangThaiHoSo = trangThaiHoSo;
        this.ngayTaoTuNgay = ngayTaoTuNgay;
        this.ngayTaoDenNgay = ngayTaoDenNgay;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.nguoiTao = nguoiTao;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }
    
    public String getMaHoSo() {
        return maHoso;
    }

    public void setMaHoSo(String maHoSo) {
        this.maHoso = maHoSo;
    }

    public Long getTrangThaiHoSo() {
        return trangThaiHoSo;
    }

    public void setTrangThaiHoSo(Long trangThaiHoSo) {
        this.trangThaiHoSo = trangThaiHoSo;
    }

    public Date getNgayTaoTuNgay() {
        return ngayTaoTuNgay;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setNgayTaoTuNgay(Date ngayTaoTuNgay) {
        this.ngayTaoTuNgay = ngayTaoTuNgay;
    }

    public Date getNgayTaoDenNgay() {
        return ngayTaoDenNgay;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setNgayTaoDenNgay(Date ngayTaoDenNgay) {
        this.ngayTaoDenNgay = ngayTaoDenNgay;
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
