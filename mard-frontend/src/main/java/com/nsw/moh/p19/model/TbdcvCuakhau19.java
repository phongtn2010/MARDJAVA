/*
 * Created on 21 Dec 2018 ( Time 23:45:30 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.moh.p19.model;

import java.io.Serializable;

import java.util.Date;

public class TbdcvCuakhau19 implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
//    @Id
//    @Column(name="FI_ID_CKHAU", nullable=false)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDCV_CUAKHAU19_SEQ")
//    @SequenceGenerator(sequenceName = "TBDCV_CUAKHAU19_SEQ", schema = "MOH", initialValue = 1, allocationSize = 1, name = "TBDCV_CUAKHAU19_SEQ")
    private Long fiIdCkhau;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
//    @Column(name="FI_ID_CV")
    private Long fiIdCv;

    //@Column(name="FI_MA_HOSO", length=50)
    private String fiMaHoso;

    //@Column(name="FI_MA_CKHAU", length=10)
    private String fiMaCkhau;

    //@Column(name="FI_TEN_CKHAU", length=255)
    private String fiTenCkhau;

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

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TbdcvCuakhau19() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdCkhau(Long fiIdCkhau) {
        this.fiIdCkhau = fiIdCkhau;
    }

    public Long getFiIdCkhau() {
        return this.fiIdCkhau;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FI_ID_CV ( NUMBER ) 
    public void setFiIdCv(Long fiIdCv) {
        this.fiIdCv = fiIdCv;
    }

    public Long getFiIdCv() {
        return this.fiIdCv;
    }

    //--- DATABASE MAPPING : FI_MA_HOSO ( VARCHAR2 ) 
    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiMaHoso() {
        return this.fiMaHoso;
    }

    //--- DATABASE MAPPING : FI_MA_CKHAU ( VARCHAR2 ) 
    public void setFiMaCkhau(String fiMaCkhau) {
        this.fiMaCkhau = fiMaCkhau;
    }

    public String getFiMaCkhau() {
        return this.fiMaCkhau;
    }

    //--- DATABASE MAPPING : FI_TEN_CKHAU ( VARCHAR2 ) 
    public void setFiTenCkhau(String fiTenCkhau) {
        this.fiTenCkhau = fiTenCkhau;
    }

    public String getFiTenCkhau() {
        return this.fiTenCkhau;
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

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(fiIdCkhau);
        sb.append("]:");
        sb.append(fiIdCv);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiMaCkhau);
        sb.append("|");
        sb.append(fiTenCkhau);
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
