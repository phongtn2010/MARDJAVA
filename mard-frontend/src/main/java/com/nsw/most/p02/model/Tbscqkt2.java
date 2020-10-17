package com.nsw.most.p02.model;

import java.io.Serializable;
import com.nsw.annotations.*;
import java.util.Date;

/**
 * Persistent class for entity stored in table "TBSCQKT2"
 *
 * @author Telosys Tools Generator
 *
 */
public class Tbscqkt2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiId;

    private String fiMa;

    private String fiViettat;

    private String fiTen;

    private Date fiNgaytao;

    private Long fiHoatdong;

    private String fiNguoitao;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbscqkt2() {
        super();
    }

    public Tbscqkt2(Long fiId, String fiMa, String fiViettat, String fiTen, Date fiNgaytao, Long fiHoatdong, String fiNguoitao) {
        this.fiId = fiId;
        this.fiMa = fiMa;
        this.fiViettat = fiViettat;
        this.fiTen = fiTen;
        this.fiNgaytao = fiNgaytao;
        this.fiHoatdong = fiHoatdong;
        this.fiNguoitao = fiNguoitao;
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiId(Long fiId) {
        this.fiId = fiId;
    }

    public Long getFiId() {
        return this.fiId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FI_MA ( VARCHAR2 ) 
    public void setFiMa(String fiMa) {
        this.fiMa = fiMa;
    }

    public String getFiMa() {
        return this.fiMa;
    }

    //--- DATABASE MAPPING : FI_VIETTAT ( VARCHAR2 ) 
    public void setFiViettat(String fiViettat) {
        this.fiViettat = fiViettat;
    }

    public String getFiViettat() {
        return this.fiViettat;
    }

    //--- DATABASE MAPPING : FI_TEN ( VARCHAR2 ) 
    public void setFiTen(String fiTen) {
        this.fiTen = fiTen;
    }

    public String getFiTen() {
        return this.fiTen;
    }

    //--- DATABASE MAPPING : FI_NGAYTAO ( TIMESTAMP(6) ) 
    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaytao() {
        return this.fiNgaytao;
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

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(fiId);
        sb.append("]:");
        sb.append(fiMa);
        sb.append("|");
        sb.append(fiViettat);
        sb.append("|");
        sb.append(fiTen);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNguoitao);
        return sb.toString();
    }

}
