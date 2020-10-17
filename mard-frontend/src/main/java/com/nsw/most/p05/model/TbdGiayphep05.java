/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p05.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Antsoft
 */
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "CapGiayPhep")
public class TbdGiayphep05 implements Serializable {

//    @XmlTransient
    private static final long serialVersionUID = 1L;

//    @XmlTransient
    private Long fiIdCapgiayphep;

//    @XmlElement(name = "co_quan_cap")
    private String fiCoQuanCap;

//    @XmlElement(name = "so_giay_phep")
    private String fiSoGiayPhep;

//    @XmlElement(name = "ngay_ky")
    private Date fiNgayKy;

//    @XmlElement(name = "nguoi_ky")
    private String fiNguoiKy;

//    @XmlElement(name = "hieuluc_tungay")
    private Date fiHieulucTungay;

//    @XmlElement(name = "hieuluc_denngay")
    private Date fiHieulucDenngay;

//    @XmlElement(name = "ten_tep_tin")
    private String fiTenTepTin;

//    @XmlElement(name = "noidung_tep_tin")
    private String fiNoidungTepTin;

//    @XmlElement(name = "loai_hs")
    private Short fiLoaiHs;

//    @XmlTransient
    private Short fiTrangThai;

//    @XmlTransient
    private Long fiIdHoso;

//    @XmlTransient
    private String fiMaHoso;

//    @XmlTransient
    private String fiNguoitao;

//    @XmlTransient
    private Date fiNgaytao;

//    @XmlTransient
    private Date fiNgaycapnhat;

//    @XmlTransient
    private Long fiHoatdong;

//    @Column(name = "FI_GUIID")
    private String fiGuiid;

//    @Column(name = "FI_DUONGDAN")
    private String fiDuongdan;

//    @XmlElementWrapper(name = "DS_Dac_Trung_Nguon")
//    @XmlElement(name = "Thong_tin_Dac_Trung_nguon")
    private List<TbdgpDactrungnguon05> lstDactrungnguon05;

    public List<TbdgpDactrungnguon05> getLstDactrungnguon05() {
        return lstDactrungnguon05;
    }

    public void setLstDactrungnguon05(List<TbdgpDactrungnguon05> lstDactrungnguon05) {
        this.lstDactrungnguon05 = lstDactrungnguon05;
    }

    public TbdGiayphep05() {
    }

    public TbdGiayphep05(Long fiIdCapgiayphep) {
        this.fiIdCapgiayphep = fiIdCapgiayphep;
    }

    public Long getFiIdCapgiayphep() {
        return fiIdCapgiayphep;
    }

    public void setFiIdCapgiayphep(Long fiIdCapgiayphep) {
        this.fiIdCapgiayphep = fiIdCapgiayphep;
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

    public String getFiNoidungTepTin() {
        return fiNoidungTepTin;
    }

    public void setFiNoidungTepTin(String fiNoidungTepTin) {
        this.fiNoidungTepTin = fiNoidungTepTin;
    }

    public Short getFiLoaiHs() {
        return fiLoaiHs;
    }

    public void setFiLoaiHs(Short fiLoaiHs) {
        this.fiLoaiHs = fiLoaiHs;
    }

    public Short getFiTrangThai() {
        return fiTrangThai;
    }

    public void setFiTrangThai(Short fiTrangThai) {
        this.fiTrangThai = fiTrangThai;
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
        hash += (fiIdCapgiayphep != null ? fiIdCapgiayphep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdGiayphep05)) {
            return false;
        }
        TbdGiayphep05 other = (TbdGiayphep05) object;
        if ((this.fiIdCapgiayphep == null && other.fiIdCapgiayphep != null) || (this.fiIdCapgiayphep != null && !this.fiIdCapgiayphep.equals(other.fiIdCapgiayphep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p01.model.TbdGiayphep01[ fiIdCapgiayphep=" + fiIdCapgiayphep + " ]";
    }

}
