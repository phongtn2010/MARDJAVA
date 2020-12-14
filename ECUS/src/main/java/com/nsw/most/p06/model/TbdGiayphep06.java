/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p06.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Antsoft
 */
public class TbdGiayphep06 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Long fiCgpId;

//    @Column(name = "FI_CO_QUAN_CAP")
    private String fiCoQuanCap;

//    @Column(name = "FI_SO_GIAY_PHEP")
    private String fiSoGiayPhep;

//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgayKy;

//    @Column(name = "FI_NGUOI_KY")
    private String fiNguoiKy;

//    @Column(name = "FI_HIEULUC_TUNGAY")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiHieulucTungay;

//    @Column(name = "FI_HIEULUC_DENNGAY")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiHieulucDenngay;

//    @Column(name = "FI_TEN_TEP_TIN")
    private String fiTenTepTin;

//    @Column(name = "FI_ND_TEP_TIN")
    private String fiNdTepTin;

//    @Column(name = "FI_LOAI_HS")
    private Long fiLoaiHs;

//    @Column(name = "FI_TRANG_THAI")
    private Short fiTrangThai;

//    @Column(name = "FI_NGUOITAO")
    private String fiNguoitao;

//    @Column(name = "FI_NGAYTAO")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaytao;

//    @Column(name = "FI_NGAYCAPNHAT")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaycapnhat;

//    @Column(name = "FI_ID_HOSO")
    private Long fiIdHoso;

//    @Column(name = "FI_MA_HOSO")
    private String fiMaHoso;

//    @Column(name = "FI_HOATDONG")
    private Long fiHoatdong;

//    @Column(name = "FI_GUIID")
    private String fiGuiid;

//    @Column(name = "FI_DUONGDAN")
    private String fiDuongdan;

//    @Transient
    private List<TbdgpDactrungnguon06> lstDactrungnguon06;

    public List<TbdgpDactrungnguon06> getLstDactrungnguon06() {
        return lstDactrungnguon06;
    }

    public void setLstDactrungnguon06(List<TbdgpDactrungnguon06> lstDactrungnguon06) {
        this.lstDactrungnguon06 = lstDactrungnguon06;
    }


    public TbdGiayphep06() {
    }

    public TbdGiayphep06(Long fiCgpId) {
        this.fiCgpId = fiCgpId;
    }

    public Long getFiCgpId() {
        return fiCgpId;
    }

    public void setFiCgpId(Long fiCgpId) {
        this.fiCgpId = fiCgpId;
    }

    public String getFiCoQuanCap() {
        return fiCoQuanCap;
    }

    public void setFiCoQuanCap(String fiCoQuanCap) {
        this.fiCoQuanCap = fiCoQuanCap;
    }

    public String getFiSoGiayPhep() {
        return fiSoGiayPhep;
    }

    public void setFiSoGiayPhep(String fiSoGiayPhep) {
        this.fiSoGiayPhep = fiSoGiayPhep;
    }

    public Date getFiNgayKy() {
        return fiNgayKy;
    }

    public void setFiNgayKy(Date fiNgayKy) {
        this.fiNgayKy = fiNgayKy;
    }

    public String getFiNguoiKy() {
        return fiNguoiKy;
    }

    public void setFiNguoiKy(String fiNguoiKy) {
        this.fiNguoiKy = fiNguoiKy;
    }

    public Date getFiHieulucTungay() {
        return fiHieulucTungay;
    }

    public void setFiHieulucTungay(Date fiHieulucTungay) {
        this.fiHieulucTungay = fiHieulucTungay;
    }

    public Date getFiHieulucDenngay() {
        return fiHieulucDenngay;
    }

    public void setFiHieulucDenngay(Date fiHieulucDenngay) {
        this.fiHieulucDenngay = fiHieulucDenngay;
    }

    public String getFiTenTepTin() {
        return fiTenTepTin;
    }

    public void setFiTenTepTin(String fiTenTepTin) {
        this.fiTenTepTin = fiTenTepTin;
    }

    public String getFiNdTepTin() {
        return fiNdTepTin;
    }

    public void setFiNdTepTin(String fiNdTepTin) {
        this.fiNdTepTin = fiNdTepTin;
    }

    public Long getFiLoaiHs() {
        return fiLoaiHs;
    }

    public void setFiLoaiHs(Long fiLoaiHs) {
        this.fiLoaiHs = fiLoaiHs;
    }

    public Short getFiTrangThai() {
        return fiTrangThai;
    }

    public void setFiTrangThai(Short fiTrangThai) {
        this.fiTrangThai = fiTrangThai;
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

    public Date getFiNgaycapnhat() {
        return fiNgaycapnhat;
    }

    public void setFiNgaycapnhat(Date fiNgaycapnhat) {
        this.fiNgaycapnhat = fiNgaycapnhat;
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

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public String getFiGuiid() {
        return fiGuiid;
    }

    public void setFiGuiid(String fiGuiid) {
        this.fiGuiid = fiGuiid;
    }

    public String getFiDuongdan() {
        return fiDuongdan;
    }

    public void setFiDuongdan(String fiDuongdan) {
        this.fiDuongdan = fiDuongdan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiCgpId != null ? fiCgpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdGiayphep06)) {
            return false;
        }
        TbdGiayphep06 other = (TbdGiayphep06) object;
        if ((this.fiCgpId == null && other.fiCgpId != null) || (this.fiCgpId != null && !this.fiCgpId.equals(other.fiCgpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p02.model.TbdGiayphep02[ fiCgpId=" + fiCgpId + " ]";
    }

}
