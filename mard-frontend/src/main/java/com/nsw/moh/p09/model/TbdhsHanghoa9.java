/*
 * Created on 15 Apr 2019 ( Time 10:11:10 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.moh.p09.model;

import java.io.Serializable;

import java.util.Date;

public class TbdhsHanghoa9 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdHanghoa;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name="FI_ID_HOSO")
    private Long fiIdHoso;

    //@Column(name="FI_TEN_HH", length=500)
    private String fiTenHh;

    //@Column(name="FI_MA_NHOM_HH")
    private Long fiMaNhomHh;

    //@Column(name="FI_TEN_NHOM_HH", length=255)
    private String fiTenNhomHh;

    //@Column(name="FI_TEN_NSX", length=255)
    private String fiTenNsx;

    //@Column(name="FI_DIACHI_NSX", length=500)
    private String fiDiachiNsx;

    //@Column(name="FI_PTKT")
    private Long fiPtkt;

    //@Column(name="FI_SO_VBXN_PTKT", length=255)
    private String fiSoVbxnPtkt;

    //@Column(name="FI_SO_CONGBO", length=255)
    private String fiSoCongbo;

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

    //@Column(name="FI_ID_NGUOI_TN")
    private Long fiIdNguoiTn;

    //@Column(name="FI_TEN_NG_TN", length=255)
    private String fiTenNgTn;

    //@Column(name="FI_MA_QG_XUATXU", length=12)
    private String fiMaQgXuatxu;

    //@Column(name="FI_TEN_QG_XUATXU", length=50)
    private String fiTenQgXuatxu;

    ////@Transient
    private Tbddinhkem9 dinhKem;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TbdhsHanghoa9() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdHanghoa(Long fiIdHanghoa) {
        this.fiIdHanghoa = fiIdHanghoa;
    }

    public Long getFiIdHanghoa() {
        return this.fiIdHanghoa;
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

    //--- DATABASE MAPPING : FI_TEN_HH ( VARCHAR2 ) 
    public void setFiTenHh(String fiTenHh) {
        this.fiTenHh = fiTenHh;
    }

    public String getFiTenHh() {
        return this.fiTenHh;
    }

    //--- DATABASE MAPPING : FI_MA_NHOM_HH ( NUMBER ) 
    public void setFiMaNhomHh(Long fiMaNhomHh) {
        this.fiMaNhomHh = fiMaNhomHh;
    }

    public Long getFiMaNhomHh() {
        return this.fiMaNhomHh;
    }

    //--- DATABASE MAPPING : FI_TEN_NHOM_HH ( VARCHAR2 ) 
    public void setFiTenNhomHh(String fiTenNhomHh) {
        this.fiTenNhomHh = fiTenNhomHh;
    }

    public String getFiTenNhomHh() {
        return this.fiTenNhomHh;
    }

    //--- DATABASE MAPPING : FI_TEN_NSX ( VARCHAR2 ) 
    public void setFiTenNsx(String fiTenNsx) {
        this.fiTenNsx = fiTenNsx;
    }

    public String getFiTenNsx() {
        return this.fiTenNsx;
    }

    //--- DATABASE MAPPING : FI_DIACHI_NSX ( VARCHAR2 ) 
    public void setFiDiachiNsx(String fiDiachiNsx) {
        this.fiDiachiNsx = fiDiachiNsx;
    }

    public String getFiDiachiNsx() {
        return this.fiDiachiNsx;
    }

    //--- DATABASE MAPPING : FI_PTKT ( NUMBER ) 
    public void setFiPtkt(Long fiPtkt) {
        this.fiPtkt = fiPtkt;
    }

    public Long getFiPtkt() {
        return this.fiPtkt;
    }

    //--- DATABASE MAPPING : FI_SO_VBXN_PTKT ( VARCHAR2 ) 
    public void setFiSoVbxnPtkt(String fiSoVbxnPtkt) {
        this.fiSoVbxnPtkt = fiSoVbxnPtkt;
    }

    public String getFiSoVbxnPtkt() {
        return this.fiSoVbxnPtkt;
    }

    //--- DATABASE MAPPING : FI_SO_CONGBO ( VARCHAR2 ) 
    public void setFiSoCongbo(String fiSoCongbo) {
        this.fiSoCongbo = fiSoCongbo;
    }

    public String getFiSoCongbo() {
        return this.fiSoCongbo;
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

    public Tbddinhkem9 getDinhKem() {
        return dinhKem;
    }

    public void setDinhKem(Tbddinhkem9 dinhKem) {
        this.dinhKem = dinhKem;
    }

    public Long getFiIdNguoiTn() {
        return fiIdNguoiTn;
    }

    public void setFiIdNguoiTn(Long fiIdNguoiTn) {
        this.fiIdNguoiTn = fiIdNguoiTn;
    }

    public String getFiTenNgTn() {
        return fiTenNgTn;
    }

    public void setFiTenNgTn(String fiTenNgTn) {
        this.fiTenNgTn = fiTenNgTn;
    }

    public String getFiMaQgXuatxu() {
        return fiMaQgXuatxu;
    }

    public void setFiMaQgXuatxu(String fiMaQgXuatxu) {
        this.fiMaQgXuatxu = fiMaQgXuatxu;
    }

    public String getFiTenQgXuatxu() {
        return fiTenQgXuatxu;
    }

    public void setFiTenQgXuatxu(String fiTenQgXuatxu) {
        this.fiTenQgXuatxu = fiTenQgXuatxu;
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
        sb.append(fiIdHanghoa);
        sb.append("]:");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiTenHh);
        sb.append("|");
        sb.append(fiMaNhomHh);
        sb.append("|");
        sb.append(fiTenNhomHh);
        sb.append("|");
        sb.append(fiTenNsx);
        sb.append("|");
        sb.append(fiDiachiNsx);
        sb.append("|");
        sb.append(fiPtkt);
        sb.append("|");
        sb.append(fiSoVbxnPtkt);
        sb.append("|");
        sb.append(fiSoCongbo);
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
