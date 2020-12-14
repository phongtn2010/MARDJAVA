/*
 * Created on 18 Jul 2017 ( Time 08:49:42 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.mard.p10.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

//import javax.persistence.*;

/**
 * Persistent class for entity stored in table "TBDMAU15C"
 *
 * //@author Telosys Tools Generator
 *
 */
//@Entity
//@Table(name = "TBDMAU15C", schema = "MARD")
// Define named queries here
//@NamedQueries({
    //@NamedQuery(name = "Tbdmau15c.countAll", query = "SELECT COUNT(x) FROM Tbdmau15c x")
//})
public class Tbdmau15c implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    //@Id
    //@Column(name = "FI_ID_MAU15C", nullable = false)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDMAU15C_SEQ")
    //@SequenceGenerator(sequenceName = "TBDMAU15C_SEQ", schema = "MARD", initialValue = 1, allocationSize = 1, name = "TBDMAU15C_SEQ")
    private Long fiIdMau15c;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name = "FI_ID_HOSO", nullable = false)
    private Long fiIdHoso;

    //@Column(name = "FI_MA_HOSO", nullable = false, length = 12)
    private String fiMaHoso;

    //@Column(name = "FI_LYDO_SUA", nullable = false, length = 2000)
    private String fiLydoSua;

    //@Column(name = "FI_TEN_CQKDDV", nullable = false, length = 250)
    private String fiTenCqkddv;

    //@Column(name = "FI_SOCV", length = 50)
    private String fiSocv;

    //@Column(name = "FI_TEN_CH", nullable = false, length = 250)
    private String fiTenCh;

    //@Column(name = "FI_DIACHI_CH", nullable = false, length = 500)
    private String fiDiachiCh;

    //@Column(name = "FI_DT_CH", length = 50)
    private String fiDtCh;

    //@Column(name = "FI_FAX_CH", length = 50)
    private String fiFaxCh;

    //@Column(name = "FI_EMAIL_CH", length = 50)
    private String fiEmailCh;

    //@Column(name = "FI_SOVANDON", nullable = false, length = 35)
    private String fiSovandon;

    //@Column(name = "FI_SOTOKHAI", length = 13)
    private String fiSotokhai;

    //@Column(name = "FI_ND_TONGSO", nullable = false, length = 500)
    private String fiNdTongso;

    //@Column(name = "FI_DT_XK", nullable = false, length = 500)
    private String fiDtXk;

    //@Column(name = "FI_NOI_SX", length = 500)
    private String fiNoiSx;

    //@Column(name = "FI_TENQG_XK", nullable = false, length = 255)
    private String fiTenqgXk;

    //@Column(name = "FI_MAQG_XK", nullable = false, length = 50)
    private String fiMaqgXk;

    //@Column(name = "FI_QG_QC", length = 255)
    private String fiQgQc;

    //@Column(name = "FI_TENCK_NHAP", nullable = false, length = 255)
    private String fiTenckNhap;

    //@Column(name = "FI_MACK_NHAP", nullable = false, length = 50)
    private String fiMackNhap;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_TG_NHAP", nullable = false)
    private Date fiTgNhap;

    //@Column(name = "FI_NOI_DEN", length = 255)
    private String fiNoiDen;

    //@Column(name = "FI_VD_LQ", length = 500)
    private String fiVdLq;

    //@Column(name = "FI_HOSO_LQ", length = 500)
    private String fiHosoLq;

    //@Column(name = "FI_PT_VC", length = 250)
    private String fiPtVc;

    //@Column(name = "FI_PPTDKT", length = 500)
    private String fiPptdkt;

    //@Column(name = "FI_NONGDO", length = 50)
    private String fiNongdo;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_CACHLY_DN", nullable = false)
    private Date fiCachlyDn;

    //@Column(name = "FI_KDDV", nullable = false, length = 100)
    private String fiKddv;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYKY", nullable = false)
    private Date fiNgayky;

    //@Column(name = "FI_NGUOIKY", nullable = false, length = 100)
    private String fiNguoiky;

    //@Column(name = "FI_NOIKY", length = 100)
    private String fiNoiky;

    //@Column(name = "FI_HOATDONG", nullable = false)
    private Long fiHoatdong;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYTAO", nullable = false)
    private Date fiNgaytao;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAY_CN")
    private Date fiNgayCn;

    //@Column(name = "FI_TONG_SL")
    private Long fiTongSl;

    //@Column(name = "FI_TONG_TL")
    private Long fiTongTl;
    //@Transient
    private List<Tbdhanghoa15c> lstHanghoa15c;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbdmau15c() {
        super();
    }

    public List<Tbdhanghoa15c> getLstHanghoa15c() {
        return lstHanghoa15c;
    }

    public void setLstHanghoa15c(List<Tbdhanghoa15c> lstHanghoa15c) {
        this.lstHanghoa15c = lstHanghoa15c;
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdMau15c(Long fiIdMau15c) {
        this.fiIdMau15c = fiIdMau15c;
    }

    public Long getFiIdMau15c() {
        return this.fiIdMau15c;
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

    //--- DATABASE MAPPING : FI_LYDO_SUA ( VARCHAR2 ) 
    public void setFiLydoSua(String fiLydoSua) {
        this.fiLydoSua = fiLydoSua;
    }

    public String getFiLydoSua() {
        return this.fiLydoSua;
    }

    //--- DATABASE MAPPING : FI_TEN_CQKDDV ( VARCHAR2 ) 
    public void setFiTenCqkddv(String fiTenCqkddv) {
        this.fiTenCqkddv = fiTenCqkddv;
    }

    public String getFiTenCqkddv() {
        return this.fiTenCqkddv;
    }

    //--- DATABASE MAPPING : FI_SOCV ( VARCHAR2 ) 
    public void setFiSocv(String fiSocv) {
        this.fiSocv = fiSocv;
    }

    public String getFiSocv() {
        return this.fiSocv;
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

    //--- DATABASE MAPPING : FI_DT_CH ( VARCHAR2 ) 
    public void setFiDtCh(String fiDtCh) {
        this.fiDtCh = fiDtCh;
    }

    public String getFiDtCh() {
        return this.fiDtCh;
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

    //--- DATABASE MAPPING : FI_SOVANDON ( VARCHAR2 ) 
    public void setFiSovandon(String fiSovandon) {
        this.fiSovandon = fiSovandon;
    }

    public String getFiSovandon() {
        return this.fiSovandon;
    }

    //--- DATABASE MAPPING : FI_SOTOKHAI ( VARCHAR2 ) 
    public void setFiSotokhai(String fiSotokhai) {
        this.fiSotokhai = fiSotokhai;
    }

    public String getFiSotokhai() {
        return this.fiSotokhai;
    }

    //--- DATABASE MAPPING : FI_ND_TONGSO ( VARCHAR2 ) 
    public void setFiNdTongso(String fiNdTongso) {
        this.fiNdTongso = fiNdTongso;
    }

    public String getFiNdTongso() {
        return this.fiNdTongso;
    }

    //--- DATABASE MAPPING : FI_DT_XK ( VARCHAR2 ) 
    public void setFiDtXk(String fiDtXk) {
        this.fiDtXk = fiDtXk;
    }

    public String getFiDtXk() {
        return this.fiDtXk;
    }

    //--- DATABASE MAPPING : FI_NOI_SX ( VARCHAR2 ) 
    public void setFiNoiSx(String fiNoiSx) {
        this.fiNoiSx = fiNoiSx;
    }

    public String getFiNoiSx() {
        return this.fiNoiSx;
    }

    //--- DATABASE MAPPING : FI_TENQG_XK ( VARCHAR2 ) 
    public void setFiTenqgXk(String fiTenqgXk) {
        this.fiTenqgXk = fiTenqgXk;
    }

    public String getFiTenqgXk() {
        return this.fiTenqgXk;
    }

    //--- DATABASE MAPPING : FI_MAQG_XK ( VARCHAR2 ) 
    public void setFiMaqgXk(String fiMaqgXk) {
        this.fiMaqgXk = fiMaqgXk;
    }

    public String getFiMaqgXk() {
        return this.fiMaqgXk;
    }

    //--- DATABASE MAPPING : FI_QG_QC ( VARCHAR2 ) 
    public void setFiQgQc(String fiQgQc) {
        this.fiQgQc = fiQgQc;
    }

    public String getFiQgQc() {
        return this.fiQgQc;
    }

    //--- DATABASE MAPPING : FI_TENCK_NHAP ( VARCHAR2 ) 
    public void setFiTenckNhap(String fiTenckNhap) {
        this.fiTenckNhap = fiTenckNhap;
    }

    public String getFiTenckNhap() {
        return this.fiTenckNhap;
    }

    //--- DATABASE MAPPING : FI_MACK_NHAP ( VARCHAR2 ) 
    public void setFiMackNhap(String fiMackNhap) {
        this.fiMackNhap = fiMackNhap;
    }

    public String getFiMackNhap() {
        return this.fiMackNhap;
    }

    //--- DATABASE MAPPING : FI_TG_NHAP ( DATE ) 
    public void setFiTgNhap(Date fiTgNhap) {
        this.fiTgNhap = fiTgNhap;
    }

    public Date getFiTgNhap() {
        return this.fiTgNhap;
    }

    //--- DATABASE MAPPING : FI_NOI_DEN ( VARCHAR2 ) 
    public void setFiNoiDen(String fiNoiDen) {
        this.fiNoiDen = fiNoiDen;
    }

    public String getFiNoiDen() {
        return this.fiNoiDen;
    }

    //--- DATABASE MAPPING : FI_VD_LQ ( VARCHAR2 ) 
    public void setFiVdLq(String fiVdLq) {
        this.fiVdLq = fiVdLq;
    }

    public String getFiVdLq() {
        return this.fiVdLq;
    }

    //--- DATABASE MAPPING : FI_HOSO_LQ ( VARCHAR2 ) 
    public void setFiHosoLq(String fiHosoLq) {
        this.fiHosoLq = fiHosoLq;
    }

    public String getFiHosoLq() {
        return this.fiHosoLq;
    }

    //--- DATABASE MAPPING : FI_PT_VC ( VARCHAR2 ) 
    public void setFiPtVc(String fiPtVc) {
        this.fiPtVc = fiPtVc;
    }

    public String getFiPtVc() {
        return this.fiPtVc;
    }

    //--- DATABASE MAPPING : FI_PPTDKT ( VARCHAR2 ) 
    public void setFiPptdkt(String fiPptdkt) {
        this.fiPptdkt = fiPptdkt;
    }

    public String getFiPptdkt() {
        return this.fiPptdkt;
    }

    //--- DATABASE MAPPING : FI_NONGDO ( VARCHAR2 ) 
    public void setFiNongdo(String fiNongdo) {
        this.fiNongdo = fiNongdo;
    }

    public String getFiNongdo() {
        return this.fiNongdo;
    }

    //--- DATABASE MAPPING : FI_CACHLY_DN ( DATE ) 
    public void setFiCachlyDn(Date fiCachlyDn) {
        this.fiCachlyDn = fiCachlyDn;
    }

    public Date getFiCachlyDn() {
        return this.fiCachlyDn;
    }

    //--- DATABASE MAPPING : FI_KDDV ( VARCHAR2 ) 
    public void setFiKddv(String fiKddv) {
        this.fiKddv = fiKddv;
    }

    public String getFiKddv() {
        return this.fiKddv;
    }

    //--- DATABASE MAPPING : FI_NGAYKY ( DATE ) 
    public void setFiNgayky(Date fiNgayky) {
        this.fiNgayky = fiNgayky;
    }

    public Date getFiNgayky() {
        return this.fiNgayky;
    }

    //--- DATABASE MAPPING : FI_NGUOIKY ( VARCHAR2 ) 
    public void setFiNguoiky(String fiNguoiky) {
        this.fiNguoiky = fiNguoiky;
    }

    public String getFiNguoiky() {
        return this.fiNguoiky;
    }

    //--- DATABASE MAPPING : FI_NOIKY ( VARCHAR2 ) 
    public void setFiNoiky(String fiNoiky) {
        this.fiNoiky = fiNoiky;
    }

    public String getFiNoiky() {
        return this.fiNoiky;
    }

    //--- DATABASE MAPPING : FI_HOATDONG ( NUMBER ) 
    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiHoatdong() {
        return this.fiHoatdong;
    }

    //--- DATABASE MAPPING : FI_NGAYTAO ( DATE ) 
    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaytao() {
        return this.fiNgaytao;
    }

    //--- DATABASE MAPPING : FI_NGAY_CN ( DATE ) 
    public void setFiNgayCn(Date fiNgayCn) {
        this.fiNgayCn = fiNgayCn;
    }

    public Date getFiNgayCn() {
        return this.fiNgayCn;
    }

    //--- DATABASE MAPPING : FI_TONG_SL ( NUMBER ) 
    public void setFiTongSl(Long fiTongSl) {
        this.fiTongSl = fiTongSl;
    }

    public Long getFiTongSl() {
        return this.fiTongSl;
    }

    //--- DATABASE MAPPING : FI_TONG_TL ( NUMBER ) 
    public void setFiTongTl(Long fiTongTl) {
        this.fiTongTl = fiTongTl;
    }

    public Long getFiTongTl() {
        return this.fiTongTl;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    //@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(fiIdMau15c);
        sb.append("]:");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiLydoSua);
        sb.append("|");
        sb.append(fiTenCqkddv);
        sb.append("|");
        sb.append(fiSocv);
        sb.append("|");
        sb.append(fiTenCh);
        sb.append("|");
        sb.append(fiDiachiCh);
        sb.append("|");
        sb.append(fiDtCh);
        sb.append("|");
        sb.append(fiFaxCh);
        sb.append("|");
        sb.append(fiEmailCh);
        sb.append("|");
        sb.append(fiSovandon);
        sb.append("|");
        sb.append(fiSotokhai);
        sb.append("|");
        sb.append(fiNdTongso);
        sb.append("|");
        sb.append(fiDtXk);
        sb.append("|");
        sb.append(fiNoiSx);
        sb.append("|");
        sb.append(fiTenqgXk);
        sb.append("|");
        sb.append(fiMaqgXk);
        sb.append("|");
        sb.append(fiQgQc);
        sb.append("|");
        sb.append(fiTenckNhap);
        sb.append("|");
        sb.append(fiMackNhap);
        sb.append("|");
        sb.append(fiTgNhap);
        sb.append("|");
        sb.append(fiNoiDen);
        sb.append("|");
        sb.append(fiVdLq);
        sb.append("|");
        sb.append(fiHosoLq);
        sb.append("|");
        sb.append(fiPtVc);
        sb.append("|");
        sb.append(fiPptdkt);
        sb.append("|");
        sb.append(fiNongdo);
        sb.append("|");
        sb.append(fiCachlyDn);
        sb.append("|");
        sb.append(fiKddv);
        sb.append("|");
        sb.append(fiNgayky);
        sb.append("|");
        sb.append(fiNguoiky);
        sb.append("|");
        sb.append(fiNoiky);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiNgayCn);
        sb.append("|");
        sb.append(fiTongSl);
        sb.append("|");
        sb.append(fiTongTl);
        return sb.toString();
    }
}
