/*
 * Created on 18 Jul 2017 ( Time 08:39:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.mard.p10.model;

import java.io.Serializable;
import java.util.Date;


//import javax.persistence.*;

/**
 * Persistent class for entity stored in table "TBDDINHKEM10"
 *
 * @author Telosys Tools Generator
 *
 */
//@Entity
//@Table(name = "TBDDINHKEM10", schema = "MARD")
//// Define named queries here
//@NamedQueries({
//    @NamedQuery(name = "Tbddinhkem10.countAll", query = "SELECT COUNT(x) FROM Tbddinhkem10 x")
//})
public class Tbddinhkem10 implements Serializable {

//    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
//    @Id
//    //@Column(name = "FI_ID_DINHKEM", nullable = false)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDDINHKEM10_SEQ")
//    @SequenceGenerator(sequenceName = "TBDDINHKEM10_SEQ", schema = "MARD", initialValue = 1, allocationSize = 1, name = "TBDDINHKEM10_SEQ")
    private Long fiIdDinhkem;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name = "FI_MA_LOAI", nullable = false)
    private Long fiMaLoai;

    //@Column(name = "FI_TEN_LOAI", nullable = false, length = 255)
    private String fiTenLoai;

    //@Column(name = "FI_TEN_TEP", nullable = false, length = 255)
    private String fiTenTep;

    //@Lob
    //@Column(name = "FI_NOI_DUNG", nullable = false)
    private String fiNoiDung;

    //@Column(name = "FI_ID_DT", nullable = false)
    private Long fiIdDt;

    //@Column(name = "FI_HOATDONG", nullable = false)
    private Long fiHoatdong;

    //@Column(name = "FI_DUONG_DAN", length = 2000)
    private String fiDuongDan;

    //@Column(name = "FI_GUI_ID", length = 200)
    private String fiGuiId;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYTAO", nullable = false)
    private Date fiNgaytao;

    //@Column(name = "FI_NGUOITAO", length = 100)
    private String fiNguoitao;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAY_CN")
    private Date fiNgayCn;

    //@Column(name = "FI_NGUOI_CN", length = 100)
    private String fiNguoiCn;

    // id hồ sơ
    //@Column(name = "FI_MA_DT")
    private Long fiMaDt;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbddinhkem10() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdDinhkem(Long fiIdDinhkem) {
        this.fiIdDinhkem = fiIdDinhkem;
    }

    public Long getFiIdDinhkem() {
        return this.fiIdDinhkem;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FI_MA_LOAI ( NUMBER ) 
    public void setFiMaLoai(Long fiMaLoai) {
        this.fiMaLoai = fiMaLoai;
    }

    public Long getFiMaLoai() {
        return this.fiMaLoai;
    }

    //--- DATABASE MAPPING : FI_TEN_LOAI ( VARCHAR2 ) 
    public void setFiTenLoai(String fiTenLoai) {
        this.fiTenLoai = fiTenLoai;
    }

    public String getFiTenLoai() {
        return this.fiTenLoai;
    }

    //--- DATABASE MAPPING : FI_TEN_TEP ( VARCHAR2 ) 
    public void setFiTenTep(String fiTenTep) {
        this.fiTenTep = fiTenTep;
    }

    public String getFiTenTep() {
        return this.fiTenTep;
    }

    //--- DATABASE MAPPING : FI_NOI_DUNG ( CLOB ) 
    public void setFiNoiDung(String fiNoiDung) {
        this.fiNoiDung = fiNoiDung;
    }

    public String getFiNoiDung() {
        return this.fiNoiDung;
    }

    //--- DATABASE MAPPING : FI_ID_DT ( NUMBER ) 
    public void setFiIdDt(Long fiIdDt) {
        this.fiIdDt = fiIdDt;
    }

    public Long getFiIdDt() {
        return this.fiIdDt;
    }

    //--- DATABASE MAPPING : FI_HOATDONG ( NUMBER ) 
    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiHoatdong() {
        return this.fiHoatdong;
    }

    //--- DATABASE MAPPING : FI_DUONG_DAN ( VARCHAR2 ) 
    public void setFiDuongDan(String fiDuongDan) {
        this.fiDuongDan = fiDuongDan;
    }

    public String getFiDuongDan() {
        return this.fiDuongDan;
    }

    //--- DATABASE MAPPING : FI_GUI_ID ( VARCHAR2 ) 
    public void setFiGuiId(String fiGuiId) {
        this.fiGuiId = fiGuiId;
    }

    public String getFiGuiId() {
        return this.fiGuiId;
    }

    //--- DATABASE MAPPING : FI_NGAYTAO ( DATE ) 
    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaytao() {
        return this.fiNgaytao;
    }

    //--- DATABASE MAPPING : FI_NGUOITAO ( VARCHAR2 ) 
    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public String getFiNguoitao() {
        return this.fiNguoitao;
    }

    //--- DATABASE MAPPING : FI_NGAY_CN ( DATE ) 
    public void setFiNgayCn(Date fiNgayCn) {
        this.fiNgayCn = fiNgayCn;
    }

    public Date getFiNgayCn() {
        return this.fiNgayCn;
    }

    //--- DATABASE MAPPING : FI_NGUOI_CN ( VARCHAR2 ) 
    public void setFiNguoiCn(String fiNguoiCn) {
        this.fiNguoiCn = fiNguoiCn;
    }

    public String getFiNguoiCn() {
        return this.fiNguoiCn;
    }

    //--- DATABASE MAPPING : FI_MA_DT ( NUMBER ) 
    public void setFiMaDt(Long fiMaDt) {
        this.fiMaDt = fiMaDt;
    }

    public Long getFiMaDt() {
        return this.fiMaDt;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("[");
//        sb.append(fiIdDinhkem);
//        sb.append("]:");
//        sb.append(fiMaLoai);
//        sb.append("|");
//        sb.append(fiTenLoai);
//        sb.append("|");
//        sb.append(fiTenTep);
//        // attribute 'fiNoiDung' not usable (type = Clob)
//        sb.append("|");
//        sb.append(fiIdDt);
//        sb.append("|");
//        sb.append(fiHoatdong);
//        sb.append("|");
//        sb.append(fiDuongDan);
//        sb.append("|");
//        sb.append(fiGuiId);
//        sb.append("|");
//        sb.append(fiNgaytao);
//        sb.append("|");
//        sb.append(fiNguoitao);
//        sb.append("|");
//        sb.append(fiNgayCn);
//        sb.append("|");
//        sb.append(fiNguoiCn);
//        sb.append("|");
//        sb.append(fiMaDt);
//        return sb.toString();
//    }

}
