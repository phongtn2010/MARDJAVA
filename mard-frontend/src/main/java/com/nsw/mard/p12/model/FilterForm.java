/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p12.model;

import java.io.Serializable;
import java.util.Date;

public class FilterForm implements Serializable {

    private String maHoSo;
    private Long loaiHoSo;
    private String soCongVan;
    private Long trangThaiHoSo;
    private Date ngayTaoTuNgay;
    private Date ngayTaoDenNgay;
    private Date ngayCapTuNgay;
    private Date ngayCapDenNgay;
    private String nguoiTao;
    private String tenDoanhNghiep;
    private String tenHangHoa;
    private int pageSize;
    private int currentPage;

    public FilterForm() {
    }

    public FilterForm(String maHoSo, Long loaiHoSo, String soCongVan, Long trangThaiHoSo, Date ngayTaoTuNgay, Date ngayTaoDenNgay, Date ngayCapTuNgay, Date ngayCapDenNgay, String nguoiTao, String tenDoanhNghiep, String tenHangHoa, int pageSize, int currentPage) {
        this.maHoSo = maHoSo;
        this.loaiHoSo = loaiHoSo;
        this.soCongVan = soCongVan;
        this.trangThaiHoSo = trangThaiHoSo;
        this.ngayTaoTuNgay = ngayTaoTuNgay;
        this.ngayTaoDenNgay = ngayTaoDenNgay;
        this.ngayCapTuNgay = ngayCapTuNgay;
        this.ngayCapDenNgay = ngayCapDenNgay;
        this.nguoiTao = nguoiTao;
        this.tenDoanhNghiep = tenDoanhNghiep;
        this.tenHangHoa = tenHangHoa;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }

    public String getMaHoSo() {
        return maHoSo;
    }

    public void setMaHoSo(String maHoSo) {
        this.maHoSo = maHoSo;
    }

    public Long getLoaiHoSo() {
        return loaiHoSo;
    }

    public void setLoaiHoSo(Long loaiHoSo) {
        this.loaiHoSo = loaiHoSo;
    }

    public String getSoCongVan() {
        return soCongVan;
    }

    public void setSoCongVan(String soCongVan) {
        this.soCongVan = soCongVan;
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

    public String getTenDoanhNghiep() {
        return tenDoanhNghiep;
    }

    public void setTenDoanhNghiep(String tenDoanhNghiep) {
        this.tenDoanhNghiep = tenDoanhNghiep;
    }

    public String getTenHangHoa() {
        return tenHangHoa;
    }

    public void setTenHangHoa(String tenHangHoa) {
        this.tenHangHoa = tenHangHoa;
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
