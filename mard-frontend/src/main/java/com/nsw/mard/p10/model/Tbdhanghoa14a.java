/*
 * Created on 18 Jul 2017 ( Time 08:43:47 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.mard.p10.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

//import javax.persistence.*;

/**
 * Persistent class for entity stored in table "TBDHANGHOA14A"
 *
 * //@author Telosys Tools Generator
 *
 */
//@Entity
//@Table(name = "TBDHANGHOA14A", schema = "MARD")
// Define named queries here
//@NamedQueries({
    //@NamedQuery(name = "Tbdhanghoa14a.countAll", query = "SELECT COUNT(x) FROM Tbdhanghoa14a x")
//})
public class Tbdhanghoa14a implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    //@Id
    //@Column(name = "FI_ID_HANGHOA", nullable = false)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDHANGHOA14A_SEQ")
    //@SequenceGenerator(sequenceName = "TBDHANGHOA14A_SEQ", schema = "MARD", initialValue = 1, allocationSize = 1, name = "TBDHANGHOA14A_SEQ")
    private Long fiIdHanghoa;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name = "FI_STT", nullable = false)
    private Long fiStt;

    //@Column(name = "FI_TEN_HH", nullable = false, length = 250)
    private String fiTenHh;

    //@Column(name = "FI_TUOI", nullable = false, length = 250)
    private String fiTuoi;

    //@Column(name = "FI_TINHBIET", nullable = false)
    private BigDecimal fiTinhbiet;

    //@Column(name = "FI_SOLUONG", nullable = false)
    private BigDecimal fiSoluong;

    //@Column(name = "FI_DV_SL", nullable = false, length = 50)
    private String fiDvSl;

    //@Column(name = "FI_TEN_SL", nullable = false, length = 255)
    private String fiTenSl;

    //@Column(name = "FI_MUCDICH", length = 500)
    private String fiMucdich;

    //@Column(name = "FI_ID_MAU14A", nullable = false)
    private Long fiIdMau14a;

    //@Column(name = "FI_HOATDONG", nullable = false)
    private Long fiHoatdong;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYTAO", nullable = false)
    private Date fiNgaytao;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAY_CN")
    private Date fiNgayCn;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbdhanghoa14a() {
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
    //--- DATABASE MAPPING : FI_STT ( NUMBER ) 
    public void setFiStt(Long fiStt) {
        this.fiStt = fiStt;
    }

    public Long getFiStt() {
        return this.fiStt;
    }

    //--- DATABASE MAPPING : FI_TEN_HH ( VARCHAR2 ) 
    public void setFiTenHh(String fiTenHh) {
        this.fiTenHh = fiTenHh;
    }

    public String getFiTenHh() {
        return this.fiTenHh;
    }

    //--- DATABASE MAPPING : FI_TUOI ( VARCHAR2 ) 
    public void setFiTuoi(String fiTuoi) {
        this.fiTuoi = fiTuoi;
    }

    public String getFiTuoi() {
        return this.fiTuoi;
    }

    //--- DATABASE MAPPING : FI_TINHBIET ( NUMBER ) 
    public void setFiTinhbiet(BigDecimal fiTinhbiet) {
        this.fiTinhbiet = fiTinhbiet;
    }

    public BigDecimal getFiTinhbiet() {
        return this.fiTinhbiet;
    }

    //--- DATABASE MAPPING : FI_SOLUONG ( NUMBER ) 
    public void setFiSoluong(BigDecimal fiSoluong) {
        this.fiSoluong = fiSoluong;
    }

    public BigDecimal getFiSoluong() {
        return this.fiSoluong;
    }

    //--- DATABASE MAPPING : FI_DV_SL ( VARCHAR2 ) 
    public void setFiDvSl(String fiDvSl) {
        this.fiDvSl = fiDvSl;
    }

    public String getFiDvSl() {
        return this.fiDvSl;
    }

    //--- DATABASE MAPPING : FI_TEN_SL ( VARCHAR2 ) 
    public void setFiTenSl(String fiTenSl) {
        this.fiTenSl = fiTenSl;
    }

    public String getFiTenSl() {
        return this.fiTenSl;
    }

    //--- DATABASE MAPPING : FI_MUCDICH ( VARCHAR2 ) 
    public void setFiMucdich(String fiMucdich) {
        this.fiMucdich = fiMucdich;
    }

    public String getFiMucdich() {
        return this.fiMucdich;
    }

    //--- DATABASE MAPPING : FI_ID_MAU14A ( NUMBER ) 
    public void setFiIdMau14a(Long fiIdMau14a) {
        this.fiIdMau14a = fiIdMau14a;
    }

    public Long getFiIdMau14a() {
        return this.fiIdMau14a;
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
        sb.append(fiIdHanghoa);
        sb.append("]:");
        sb.append(fiStt);
        sb.append("|");
        sb.append(fiTenHh);
        sb.append("|");
        sb.append(fiTuoi);
        sb.append("|");
        sb.append(fiTinhbiet);
        sb.append("|");
        sb.append(fiSoluong);
        sb.append("|");
        sb.append(fiDvSl);
        sb.append("|");
        sb.append(fiTenSl);
        sb.append("|");
        sb.append(fiMucdich);
        sb.append("|");
        sb.append(fiIdMau14a);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiNgayCn);
        return sb.toString();
    }

}
