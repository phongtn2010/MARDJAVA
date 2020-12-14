/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p03.model;

import java.util.Date;
import java.util.List;

/**
 * @author HuongMK
 */
public class TbdHoso03 {

    private Long fiIdHoso;
    private String fiMaHoso;
    private Date fiNgaynop;
    private Date fiNgaycap;
    private Long fiTrangthai;
    private String fiTenTt;
    private String fiNguoitao;
    private Date fiNgaytao;
    private Date fiNgCapnhat;
    private Long fiHoatdong;
    private TbdDoanhnghiep03 doanhnghiep03;
    private List<TbdDonhang03> lstDonhang03;
    private List<TbdCuakhau03> lstCuakhau03;
    private List<TbdDinhkem03> lstDinhkem03;

    public TbdHoso03() {
    }

    public TbdHoso03(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public Date getFiNgaynop() {
        return fiNgaynop;
    }

    public void setFiNgaynop(Date fiNgaynop) {
        this.fiNgaynop = fiNgaynop;
    }

    public Date getFiNgaycap() {
        return fiNgaycap;
    }

    public void setFiNgaycap(Date fiNgaycap) {
        this.fiNgaycap = fiNgaycap;
    }

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public String getFiTenTt() {
        return fiTenTt;
    }

    public void setFiTenTt(String fiTenTt) {
        this.fiTenTt = fiTenTt;
    }

    public String getFiNguoitao() {
        return fiNguoitao;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgCapnhat() {
        return fiNgCapnhat;
    }

    public void setFiNgCapnhat(Date fiNgCapnhat) {
        this.fiNgCapnhat = fiNgCapnhat;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public TbdDoanhnghiep03 getDoanhnghiep03() {
        return doanhnghiep03;
    }

    public void setDoanhnghiep03(TbdDoanhnghiep03 doanhnghiep03) {
        this.doanhnghiep03 = doanhnghiep03;
    }

    public List<TbdDonhang03> getLstDonhang03() {
        return lstDonhang03;
    }

    public void setLstDonhang03(List<TbdDonhang03> lstDonhang03) {
        this.lstDonhang03 = lstDonhang03;
    }

    public List<TbdCuakhau03> getLstCuakhau03() {
        return lstCuakhau03;
    }

    public void setLstCuakhau03(List<TbdCuakhau03> lstCuakhau03) {
        this.lstCuakhau03 = lstCuakhau03;
    }

    public List<TbdDinhkem03> getLstDinhkem03() {
        return lstDinhkem03;
    }

    public void setLstDinhkem03(List<TbdDinhkem03> lstDinhkem03) {
        this.lstDinhkem03 = lstDinhkem03;
    }
}
