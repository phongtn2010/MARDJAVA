/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p04.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author QUANGNV18
 */
public class FilterForm implements Serializable{
    private String maHoSo;
    private Long trangThaiHoSo;
    private String maNhomHangHoa;
    private Date ngayTaoTuNgay;
    private Date ngayTaoDenNgay;
    private Date ngayCapTuNgay;
    private Date ngayCapDenNgay;
    private String soGiayPhep;
    private String nguoiTao;
    private int pageSize;
    private int currentPage;

    public FilterForm() {
    }

    public FilterForm(String maHoSo, Long trangThaiHoSo, String maNhomHangHoa, Date ngayTaoTuNgay, Date ngayTaoDenNgay, Date ngayCapTuNgay, Date ngayCapDenNgay, String soGiayPhep, String nguoiTao, int pageSize, int currentPage) {
        this.maHoSo = maHoSo;
        this.trangThaiHoSo = trangThaiHoSo;
        this.maNhomHangHoa = maNhomHangHoa;
        this.ngayTaoTuNgay = ngayTaoTuNgay;
        this.ngayTaoDenNgay = ngayTaoDenNgay;
        this.ngayCapTuNgay = ngayCapTuNgay;
        this.ngayCapDenNgay = ngayCapDenNgay;
        this.soGiayPhep = soGiayPhep;
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

    public String getMaNhomHangHoa() {
        return maNhomHangHoa;
    }

    public void setMaNhomHangHoa(String nhomHangHoa) {
        this.maNhomHangHoa = nhomHangHoa;
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

    public String getSoGiayPhep() {
        return soGiayPhep;
    }

    public void setSoGiayPhep(String soGiayPhep) {
        this.soGiayPhep = soGiayPhep;
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
