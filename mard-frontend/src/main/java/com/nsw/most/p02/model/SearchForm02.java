/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p02.model;

import java.util.Date;

/**
 *
 * @author quannn5
 */
public class SearchForm02 {
    private String maHoSo;
    private String soThongBao;
    private Long trangThaiHoSo;
    private Date ngayTaoTuNgay;
    private Date ngayTaoDenNgay;
    private Date ngayCapTuNgay;
    private Date ngayCapDenNgay;
    private String nguoiTao;
    private int pageSize;
    private int currentPage;

    public SearchForm02() {
    }

    public SearchForm02(String maHoSo, String soThongBao, Long trangThaiHoSo, Date ngayTaoTuNgay, Date ngayTaoDenNgay, Date ngayCapTuNgay, Date ngayCapDenNgay, String nguoiTao, int pageSize, int currentPage) {
        this.maHoSo = maHoSo;
        this.soThongBao = soThongBao;
        this.trangThaiHoSo = trangThaiHoSo;
        this.ngayTaoTuNgay = ngayTaoTuNgay;
        this.ngayTaoDenNgay = ngayTaoDenNgay;
        this.ngayCapTuNgay = ngayCapTuNgay;
        this.ngayCapDenNgay = ngayCapDenNgay;
        this.nguoiTao = nguoiTao;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }

    
    
    public String getMaHoSo() {
        return maHoSo;
    }

    public void setMaHoSo(String maHoSo) {
        this.maHoSo = maHoSo;
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

    public void setNgayTaoTuNgay(Date ngayTaoTuNgay) {
        this.ngayTaoTuNgay = ngayTaoTuNgay;
    }

    public Date getNgayTaoDenNgay() {
        return ngayTaoDenNgay;
    }

    public void setNgayTaoDenNgay(Date ngayTaoDenNgay) {
        this.ngayTaoDenNgay = ngayTaoDenNgay;
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

    public String getSoThongBao() {
        return soThongBao;
    }

    public void setSoThongBao(String soThongBao) {
        this.soThongBao = soThongBao;
    }

    public Date getNgayCapTuNgay() {
        return ngayCapTuNgay;
    }

    public void setNgayCapTuNgay(Date ngayCapTuNgay) {
        this.ngayCapTuNgay = ngayCapTuNgay;
    }

    public Date getNgayCapDenNgay() {
        return ngayCapDenNgay;
    }

    public void setNgayCapDenNgay(Date ngayCapDenNgay) {
        this.ngayCapDenNgay = ngayCapDenNgay;
    }
    
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    
}
