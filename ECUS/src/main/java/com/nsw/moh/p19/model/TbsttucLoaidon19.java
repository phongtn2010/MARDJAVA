/*
 * Created on 22 Dec 2018 ( Time 00:47:18 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.moh.p19.model;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
import java.util.Date;

public class TbsttucLoaidon19 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long fiId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name="FI_ID_THUTUC")
    private Long fiIdThutuc;

    //@Column(name="FI_MA_THUTUC", length=50)
    private String fiMaThutuc;

    //@Column(name="FI_ID_LOAIDON")
    private Long fiIdLoaidon;

    //@Column(name="FI_MA_LOAIDON")
    private Long fiMaLoaidon;

    //@Column(name="FI_LOAI")
    private Long fiLoai;

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
    public TbsttucLoaidon19() {
        super();
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
    //--- DATABASE MAPPING : FI_ID_THUTUC ( NUMBER ) 
    public void setFiIdThutuc(Long fiIdThutuc) {
        this.fiIdThutuc = fiIdThutuc;
    }

    public Long getFiIdThutuc() {
        return this.fiIdThutuc;
    }

    //--- DATABASE MAPPING : FI_MA_THUTUC ( VARCHAR2 ) 
    public void setFiMaThutuc(String fiMaThutuc) {
        this.fiMaThutuc = fiMaThutuc;
    }

    public String getFiMaThutuc() {
        return this.fiMaThutuc;
    }

    //--- DATABASE MAPPING : FI_ID_LOAIDON ( NUMBER ) 
    public void setFiIdLoaidon(Long fiIdLoaidon) {
        this.fiIdLoaidon = fiIdLoaidon;
    }

    public Long getFiIdLoaidon() {
        return this.fiIdLoaidon;
    }

    //--- DATABASE MAPPING : FI_MA_LOAIDON ( NUMBER ) 
    public void setFiMaLoaidon(Long fiMaLoaidon) {
        this.fiMaLoaidon = fiMaLoaidon;
    }

    public Long getFiMaLoaidon() {
        return this.fiMaLoaidon;
    }

    //--- DATABASE MAPPING : FI_LOAI ( NUMBER ) 
    public void setFiLoai(Long fiLoai) {
        this.fiLoai = fiLoai;
    }

    public Long getFiLoai() {
        return this.fiLoai;
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
        sb.append(fiId);
        sb.append("]:");
        sb.append(fiIdThutuc);
        sb.append("|");
        sb.append(fiMaThutuc);
        sb.append("|");
        sb.append(fiIdLoaidon);
        sb.append("|");
        sb.append(fiMaLoaidon);
        sb.append("|");
        sb.append(fiLoai);
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