/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p10.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

//import javax.persistence.*;

/**
 * Persistent class for entity stored in table "TBDMAU9A"
 *
 * //@author Telosys Tools Generator
 *
 */
//@Entity
//@Table(name = "TBDMAU9A", schema = "MARD")
// Define named queries here
//@NamedQueries({
    //@NamedQuery(name = "Tbdmau9a.countAll", query = "SELECT COUNT(x) FROM Tbdmau9a x")
//})
public class Tbdmau9a implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    //@Id
    //@Column(name = "FI_ID_VSTY", nullable = false)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDMAU9A_SEQ")
    //@SequenceGenerator(sequenceName = "TBDMAU9A_SEQ", schema = "MARD", initialValue = 1, allocationSize = 1, name = "TBDMAU9A_SEQ")
    private Long fiIdVsty;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name = "FI_ID_HOSO", nullable = false)
    private Long fiIdHoso;

    //@Column(name = "FI_MA_HOSO", nullable = false, length = 12)
    private String fiMaHoso;

    //@Column(name = "FI_LYDO_SUA", length = 2000)
    private String fiLydoSua;

    //@Column(name = "FI_TEN_CQKDDV", nullable = false, length = 250)
    private String fiTenCqkddv;

    //@Column(name = "FI_SOCV_DI", nullable = false, length = 50)
    private String fiSocvDi;

    //@Column(name = "FI_CANCU_QD", nullable = false, length = 50)
    private String fiCancuQd;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAY_QD", nullable = false)
    private Date fiNgayQd;

    //@Column(name = "FI_DONVI_QD", nullable = false, length = 250)
    private String fiDonviQd;

    //@Column(name = "FO_SO_BB", nullable = false, length = 250)
    private String foSoBb;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAY_BB", nullable = false)
    private Date fiNgayBb;

    //@Column(name = "FI_DONVI_BB", nullable = false, length = 250)
    private String fiDonviBb;

    //@Column(name = "FI_SO_VANDON", nullable = false, length = 35)
    private String fiSoVandon;

    //@Column(name = "FI_SO_TOKHAI", length = 13)
    private String fiSoTokhai;

    //@Column(name = "FI_TEN_CH", nullable = false, length = 250)
    private String fiTenCh;

    //@Column(name = "FI_DIACHI_CH", nullable = false, length = 500)
    private String fiDiachiCh;

    //@Column(name = "FI_DIENTHOAI_CH", nullable = false, length = 50)
    private String fiDienthoaiCh;

    //@Column(name = "FI_FAX_CH", nullable = false, length = 50)
    private String fiFaxCh;

    //@Column(name = "FI_EMAIL_CH", nullable = false, length = 50)
    private String fiEmailCh;

    //@Column(name = "FI_CMND_CH", nullable = false, length = 50)
    private String fiCmndCh;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYCAP_CMND", nullable = false)
    private Date fiNgaycapCmnd;

    //@Column(name = "FI_NOICAP_CMND", nullable = false, length = 500)
    private String fiNoicapCmnd;

    //@Column(name = "FI_NOIDUNG_VS", length = 1000)
    private String fiNoidungVs;

    //@Column(name = "FI_VATDUNG_LQ", length = 1000)
    private String fiVatdungLq;

    //@Column(name = "FI_DIEU_2", length = 2000)
    private String fiDieu2;

    //@Column(name = "FI_DIEU_3", length = 2000)
    private String fiDieu3;

    //@Column(name = "FI_DIEU_4", length = 2000)
    private String fiDieu4;

    //@Column(name = "FI_DIEU_5", length = 250)
    private String fiDieu5;

    //@Column(name = "FI_DIEU_7", length = 2000)
    private String fiDieu7;

    //@Column(name = "FI_NOINHAN", length = 1000)
    private String fiNoinhan;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYKY", nullable = false)
    private Date fiNgayky;

    //@Column(name = "FI_NGUOIKY", nullable = false, length = 100)
    private String fiNguoiky;

    //@Column(name = "FI_NOIKY", nullable = false, length = 100)
    private String fiNoiky;

    //@Column(name = "FI_HOATDONG", nullable = false)
    private Long fiHoatdong;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYTAO", nullable = false)
    private Date fiNgaytao;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAY_CN")
    private Date fiNgayCn;
    
    //@Transient
    private List<Tbdhanghoa9a> lstHanghoa9a;

    public List<Tbdhanghoa9a> getLstHanghoa9a() {
        return lstHanghoa9a;
    }

    public void setLstHanghoa9a(List<Tbdhanghoa9a> lstHanghoa9a) {
        this.lstHanghoa9a = lstHanghoa9a;
    }

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbdmau9a() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdVsty(Long fiIdVsty) {
        this.fiIdVsty = fiIdVsty;
    }

    public Long getFiIdVsty() {
        return this.fiIdVsty;
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

    //--- DATABASE MAPPING : FI_SOCV_DI ( VARCHAR2 ) 
    public void setFiSocvDi(String fiSocvDi) {
        this.fiSocvDi = fiSocvDi;
    }

    public String getFiSocvDi() {
        return this.fiSocvDi;
    }

    //--- DATABASE MAPPING : FI_CANCU_QD ( VARCHAR2 ) 
    public void setFiCancuQd(String fiCancuQd) {
        this.fiCancuQd = fiCancuQd;
    }

    public String getFiCancuQd() {
        return this.fiCancuQd;
    }

    //--- DATABASE MAPPING : FI_NGAY_QD ( DATE ) 
    public void setFiNgayQd(Date fiNgayQd) {
        this.fiNgayQd = fiNgayQd;
    }

    public Date getFiNgayQd() {
        return this.fiNgayQd;
    }

    //--- DATABASE MAPPING : FI_DONVI_QD ( VARCHAR2 ) 
    public void setFiDonviQd(String fiDonviQd) {
        this.fiDonviQd = fiDonviQd;
    }

    public String getFiDonviQd() {
        return this.fiDonviQd;
    }

    //--- DATABASE MAPPING : FO_SO_BB ( VARCHAR2 ) 
    public void setFoSoBb(String foSoBb) {
        this.foSoBb = foSoBb;
    }

    public String getFoSoBb() {
        return this.foSoBb;
    }

    //--- DATABASE MAPPING : FI_NGAY_BB ( DATE ) 
    public void setFiNgayBb(Date fiNgayBb) {
        this.fiNgayBb = fiNgayBb;
    }

    public Date getFiNgayBb() {
        return this.fiNgayBb;
    }

    //--- DATABASE MAPPING : FI_DONVI_BB ( VARCHAR2 ) 
    public void setFiDonviBb(String fiDonviBb) {
        this.fiDonviBb = fiDonviBb;
    }

    public String getFiDonviBb() {
        return this.fiDonviBb;
    }

    //--- DATABASE MAPPING : FI_SO_VANDON ( VARCHAR2 ) 
    public void setFiSoVandon(String fiSoVandon) {
        this.fiSoVandon = fiSoVandon;
    }

    public String getFiSoVandon() {
        return this.fiSoVandon;
    }

    //--- DATABASE MAPPING : FI_SO_TOKHAI ( VARCHAR2 ) 
    public void setFiSoTokhai(String fiSoTokhai) {
        this.fiSoTokhai = fiSoTokhai;
    }

    public String getFiSoTokhai() {
        return this.fiSoTokhai;
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

    //--- DATABASE MAPPING : FI_DIENTHOAI_CH ( VARCHAR2 ) 
    public void setFiDienthoaiCh(String fiDienthoaiCh) {
        this.fiDienthoaiCh = fiDienthoaiCh;
    }

    public String getFiDienthoaiCh() {
        return this.fiDienthoaiCh;
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

    //--- DATABASE MAPPING : FI_CMND_CH ( VARCHAR2 ) 
    public void setFiCmndCh(String fiCmndCh) {
        this.fiCmndCh = fiCmndCh;
    }

    public String getFiCmndCh() {
        return this.fiCmndCh;
    }

    //--- DATABASE MAPPING : FI_NGAYCAP_CMND ( DATE ) 
    public void setFiNgaycapCmnd(Date fiNgaycapCmnd) {
        this.fiNgaycapCmnd = fiNgaycapCmnd;
    }

    public Date getFiNgaycapCmnd() {
        return this.fiNgaycapCmnd;
    }

    //--- DATABASE MAPPING : FI_NOICAP_CMND ( VARCHAR2 ) 
    public void setFiNoicapCmnd(String fiNoicapCmnd) {
        this.fiNoicapCmnd = fiNoicapCmnd;
    }

    public String getFiNoicapCmnd() {
        return this.fiNoicapCmnd;
    }

    //--- DATABASE MAPPING : FI_NOIDUNG_VS ( VARCHAR2 ) 
    public void setFiNoidungVs(String fiNoidungVs) {
        this.fiNoidungVs = fiNoidungVs;
    }

    public String getFiNoidungVs() {
        return this.fiNoidungVs;
    }

    //--- DATABASE MAPPING : FI_VATDUNG_LQ ( VARCHAR2 ) 
    public void setFiVatdungLq(String fiVatdungLq) {
        this.fiVatdungLq = fiVatdungLq;
    }

    public String getFiVatdungLq() {
        return this.fiVatdungLq;
    }

    //--- DATABASE MAPPING : FI_DIEU_2 ( VARCHAR2 ) 
    public void setFiDieu2(String fiDieu2) {
        this.fiDieu2 = fiDieu2;
    }

    public String getFiDieu2() {
        return this.fiDieu2;
    }

    //--- DATABASE MAPPING : FI_DIEU_3 ( VARCHAR2 ) 
    public void setFiDieu3(String fiDieu3) {
        this.fiDieu3 = fiDieu3;
    }

    public String getFiDieu3() {
        return this.fiDieu3;
    }

    //--- DATABASE MAPPING : FI_DIEU_4 ( VARCHAR2 ) 
    public void setFiDieu4(String fiDieu4) {
        this.fiDieu4 = fiDieu4;
    }

    public String getFiDieu4() {
        return this.fiDieu4;
    }

    //--- DATABASE MAPPING : FI_DIEU_5 ( VARCHAR2 ) 
    public void setFiDieu5(String fiDieu5) {
        this.fiDieu5 = fiDieu5;
    }

    public String getFiDieu5() {
        return this.fiDieu5;
    }

    //--- DATABASE MAPPING : FI_DIEU_7 ( VARCHAR2 ) 
    public void setFiDieu7(String fiDieu7) {
        this.fiDieu7 = fiDieu7;
    }

    public String getFiDieu7() {
        return this.fiDieu7;
    }

    //--- DATABASE MAPPING : FI_NOINHAN ( VARCHAR2 ) 
    public void setFiNoinhan(String fiNoinhan) {
        this.fiNoinhan = fiNoinhan;
    }

    public String getFiNoinhan() {
        return this.fiNoinhan;
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
        sb.append(fiIdVsty);
        sb.append("]:");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiLydoSua);
        sb.append("|");
        sb.append(fiTenCqkddv);
        sb.append("|");
        sb.append(fiSocvDi);
        sb.append("|");
        sb.append(fiCancuQd);
        sb.append("|");
        sb.append(fiNgayQd);
        sb.append("|");
        sb.append(fiDonviQd);
        sb.append("|");
        sb.append(foSoBb);
        sb.append("|");
        sb.append(fiNgayBb);
        sb.append("|");
        sb.append(fiDonviBb);
        sb.append("|");
        sb.append(fiSoVandon);
        sb.append("|");
        sb.append(fiSoTokhai);
        sb.append("|");
        sb.append(fiTenCh);
        sb.append("|");
        sb.append(fiDiachiCh);
        sb.append("|");
        sb.append(fiDienthoaiCh);
        sb.append("|");
        sb.append(fiFaxCh);
        sb.append("|");
        sb.append(fiEmailCh);
        sb.append("|");
        sb.append(fiCmndCh);
        sb.append("|");
        sb.append(fiNgaycapCmnd);
        sb.append("|");
        sb.append(fiNoicapCmnd);
        sb.append("|");
        sb.append(fiNoidungVs);
        sb.append("|");
        sb.append(fiVatdungLq);
        sb.append("|");
        sb.append(fiDieu2);
        sb.append("|");
        sb.append(fiDieu3);
        sb.append("|");
        sb.append(fiDieu4);
        sb.append("|");
        sb.append(fiDieu5);
        sb.append("|");
        sb.append(fiDieu7);
        sb.append("|");
        sb.append(fiNoinhan);
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
        return sb.toString();
    }

}
