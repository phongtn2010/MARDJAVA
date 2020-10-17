/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p03.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author QUANGNV18
 */
public class FilterForm implements Serializable{
    private String maHoSo;
    private Long trangThaiHoSo;
    private Long loaiHoSo;
    private Date ngayTaoTuNgay;
    private Date ngayTaoDenNgay;
    private Date ngayCapTuNgay;
    private Date ngayCapDenNgay;
    private String soQuyetDinh;
    private String nguoiTao;
    private int pageSize;
    private int currentPage;

    public FilterForm() {
    }

    public FilterForm(String maHoSo, Long trangThaiHoSo, Long loaiHoSo, Date ngayTaoTuNgay, Date ngayTaoDenNgay, Date ngayCapTuNgay, Date ngayCapDenNgay, String soQuyetDinh, String nguoiTao, int pageSize, int currentPage) {
        this.maHoSo = maHoSo;
        this.trangThaiHoSo = trangThaiHoSo;
        this.loaiHoSo = loaiHoSo;
        this.ngayTaoTuNgay = ngayTaoTuNgay;
        this.ngayTaoDenNgay = ngayTaoDenNgay;
        this.ngayCapTuNgay = ngayCapTuNgay;
        this.ngayCapDenNgay = ngayCapDenNgay;
        this.soQuyetDinh = soQuyetDinh;
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

    public Long getLoaiHoSo() {
        return loaiHoSo;
    }

    public void setLoaiHoSo(Long loaiHoSo) {
        this.loaiHoSo = loaiHoSo;
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

    public String getSoQuyetDinh() {
        return soQuyetDinh;
    }

    public void setSoQuyetDinh(String soQuyetDinh) {
        this.soQuyetDinh = soQuyetDinh;
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
