package com.nsw.most.p04.model;

import java.io.Serializable;

import java.util.Date;

public class Tbdtbkttt4 implements Serializable {    

    private Long fiIdTbktttt;

    private String fiMaHoso;

    private String fiSoQd;

    private Date fiNgayKtra;

    private String fiDiadiemKt;

    private String fiNoidung;

    private Date fiKtDenngay;

    private Long fiHoatdong;

    private String fiNguoitao;

    private Date fiNgaytao;

    private Long fiIdHoso;

    private String fiTenTep;
    
    private Long fiTrangthai  ;
    
    private Tbddinhkem4 dinhkem;

    public Tbdtbkttt4() {
        super();
    }

    public void setFiIdTbktttt(Long fiIdTbktttt) {
        this.fiIdTbktttt = fiIdTbktttt;
    }

    public Long getFiIdTbktttt() {
        return this.fiIdTbktttt;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiMaHoso() {
        return this.fiMaHoso;
    }

    public void setFiSoQd(String fiSoQd) {
        this.fiSoQd = fiSoQd;
    }

    public String getFiSoQd() {
        return this.fiSoQd;
    }

    //--- DATABASE MAPPING : FI_NGAY_KTRA ( TIMESTAMP(6) ) 
    public void setFiNgayKtra(Date fiNgayKtra) {
        this.fiNgayKtra = fiNgayKtra;
    }

    public Date getFiNgayKtra() {
        return this.fiNgayKtra;
    }

    //--- DATABASE MAPPING : FI_DIADIEM_KT ( VARCHAR2 ) 
    public void setFiDiadiemKt(String fiDiadiemKt) {
        this.fiDiadiemKt = fiDiadiemKt;
    }

    public String getFiDiadiemKt() {
        return this.fiDiadiemKt;
    }

    //--- DATABASE MAPPING : FI_NOIDUNG ( VARCHAR2 ) 
    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public String getFiNoidung() {
        return this.fiNoidung;
    }

    //--- DATABASE MAPPING : FI_KT_DENNGAY ( DATE ) 
    public void setFiKtDenngay(Date fiKtDenngay) {
        this.fiKtDenngay = fiKtDenngay;
    }

    public Date getFiKtDenngay() {
        return this.fiKtDenngay;
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

    //--- DATABASE MAPPING : FI_ID_HOSO ( NUMBER ) 
    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    //--- DATABASE MAPPING : FI_TEN_TEP ( VARCHAR2 ) 
    public void setFiTenTep(String fiTenTep) {
        this.fiTenTep = fiTenTep;
    }

    public String getFiTenTep() {
        return this.fiTenTep;
    }
    
    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }
    
    public Tbddinhkem4 getDinhkem() {
        return dinhkem;
    }

    public void setDinhkem(Tbddinhkem4 dinhkem) {
        this.dinhkem = dinhkem;
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
        sb.append(fiIdTbktttt);
        sb.append("]:");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiSoQd);
        sb.append("|");
        sb.append(fiNgayKtra);
        sb.append("|");
        sb.append(fiDiadiemKt);
        sb.append("|");
        sb.append(fiNoidung);
        sb.append("|");
        sb.append(fiKtDenngay);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNguoitao);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiTenTep);
        return sb.toString();
    }

}
