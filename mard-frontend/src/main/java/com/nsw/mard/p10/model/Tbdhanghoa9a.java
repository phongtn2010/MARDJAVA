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
 * Persistent class for entity stored in table "TBDHANGHOA9A"
 *
 * //@author Telosys Tools Generator
 *
 */
//@Entity
//@Table(name = "TBDHANGHOA9A", schema = "MARD")
// Define named queries here
//@NamedQueries({
    //@NamedQuery(name = "Tbdhanghoa9a.countAll", query = "SELECT COUNT(x) FROM Tbdhanghoa9a x")
//})
public class Tbdhanghoa9a implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    //@Id
    //@Column(name = "FI_ID_HANGHOA", nullable = false)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDHANGHOA9A_SEQ")
    //@SequenceGenerator(sequenceName = "TBDHANGHOA9A_SEQ", schema = "MARD", initialValue = 1, allocationSize = 1, name = "TBDHANGHOA9A_SEQ")
    private Long fiIdHanghoa;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name = "FI_ID_9A", nullable = false)
    private Long fiId9a;

    //@Column(name = "FI_STT", nullable = false)
    private Long fiStt;

    //@Column(name = "FI_TENHANG", nullable = false, length = 250)
    private String fiTenhang;

    //@Column(name = "FI_SOLUONG", nullable = false)
    private BigDecimal fiSoluong;

    //@Column(name = "FI_MA_SL", nullable = false, length = 18)
    private String fiMaSl;

    //@Column(name = "FI_TEN_SL", nullable = false, length = 255)
    private String fiTenSl;

    //@Column(name = "FI_HOATDONG", nullable = false)
    private Long fiHoatdong;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYTAO", nullable = false)
    private Date fiNgaytao;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAY_CN")
    private Date fiNgayCn;

    //@Column(name = "FI_KHOILUONG")
    private BigDecimal fiKhoiluong;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbdhanghoa9a() {
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
    //--- DATABASE MAPPING : FI_ID_9A ( NUMBER ) 
    public void setFiId9a(Long fiId9a) {
        this.fiId9a = fiId9a;
    }

    public Long getFiId9a() {
        return this.fiId9a;
    }

    //--- DATABASE MAPPING : FI_STT ( NUMBER ) 
    public void setFiStt(Long fiStt) {
        this.fiStt = fiStt;
    }

    public Long getFiStt() {
        return this.fiStt;
    }

    //--- DATABASE MAPPING : FI_TENHANG ( VARCHAR2 ) 
    public void setFiTenhang(String fiTenhang) {
        this.fiTenhang = fiTenhang;
    }

    public String getFiTenhang() {
        return this.fiTenhang;
    }

    //--- DATABASE MAPPING : FI_SOLUONG ( NUMBER ) 
    public void setFiSoluong(BigDecimal fiSoluong) {
        this.fiSoluong = fiSoluong;
    }

    public BigDecimal getFiSoluong() {
        return this.fiSoluong;
    }

    //--- DATABASE MAPPING : FI_MA_SL ( VARCHAR2 ) 
    public void setFiMaSl(String fiMaSl) {
        this.fiMaSl = fiMaSl;
    }

    public String getFiMaSl() {
        return this.fiMaSl;
    }

    //--- DATABASE MAPPING : FI_TEN_SL ( VARCHAR2 ) 
    public void setFiTenSl(String fiTenSl) {
        this.fiTenSl = fiTenSl;
    }

    public String getFiTenSl() {
        return this.fiTenSl;
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

    //--- DATABASE MAPPING : FI_KHOILUONG ( NUMBER ) 
    public void setFiKhoiluong(BigDecimal fiKhoiluong) {
        this.fiKhoiluong = fiKhoiluong;
    }

    public BigDecimal getFiKhoiluong() {
        return this.fiKhoiluong;
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
        sb.append(fiId9a);
        sb.append("|");
        sb.append(fiStt);
        sb.append("|");
        sb.append(fiTenhang);
        sb.append("|");
        sb.append(fiSoluong);
        sb.append("|");
        sb.append(fiMaSl);
        sb.append("|");
        sb.append(fiTenSl);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiNgayCn);
        sb.append("|");
        sb.append(fiKhoiluong);
        return sb.toString();
    }

}
