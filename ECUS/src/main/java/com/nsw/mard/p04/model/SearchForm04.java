package com.nsw.mard.p04.model;

import java.util.Date;

public class SearchForm04
{
    private String maHoSo;
    private Long trangThaiHoSo;
    private Date ngayNopTuNgay;
    private Date ngayNopDenNgay;
    private Date ngayCapphepTuNgay;
    private Date ngayCapphepDenNgay;
    private String maLoaiDon;
    private Long maTrangthaiPhi;
    private String nguoiTao;
    private int pageSize;
    private int currentPage;
    
    public SearchForm04() {
    }
    
    public SearchForm04(final String maHoSo, final Long trangThaiHoSo, final Date ngayNopTuNgay, final Date ngayNopDenNgay, final Date ngayCapphepTuNgay, final Date ngayCapphepDenNgay, final String maLoaiDon, final Long maTrangthaiPhi, final String nguoiTao, final int pageSize, final int currentPage) {
        this.maHoSo = maHoSo;
        this.trangThaiHoSo = trangThaiHoSo;
        this.ngayNopTuNgay = ngayNopTuNgay;
        this.ngayNopDenNgay = ngayNopDenNgay;
        this.ngayCapphepTuNgay = ngayCapphepTuNgay;
        this.ngayCapphepDenNgay = ngayCapphepDenNgay;
        this.maLoaiDon = maLoaiDon;
        this.maTrangthaiPhi = maTrangthaiPhi;
        this.nguoiTao = nguoiTao;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }
    
    public String getMaHoSo() {
        return this.maHoSo;
    }
    
    public void setMaHoSo(final String maHoSo) {
        this.maHoSo = maHoSo;
    }
    
    public Long getTrangThaiHoSo() {
        return this.trangThaiHoSo;
    }
    
    public void setTrangThaiHoSo(final Long trangThaiHoSo) {
        this.trangThaiHoSo = trangThaiHoSo;
    }
    
    public Date getNgayNopTuNgay() {
        return this.ngayNopTuNgay;
    }
    
    public void setNgayNopTuNgay(final Date ngayNopTuNgay) {
        this.ngayNopTuNgay = ngayNopTuNgay;
    }
    
    public Date getNgayNopDenNgay() {
        return this.ngayNopDenNgay;
    }
    
    public void setNgayNopDenNgay(final Date ngayNopDenNgay) {
        this.ngayNopDenNgay = ngayNopDenNgay;
    }
    
    public Date getNgayCapphepTuNgay() {
        return this.ngayCapphepTuNgay;
    }
    
    public void setNgayCapphepTuNgay(final Date ngayCapphepTuNgay) {
        this.ngayCapphepTuNgay = ngayCapphepTuNgay;
    }
    
    public Date getNgayCapphepDenNgay() {
        return this.ngayCapphepDenNgay;
    }
    
    public void setNgayCapphepDenNgay(final Date ngayCapphepDenNgay) {
        this.ngayCapphepDenNgay = ngayCapphepDenNgay;
    }
    
    public String getMaLoaiDon() {
        return this.maLoaiDon;
    }
    
    public void setMaLoaiDon(final String maLoaiDon) {
        this.maLoaiDon = maLoaiDon;
    }
    
    public Long getMaTrangthaiPhi() {
        return this.maTrangthaiPhi;
    }
    
    public void setMaTrangthaiPhi(final Long maTrangthaiPhi) {
        this.maTrangthaiPhi = maTrangthaiPhi;
    }
    
    public String getNguoiTao() {
        return this.nguoiTao;
    }
    
    public void setNguoiTao(final String nguoiTao) {
        this.nguoiTao = nguoiTao;
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
}