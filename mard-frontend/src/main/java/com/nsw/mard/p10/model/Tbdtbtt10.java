/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p10.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

//import javax.persistence.*;

/**
 * Persistent class for entity stored in table "TBDTBTT10"
 *
 * //@author Telosys Tools Generator
 *
 */
//@Entity
//@Table(name = "TBDTBTT10", schema = "MARD")
// Define named queries here
//@NamedQueries({
    //@NamedQuery(name = "Tbdtbtt10.countAll", query = "SELECT COUNT(x) FROM Tbdtbtt10 x")
//})
public class Tbdtbtt10 implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    //@Id
    //@Column(name = "FI_ID_TB", nullable = false)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDTBTT10_SEQ")
    //@SequenceGenerator(sequenceName = "TBDTBTT10_SEQ", schema = "MARD", initialValue = 1, allocationSize = 1, name = "TBDTBTT10_SEQ")
    private Long fiIdTb;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name = "FI_ID_HOSO", nullable = false)
    private Long fiIdHoso;

    //@Column(name = "FI_MA_HOSO", nullable = false, length = 12)
    private String fiMaHoso;

    //@Column(name = "FI_ND_SOTIEN", nullable = false, length = 250)
    private String fiNdSotien;

    //@Column(name = "FI_CHUTHICH", length = 500)
    private String fiChuthich;

    //@Column(name = "FI_NGUOINOP", length = 250)
    private String fiNguoinop;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYNOP")
    private Date fiNgaynop;

    //@Column(name = "FI_HOATDONG", nullable = false)
    private Long fiHoatdong;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYTAO", nullable = false)
    private Date fiNgaytao;

    //@Column(name = "FI_NGUOITAO", nullable = false, length = 100)
    private String fiNguoitao;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAY_CN")
    private Date fiNgayCn;

    //@Column(name = "FI_NGUOI_CN", length = 100)
    private String fiNguoiCn;

    //@Column(name = "FI_SOTIEN_CK")
    private BigDecimal fiSotienCk;

    //@Column(name = "FI_ID_APPHI")
    private Long fiIdApphi;

    //@Column(name = "FI_SOHOADON", length = 250)
    private String fiSohoadon;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //@Transient
    private Tbddinhkem10 dinhkem10;

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbdtbtt10() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdTb(Long fiIdTb) {
        this.fiIdTb = fiIdTb;
    }

    public Long getFiIdTb() {
        return this.fiIdTb;
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

    //--- DATABASE MAPPING : FI_ND_SOTIEN ( VARCHAR2 ) 
    public void setFiNdSotien(String fiNdSotien) {
        this.fiNdSotien = fiNdSotien;
    }

    public String getFiNdSotien() {
        return this.fiNdSotien;
    }

    //--- DATABASE MAPPING : FI_CHUTHICH ( VARCHAR2 ) 
    public void setFiChuthich(String fiChuthich) {
        this.fiChuthich = fiChuthich;
    }

    public String getFiChuthich() {
        return this.fiChuthich;
    }

    //--- DATABASE MAPPING : FI_NGUOINOP ( VARCHAR2 ) 
    public void setFiNguoinop(String fiNguoinop) {
        this.fiNguoinop = fiNguoinop;
    }

    public String getFiNguoinop() {
        return this.fiNguoinop;
    }

    //--- DATABASE MAPPING : FI_NGAYNOP ( DATE ) 
    public void setFiNgaynop(Date fiNgaynop) {
        this.fiNgaynop = fiNgaynop;
    }

    public Date getFiNgaynop() {
        return this.fiNgaynop;
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

    //--- DATABASE MAPPING : FI_SOTIEN_CK ( NUMBER ) 
    public void setFiSotienCk(BigDecimal fiSotienCk) {
        this.fiSotienCk = fiSotienCk;
    }

    public BigDecimal getFiSotienCk() {
        return this.fiSotienCk;
    }

    //--- DATABASE MAPPING : FI_ID_APPHI ( NUMBER ) 
    public void setFiIdApphi(Long fiIdApphi) {
        this.fiIdApphi = fiIdApphi;
    }

    public Long getFiIdApphi() {
        return this.fiIdApphi;
    }

    //--- DATABASE MAPPING : FI_SOHOADON ( VARCHAR2 ) 
    public void setFiSohoadon(String fiSohoadon) {
        this.fiSohoadon = fiSohoadon;
    }

    public String getFiSohoadon() {
        return this.fiSohoadon;
    }

    public Tbddinhkem10 getDinhkem10() {
        return dinhkem10;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setDinhkem10(Tbddinhkem10 dinhkem10) {
        this.dinhkem10 = dinhkem10;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    //@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(fiIdTb);
        sb.append("]:");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiNdSotien);
        sb.append("|");
        sb.append(fiChuthich);
        sb.append("|");
        sb.append(fiNguoinop);
        sb.append("|");
        sb.append(fiNgaynop);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiNguoitao);
        sb.append("|");
        sb.append(fiNgayCn);
        sb.append("|");
        sb.append(fiNguoiCn);
        sb.append("|");
        sb.append(fiSotienCk);
        sb.append("|");
        sb.append(fiIdApphi);
        sb.append("|");
        sb.append(fiSohoadon);
        return sb.toString();
    }

}