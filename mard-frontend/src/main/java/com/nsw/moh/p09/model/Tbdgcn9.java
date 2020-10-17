/*
 * Created on 15 Apr 2019 ( Time 10:10:29 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.moh.p09.model;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

public class Tbdgcn9 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdGcn;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name="FI_ID_HOSO")
    private Long fiIdHoso;

    //@Column(name="FI_MA_HOSO", length=50)
    private String fiMaHoso;

    //@Column(name="FI_SO_CHUNGNHAN", length=50)
    private String fiSoChungnhan;

    //@Column(name="FI_TEN_CH", length=255)
    private String fiTenCh;

    //@Column(name="FI_DIACHI_CH", length=500)
    private String fiDiachiCh;

    //@Column(name="FI_SDT_CH", length=50)
    private String fiSdtCh;

    //@Column(name="FI_FAX_CH", length=50)
    private String fiFaxCh;

    //@Column(name="FI_EMAIL_CH", length=255)
    private String fiEmailCh;

//    //@Column(name="FI_TEN_NG_TN", length=255)
//    private String     fiTenNgTn    ;
//
//    //@Column(name="FI_DIACHI_NG_TN", length=500)
//    private String     fiDiachiNgTn ;
//
//    //@Column(name="FI_SDT_NG_TN", length=50)
//    private String     fiSdtNgTn    ;
//
//    //@Column(name="FI_FAX_NG_TN", length=50)
//    private String     fiFaxNgTn    ;
//
//    //@Column(name="FI_EMAIL_NG_TN", length=255)
//    private String     fiEmailNgTn  ;
    //@Column(name="FI_TEN_NG_XK", length=255)
    private String fiTenNgXk;

    //@Column(name="FI_DIACHI_NG_XK", length=500)
    private String fiDiachiNgXk;

    //@Column(name="FI_SDT_NG_XK", length=50)
    private String fiSdtNgXk;

    //@Column(name="FI_FAX_NG_XK", length=50)
    private String fiFaxNgXk;

    //@Column(name="FI_EMAIL_NG_XK", length=255)
    private String fiEmailNgXk;

    //@Column(name="FI_SO_TKHQ", length=255)
    private String fiSoTkhq;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAY_NK_TU")
    private Date fiNgayNkTu;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAY_NK_DEN")
    private Date fiNgayNkDen;

    //@Column(name="FI_MA_CK_DI", length=6)
    private String fiMaCkDi;

    //@Column(name="FI_TEN_CK_DI", length=255)
    private String fiTenCkDi;

    //@Column(name="FI_MA_CK_DEN", length=6)
    private String fiMaCkDen;

    //@Column(name="FI_TEN_CK_DEN", length=255)
    private String fiTenCkDen;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAY_KT_TU")
    private Date fiNgayKtTu;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAY_KT_DEN")
    private Date fiNgayKtDen;

    //@Column(name="FI_DIADIEM_KT", length=500)
    private String fiDiadiemKt;

    //@Column(name="FI_MA_TCKT", length=12)
    private String fiMaTckt;

    //@Column(name="FI_TEN_TCKT", length=255)
    private String fiTenTckt;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAY_KY")
    private Date fiNgayKy;

    //@Column(name="FI_NGUOI_KY", length=100)
    private String fiNguoiKy;

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
    List<TbdgcnHanghoa9> lstHangHoas;

    //@Transient
    private Tbddinhkem9 dinhKem;

    //@Transient
    private List<TbdgcnNguoiTn9> lstNguoiChiuTrachNhiems;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbdgcn9() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdGcn(Long fiIdGcn) {
        this.fiIdGcn = fiIdGcn;
    }

    public Long getFiIdGcn() {
        return this.fiIdGcn;
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

    //--- DATABASE MAPPING : FI_MA_HOSO ( VARCHAR2 ) 
    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiMaHoso() {
        return this.fiMaHoso;
    }

    //--- DATABASE MAPPING : FI_SO_CHUNGNHAN ( VARCHAR2 ) 
    public void setFiSoChungnhan(String fiSoChungnhan) {
        this.fiSoChungnhan = fiSoChungnhan;
    }

    public String getFiSoChungnhan() {
        return this.fiSoChungnhan;
    }

    //--- DATABASE MAPPING : FI_TEN_CH ( VARCHAR2 ) 
    public void setFiTenCh(String fiTenCh) {
        this.fiTenCh = fiTenCh;
    }

    public String getFiTenCh() {
        return this.fiTenCh;
    }

    //--- DATABASE MAPPING : FI_DIACHI_CH ( VARCHAR2 ) 
    public void setFiDiachiCh(String fiDiachiCh) {
        this.fiDiachiCh = fiDiachiCh;
    }

    public String getFiDiachiCh() {
        return this.fiDiachiCh;
    }

    //--- DATABASE MAPPING : FI_SDT_CH ( VARCHAR2 ) 
    public void setFiSdtCh(String fiSdtCh) {
        this.fiSdtCh = fiSdtCh;
    }

    public String getFiSdtCh() {
        return this.fiSdtCh;
    }

    //--- DATABASE MAPPING : FI_FAX_CH ( VARCHAR2 ) 
    public void setFiFaxCh(String fiFaxCh) {
        this.fiFaxCh = fiFaxCh;
    }

    public String getFiFaxCh() {
        return this.fiFaxCh;
    }

    //--- DATABASE MAPPING : FI_EMAIL_CH ( VARCHAR2 ) 
    public void setFiEmailCh(String fiEmailCh) {
        this.fiEmailCh = fiEmailCh;
    }

    public String getFiEmailCh() {
        return this.fiEmailCh;
    }

//    //--- DATABASE MAPPING : FI_TEN_NG_TN ( VARCHAR2 ) 
//    public void setFiTenNgTn( String fiTenNgTn ) {
//        this.fiTenNgTn = fiTenNgTn;
//    }
//    public String getFiTenNgTn() {
//        return this.fiTenNgTn;
//    }
//
//    //--- DATABASE MAPPING : FI_DIACHI_NG_TN ( VARCHAR2 ) 
//    public void setFiDiachiNgTn( String fiDiachiNgTn ) {
//        this.fiDiachiNgTn = fiDiachiNgTn;
//    }
//    public String getFiDiachiNgTn() {
//        return this.fiDiachiNgTn;
//    }
//
//    //--- DATABASE MAPPING : FI_SDT_NG_TN ( VARCHAR2 ) 
//    public void setFiSdtNgTn( String fiSdtNgTn ) {
//        this.fiSdtNgTn = fiSdtNgTn;
//    }
//    public String getFiSdtNgTn() {
//        return this.fiSdtNgTn;
//    }
//
//    //--- DATABASE MAPPING : FI_FAX_NG_TN ( VARCHAR2 ) 
//    public void setFiFaxNgTn( String fiFaxNgTn ) {
//        this.fiFaxNgTn = fiFaxNgTn;
//    }
//    public String getFiFaxNgTn() {
//        return this.fiFaxNgTn;
//    }
//
//    //--- DATABASE MAPPING : FI_EMAIL_NG_TN ( VARCHAR2 ) 
//    public void setFiEmailNgTn( String fiEmailNgTn ) {
//        this.fiEmailNgTn = fiEmailNgTn;
//    }
//    public String getFiEmailNgTn() {
//        return this.fiEmailNgTn;
//    }
    //--- DATABASE MAPPING : FI_TEN_NG_XK ( VARCHAR2 ) 
    public void setFiTenNgXk(String fiTenNgXk) {
        this.fiTenNgXk = fiTenNgXk;
    }

    public String getFiTenNgXk() {
        return this.fiTenNgXk;
    }

    //--- DATABASE MAPPING : FI_DIACHI_NG_XK ( VARCHAR2 ) 
    public void setFiDiachiNgXk(String fiDiachiNgXk) {
        this.fiDiachiNgXk = fiDiachiNgXk;
    }

    public String getFiDiachiNgXk() {
        return this.fiDiachiNgXk;
    }

    //--- DATABASE MAPPING : FI_SDT_NG_XK ( VARCHAR2 ) 
    public void setFiSdtNgXk(String fiSdtNgXk) {
        this.fiSdtNgXk = fiSdtNgXk;
    }

    public String getFiSdtNgXk() {
        return this.fiSdtNgXk;
    }

    //--- DATABASE MAPPING : FI_FAX_NG_XK ( VARCHAR2 ) 
    public void setFiFaxNgXk(String fiFaxNgXk) {
        this.fiFaxNgXk = fiFaxNgXk;
    }

    public String getFiFaxNgXk() {
        return this.fiFaxNgXk;
    }

    //--- DATABASE MAPPING : FI_EMAIL_NG_XK ( VARCHAR2 ) 
    public void setFiEmailNgXk(String fiEmailNgXk) {
        this.fiEmailNgXk = fiEmailNgXk;
    }

    public String getFiEmailNgXk() {
        return this.fiEmailNgXk;
    }

    //--- DATABASE MAPPING : FI_SO_TKHQ ( VARCHAR2 ) 
    public void setFiSoTkhq(String fiSoTkhq) {
        this.fiSoTkhq = fiSoTkhq;
    }

    public String getFiSoTkhq() {
        return this.fiSoTkhq;
    }

    //--- DATABASE MAPPING : FI_NGAY_NK_TU ( TIMESTAMP(6) ) 
    public void setFiNgayNkTu(Date fiNgayNkTu) {
        this.fiNgayNkTu = fiNgayNkTu;
    }

    public Date getFiNgayNkTu() {
        return this.fiNgayNkTu;
    }

    //--- DATABASE MAPPING : FI_NGAY_NK_DEN ( TIMESTAMP(6) ) 
    public void setFiNgayNkDen(Date fiNgayNkDen) {
        this.fiNgayNkDen = fiNgayNkDen;
    }

    public Date getFiNgayNkDen() {
        return this.fiNgayNkDen;
    }

    //--- DATABASE MAPPING : FI_MA_CK_DI ( VARCHAR2 ) 
    public void setFiMaCkDi(String fiMaCkDi) {
        this.fiMaCkDi = fiMaCkDi;
    }

    public String getFiMaCkDi() {
        return this.fiMaCkDi;
    }

    //--- DATABASE MAPPING : FI_TEN_CK_DI ( VARCHAR2 ) 
    public void setFiTenCkDi(String fiTenCkDi) {
        this.fiTenCkDi = fiTenCkDi;
    }

    public String getFiTenCkDi() {
        return this.fiTenCkDi;
    }

    //--- DATABASE MAPPING : FI_MA_CK_DEN ( VARCHAR2 ) 
    public void setFiMaCkDen(String fiMaCkDen) {
        this.fiMaCkDen = fiMaCkDen;
    }

    public String getFiMaCkDen() {
        return this.fiMaCkDen;
    }

    //--- DATABASE MAPPING : FI_TEN_CK_DEN ( VARCHAR2 ) 
    public void setFiTenCkDen(String fiTenCkDen) {
        this.fiTenCkDen = fiTenCkDen;
    }

    public String getFiTenCkDen() {
        return this.fiTenCkDen;
    }

    //--- DATABASE MAPPING : FI_NGAY_KT_TU ( TIMESTAMP(6) ) 
    public void setFiNgayKtTu(Date fiNgayKtTu) {
        this.fiNgayKtTu = fiNgayKtTu;
    }

    public Date getFiNgayKtTu() {
        return this.fiNgayKtTu;
    }

    //--- DATABASE MAPPING : FI_NGAY_KT_DEN ( TIMESTAMP(6) ) 
    public void setFiNgayKtDen(Date fiNgayKtDen) {
        this.fiNgayKtDen = fiNgayKtDen;
    }

    public Date getFiNgayKtDen() {
        return this.fiNgayKtDen;
    }

    //--- DATABASE MAPPING : FI_DIADIEM_KT ( VARCHAR2 ) 
    public void setFiDiadiemKt(String fiDiadiemKt) {
        this.fiDiadiemKt = fiDiadiemKt;
    }

    public String getFiDiadiemKt() {
        return this.fiDiadiemKt;
    }

    //--- DATABASE MAPPING : FI_MA_TCKT ( VARCHAR2 ) 
    public void setFiMaTckt(String fiMaTckt) {
        this.fiMaTckt = fiMaTckt;
    }

    public String getFiMaTckt() {
        return this.fiMaTckt;
    }

    //--- DATABASE MAPPING : FI_TEN_TCKT ( VARCHAR2 ) 
    public void setFiTenTckt(String fiTenTckt) {
        this.fiTenTckt = fiTenTckt;
    }

    public String getFiTenTckt() {
        return this.fiTenTckt;
    }

    //--- DATABASE MAPPING : FI_NGAY_KY ( TIMESTAMP(6) ) 
    public void setFiNgayKy(Date fiNgayKy) {
        this.fiNgayKy = fiNgayKy;
    }

    public Date getFiNgayKy() {
        return this.fiNgayKy;
    }

    //--- DATABASE MAPPING : FI_NGUOI_KY ( VARCHAR2 ) 
    public void setFiNguoiKy(String fiNguoiKy) {
        this.fiNguoiKy = fiNguoiKy;
    }

    public String getFiNguoiKy() {
        return this.fiNguoiKy;
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

    public List<TbdgcnHanghoa9> getLstHangHoas() {
        return lstHangHoas;
    }

    public void setLstHangHoas(List<TbdgcnHanghoa9> lstHangHoas) {
        this.lstHangHoas = lstHangHoas;
    }

    public Tbddinhkem9 getDinhKem() {
        return dinhKem;
    }

    public void setDinhKem(Tbddinhkem9 dinhKem) {
        this.dinhKem = dinhKem;
    }

    public List<TbdgcnNguoiTn9> getLstNguoiChiuTrachNhiems() {
        return lstNguoiChiuTrachNhiems;
    }

    public void setLstNguoiChiuTrachNhiems(List<TbdgcnNguoiTn9> lstNguoiChiuTrachNhiems) {
        this.lstNguoiChiuTrachNhiems = lstNguoiChiuTrachNhiems;
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
        sb.append(fiIdGcn);
        sb.append("]:");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiSoChungnhan);
        sb.append("|");
        sb.append(fiTenCh);
        sb.append("|");
        sb.append(fiDiachiCh);
        sb.append("|");
        sb.append(fiSdtCh);
        sb.append("|");
        sb.append(fiFaxCh);
        sb.append("|");
        sb.append(fiEmailCh);
        sb.append("|");
        sb.append(fiTenNgXk);
        sb.append("|");
        sb.append(fiDiachiNgXk);
        sb.append("|");
        sb.append(fiSdtNgXk);
        sb.append("|");
        sb.append(fiFaxNgXk);
        sb.append("|");
        sb.append(fiEmailNgXk);
        sb.append("|");
        sb.append(fiSoTkhq);
        sb.append("|");
        sb.append(fiNgayNkTu);
        sb.append("|");
        sb.append(fiNgayNkDen);
        sb.append("|");
        sb.append(fiMaCkDi);
        sb.append("|");
        sb.append(fiTenCkDi);
        sb.append("|");
        sb.append(fiMaCkDen);
        sb.append("|");
        sb.append(fiTenCkDen);
        sb.append("|");
        sb.append(fiNgayKtTu);
        sb.append("|");
        sb.append(fiNgayKtDen);
        sb.append("|");
        sb.append(fiDiadiemKt);
        sb.append("|");
        sb.append(fiMaTckt);
        sb.append("|");
        sb.append(fiTenTckt);
        sb.append("|");
        sb.append(fiNgayKy);
        sb.append("|");
        sb.append(fiNguoiKy);
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
