/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p01.model;

import java.io.Serializable;
import java.util.Date;

public class FilterForm implements Serializable {

    private String maHoSo;
    private String maThuTuc;
    private String soVanBanDN;
    private String soGiayPhep;
    private Long trangThaiHoSo;
    private Date ngayTaoTuNgay;
    private Date ngayTaoDenNgay;
    private Date ngayCapTuNgay;
    private Date ngayCapDenNgay;
    private String nguoiTao;
    private int pageSize;
    private int currentPage;

    public FilterForm() {
    }

    public FilterForm(String maHoSo, String maThuTuc, String soVanBan, String soGiayPhep,   
            Long trangThaiHoSo, Date ngayTaoTuNgay, Date ngayTaoDenNgay, 
            Date ngayCapTuNgay, Date ngayCapDenNgay, String nguoiTao, int pageSize, int currentPage) {
        this.maHoSo = maHoSo;
        this.maThuTuc = maThuTuc;
        this.soVanBanDN = soVanBan;
        this.soGiayPhep = soGiayPhep;
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

    public String getMaThuTuc() {
        return maThuTuc;
    }

    public void setMaThuTuc(String maThuTuc) {
        this.maThuTuc = maThuTuc;
    }

    public String getSoGiayPhep() {
        return soGiayPhep;
    }

    public void setSoGiayPhep(String soGiayPhep) {
        this.soGiayPhep = soGiayPhep;
    }

    public String getSoVanBanDN() {
        return soVanBanDN;
    }

    public void setSoVanBanDN(String soVanBanDN) {
        this.soVanBanDN = soVanBanDN;
    }

    public Long getTrangThaiHoSo() {
        return trangThaiHoSo;
    }

    public void setTrangThaiHoSo(Long trangThaiHoSo) {
        this.trangThaiHoSo = trangThaiHoSo;
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
}
