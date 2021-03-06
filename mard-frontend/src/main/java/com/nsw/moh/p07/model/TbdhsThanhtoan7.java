/*
 * Created on 24 Jan 2019 ( Time 01:39:12 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.moh.p07.model;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

public class TbdhsThanhtoan7 implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private Long fiIdThanhtoan;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name="FI_ID_HOSO")
    private Long fiIdHoso;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAY_NOP")
    private Date fiNgayNop;

    //@Column(name="FI_NGUOI_NOP", length=250)
    private String fiNguoiNop;

    //@Column(name="FI_SDT", length=50)
    private String fiSdt;

    //@Column(name="FI_SO_HOADON", length=50)
    private String fiSoHoadon;

    //@Column(name="FI_TONG_TIEN")
    private Long fiTongTien;

    //@Column(name="FI_LOAI_PHI")
    private Long fiLoaiPhi;

    //@Column(name="FI_GHI_CHU", length=500)
    private String fiGhiChu;

    //@Column(name="FI_HOATDONG")
    private Long fiHoatdong;

    //@Column(name="FI_NGUOITAO", length=50)
    private String fiNguoitao;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAYTAO")
    private Date fiNgaytao;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NG_CAPNHAT")
    private Date fiNgCapnhat;

    //@Transient
    List<Tbddinhkem7> lstDinhKemThanhToans;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TbdhsThanhtoan7() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdThanhtoan(Long fiIdThanhtoan) {
        this.fiIdThanhtoan = fiIdThanhtoan;
    }

    public Long getFiIdThanhtoan() {
        return this.fiIdThanhtoan;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FI_ID_HOSO ( NUMBER ) 
    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    //--- DATABASE MAPPING : FI_NGAY_NOP ( TIMESTAMP(6) ) 
    public void setFiNgayNop(Date fiNgayNop) {
        this.fiNgayNop = fiNgayNop;
    }

    public Date getFiNgayNop() {
        return this.fiNgayNop;
    }

    //--- DATABASE MAPPING : FI_NGUOI_NOP ( VARCHAR2 ) 
    public void setFiNguoiNop(String fiNguoiNop) {
        this.fiNguoiNop = fiNguoiNop;
    }

    public String getFiNguoiNop() {
        return this.fiNguoiNop;
    }

    //--- DATABASE MAPPING : FI_SDT ( VARCHAR2 ) 
    public void setFiSdt(String fiSdt) {
        this.fiSdt = fiSdt;
    }

    public String getFiSdt() {
        return this.fiSdt;
    }

    //--- DATABASE MAPPING : FI_SO_HOADON ( VARCHAR2 ) 
    public void setFiSoHoadon(String fiSoHoadon) {
        this.fiSoHoadon = fiSoHoadon;
    }

    public String getFiSoHoadon() {
        return this.fiSoHoadon;
    }

    //--- DATABASE MAPPING : FI_TONG_TIEN ( NUMBER ) 
    public void setFiTongTien(Long fiTongTien) {
        this.fiTongTien = fiTongTien;
    }

    public Long getFiTongTien() {
        return this.fiTongTien;
    }

    //--- DATABASE MAPPING : FI_LOAI_PHI ( NUMBER ) 
    public void setFiLoaiPhi(Long fiLoaiPhi) {
        this.fiLoaiPhi = fiLoaiPhi;
    }

    public Long getFiLoaiPhi() {
        return this.fiLoaiPhi;
    }

    //--- DATABASE MAPPING : FI_GHI_CHU ( VARCHAR2 ) 
    public void setFiGhiChu(String fiGhiChu) {
        this.fiGhiChu = fiGhiChu;
    }

    public String getFiGhiChu() {
        return this.fiGhiChu;
    }

    //--- DATABASE MAPPING : FI_HOATDONG ( NUMBER ) 
    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiHoatdong() {
        return this.fiHoatdong;
    }

    //--- DATABASE MAPPING : FI_NGUOITAO ( VARCHAR2 ) 
    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public String getFiNguoitao() {
        return this.fiNguoitao;
    }

    //--- DATABASE MAPPING : FI_NGAYTAO ( TIMESTAMP(6) ) 
    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaytao() {
        return this.fiNgaytao;
    }

    //--- DATABASE MAPPING : FI_NG_CAPNHAT ( TIMESTAMP(6) ) 
    public void setFiNgCapnhat(Date fiNgCapnhat) {
        this.fiNgCapnhat = fiNgCapnhat;
    }

    public Date getFiNgCapnhat() {
        return this.fiNgCapnhat;
    }

    public List<Tbddinhkem7> getLstDinhKemThanhToans() {
        return lstDinhKemThanhToans;
    }

    public void setLstDinhKemThanhToans(List<Tbddinhkem7> lstDinhKemThanhToans) {
        this.lstDinhKemThanhToans = lstDinhKemThanhToans;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(fiIdThanhtoan);
        sb.append("]:");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiNgayNop);
        sb.append("|");
        sb.append(fiNguoiNop);
        sb.append("|");
        sb.append(fiSdt);
        sb.append("|");
        sb.append(fiSoHoadon);
        sb.append("|");
        sb.append(fiTongTien);
        sb.append("|");
        sb.append(fiLoaiPhi);
        sb.append("|");
        sb.append(fiGhiChu);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNguoitao);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiNgCapnhat);
        return sb.toString();
    }

}
