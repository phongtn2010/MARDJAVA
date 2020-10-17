/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p01.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nsw.util.CustomJsonDateDeserializer;
import java.util.Date;


/**
 *
 * @author Phong84NV
 */
public class SearchForm01 {

    private String maHoSo;
    private String toChucKT;
    private Long trangThaiHoSo;
    private Date ngayTaoTuNgay;
    private Date ngayTaoDenNgay;
    private Date ngayGuiTuNgay;
    private Date ngayGuiDenNgay;
    private String toChucDanhGia;
    private String nguoiTao;
    private int pageSize;
    private int currentPage;

    public SearchForm01() {
    }

    public SearchForm01(String maHoSo, String toChucKT, Long trangThaiHoSo, Date ngayTaoTuNgay, 
            Date ngayTaoDenNgay, Date ngayGuiTuNgay, Date ngayGuiDenNgay, 
            String toChucDanhGia, String nguoiTao, int pageSize, int currentPage) {
        this.maHoSo = maHoSo;
        this.toChucKT = toChucKT;
        this.trangThaiHoSo = trangThaiHoSo;
        this.ngayTaoTuNgay = ngayTaoTuNgay;
        this.ngayTaoDenNgay = ngayTaoDenNgay;
        this.ngayGuiTuNgay = ngayGuiTuNgay;
        this.ngayGuiDenNgay = ngayGuiDenNgay;
        this.toChucDanhGia = toChucDanhGia;
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

    public String getToChucKT() {
        return toChucKT;
    }

    public void setToChucKT(String toChucKT) {
        this.toChucKT = toChucKT;
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

    public Date getNgayGuiTuNgay() {
        return ngayGuiTuNgay;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setNgayGuiTuNgay(Date ngayGuiTuNgay) {
        this.ngayGuiTuNgay = ngayGuiTuNgay;
    }

    public Date getNgayGuiDenNgay() {
        return ngayGuiDenNgay;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setNgayGuiDenNgay(Date ngayGuiDenNgay) {
        this.ngayGuiDenNgay = ngayGuiDenNgay;
    }

    public String getToChucDanhGia() {
        return toChucDanhGia;
    }

    public void setToChucDanhGia(String toChucDanhGia) {
        this.toChucDanhGia = toChucDanhGia;
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
