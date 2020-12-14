/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p03.model;

import java.util.Date;


/**
 *
 * @author Fujitsu
 */
public class SearchForm03 {
    private String maHoSo;
    private String tenHangHoa;
    private Long trangThaiHoSo;
    private Date ngayGuiTuNgay;
    private Date ngayGuiDenNgay;
    private String toChucKiemTra;
    private String nguoiTao;
    private int pageSize;
    private int currentPage;

    public SearchForm03() {
    }

    public SearchForm03(String maHoSo, String tenHangHoa, Long trangThaiHoSo, Date ngayGuiTuNgay, Date ngayGuiDenNgay, String toChucKiemTra, String nguoiTao, int pageSize, int currentPage) {
        this.maHoSo = maHoSo;
        this.tenHangHoa = tenHangHoa;
        this.trangThaiHoSo = trangThaiHoSo;
        this.ngayGuiTuNgay = ngayGuiTuNgay;
        this.ngayGuiDenNgay = ngayGuiDenNgay;
        this.toChucKiemTra = toChucKiemTra;
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

    public String getTenHangHoa() {
        return tenHangHoa;
    }

    public void setTenHangHoa(String tenHangHoa) {
        this.tenHangHoa = tenHangHoa;
    }

    public Long getTrangThaiHoSo() {
        return trangThaiHoSo;
    }

    public void setTrangThaiHoSo(Long trangThaiHoSo) {
        this.trangThaiHoSo = trangThaiHoSo;
    }

    public Date getNgayGuiTuNgay() {
        return ngayGuiTuNgay;
    }

    public void setNgayGuiTuNgay(Date ngayGuiTuNgay) {
        this.ngayGuiTuNgay = ngayGuiTuNgay;
    }

    public Date getNgayGuiDenNgay() {
        return ngayGuiDenNgay;
    }

    public void setNgayGuiDenNgay(Date ngayGuiDenNgay) {
        this.ngayGuiDenNgay = ngayGuiDenNgay;
    }

    public String getToChucKiemTra() {
        return toChucKiemTra;
    }

    public void setToChucKiemTra(String toChucKiemTra) {
        this.toChucKiemTra = toChucKiemTra;
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
