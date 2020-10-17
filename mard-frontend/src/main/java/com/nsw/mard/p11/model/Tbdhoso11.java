/*
 * Created on 18 Jul 2017 ( Time 08:55:04 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.mard.p11.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
//import javax.persistence.*;

/**
 * Persistent class for entity stored in table "TBDHOSO11"
 *
 * //@author Telosys Tools Generator
 *
 */
//@Entity
//@Table(name = "TBDHOSO11", schema = "MARD")
// Define named queries here
//@NamedQueries({
    //@NamedQuery(name = "Tbdhoso11.countAll", query = "SELECT COUNT(x) FROM Tbdhoso11 x")
//})
public class Tbdhoso11 implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    //@Id
    //@Column(name = "FI_ID_HOSO", nullable = false)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDHOSO11_SEQ")
    //@SequenceGenerator(sequenceName = "TBDHOSO11_SEQ", schema = "MARD", initialValue = 1, allocationSize = 1, name = "TBDHOSO11_SEQ")
    private Long fiIdHoso;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name = "FI_MA_HOSO", nullable = false, length = 12)
    private String fiMaHoso;

    //@Column(name = "FI_DT_DANGKY", nullable = false, length = 250)
    private String fiDtDangky;

    //@Column(name = "FI_DIACHI", nullable = false, length = 500)
    private String fiDiachi;

    //@Column(name = "FI_SOCMND", length = 250)
    private String fiSocmnd;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYCMND")
    private Date fiNgaycmnd;

    //@Column(name = "FI_NOICMND", length = 250)
    private String fiNoicmnd;

    //@Column(name = "FI_SODT", length = 250)
    private String fiSodt;

    //@Column(name = "FI_EMAIL", length = 250)
    private String fiEmail;

    //@Column(name = "FI_PT_CC", nullable = false, length = 250)
    private String fiPtCc;

    //@Column(name = "FI_DT_XK", nullable = false, length = 250)
    private String fiDtXk;

    //@Column(name = "FI_DIACHIDTXK", nullable = false, length = 250)
    private String fiDiachidtxk;

    //@Column(name = "FI_TENCK_XK", nullable = false, length = 255)
    private String fiTenckXk;

    //@Column(name = "FI_MACK_XK", nullable = false, length = 6)
    private String fiMackXk;

    //@Column(name = "FI_DT_NK", nullable = false, length = 250)
    private String fiDtNk;

    //@Column(name = "FI_DIACHIDTNK", nullable = false, length = 250)
    private String fiDiachidtnk;

    //@Column(name = "FI_TENCK_NK", nullable = false, length = 255)
    private String fiTenckNk;

    //@Column(name = "FI_MACK_NK", nullable = false, length = 6)
    private String fiMackNk;

    //@Column(name = "FI_TENQG_NK", nullable = false, length = 100)
    private String fiTenqgNk;

    //@Column(name = "FI_MAQG_NK", nullable = false, length = 2)
    private String fiMaqgNk;

    //@Column(name = "FI_MUCDICHSD", nullable = false, length = 500)
    private String fiMucdichsd;

    //@Column(name = "FI_DIADIEMDK", nullable = false, length = 250)
    private String fiDiadiemdk;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_THOIGIANDK", nullable = false)
    private Date fiThoigiandk;

    //@Column(name = "FI_DD_TG_GS", length = 250)
    private String fiDdTgGs;

    //@Column(name = "FI_SOBANGCN", length = 250)
    private String fiSobangcn;

    //@Column(name = "FI_NOIKY", nullable = false, length = 250)
    private String fiNoiky;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYKY", nullable = false)
    private Date fiNgayky;

    //@Column(name = "FI_NGUOIKY", nullable = false, length = 250)
    private String fiNguoiky;

    //@Column(name = "FI_TRANGTHAI", nullable = false)
    private Long fiTrangthai;

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

    //@Column(name = "FI_ID_HOSOCHA")
    private Long fiIdHosocha;

    //@Column(name = "FI_LAHOSOTAM")
    private Long fiLahosotam;

    //@Column(name = "FI_SOVAOSO", length = 250)
    private String fiSovaoso;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYKY_BNN")
    private Date fiNgaykyBnn;

    //@Column(name = "FI_NGUOIKY_BNN", length = 250)
    private String fiNguoikyBnn;
    
    //@Column(name = "FI_MADV_XL", length = 50)
    private String fiMadvXl;
    
    //@Column(name = "FI_TENDV_XL", length = 250)
    private String fiTendvXl;
    
    //@Column(name = "FI_TEN_HANGHOA", length = 4000)
    private String fiTenHanghoa;
    
    //@Transient
    private List<Tbdhanghoa11> lstHanghoa11;

    //@Transient
    private List<Tbddinhkem11> lstDinhkem11;
    
    //@Transient
    private String fiLydoyc;
    
    //@Transient
    private List<Tbdlichsu11> lstLichsu11;
    
    //@Transient 
    private Tbdgcn11 gcn11;

    public Tbdgcn11 getGcn11() {
        return gcn11;
    }

    public void setGcn11(Tbdgcn11 gcn11) {
        this.gcn11 = gcn11;
    }

    public String getFiTenHanghoa() {
        return fiTenHanghoa;
    }

    public void setFiTenHanghoa(String fiTenHanghoa) {
        this.fiTenHanghoa = fiTenHanghoa;
    }

    public String getFiMadvXl() {
        return fiMadvXl;
    }

    public void setFiMadvXl(String fiMadvXl) {
        this.fiMadvXl = fiMadvXl;
    }

    public String getFiTendvXl() {
        return fiTendvXl;
    }

    public void setFiTendvXl(String fiTendvXl) {
        this.fiTendvXl = fiTendvXl;
    }

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbdhoso11() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FI_MA_HOSO ( VARCHAR2 ) 
    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiMaHoso() {
        return this.fiMaHoso;
    }

    //--- DATABASE MAPPING : FI_DT_DANGKY ( VARCHAR2 ) 
    public void setFiDtDangky(String fiDtDangky) {
        this.fiDtDangky = fiDtDangky;
    }

    public String getFiDtDangky() {
        return this.fiDtDangky;
    }

    //--- DATABASE MAPPING : FI_DIACHI ( VARCHAR2 ) 
    public void setFiDiachi(String fiDiachi) {
        this.fiDiachi = fiDiachi;
    }

    public String getFiDiachi() {
        return this.fiDiachi;
    }

    //--- DATABASE MAPPING : FI_SOCMND ( VARCHAR2 ) 
    public void setFiSocmnd(String fiSocmnd) {
        this.fiSocmnd = fiSocmnd;
    }

    public String getFiSocmnd() {
        return this.fiSocmnd;
    }

    //--- DATABASE MAPPING : FI_NGAYCMND ( DATE ) 
    public void setFiNgaycmnd(Date fiNgaycmnd) {
        this.fiNgaycmnd = fiNgaycmnd;
    }

    public Date getFiNgaycmnd() {
        return this.fiNgaycmnd;
    }

    //--- DATABASE MAPPING : FI_NOICMND ( VARCHAR2 ) 
    public void setFiNoicmnd(String fiNoicmnd) {
        this.fiNoicmnd = fiNoicmnd;
    }

    public String getFiNoicmnd() {
        return this.fiNoicmnd;
    }

    //--- DATABASE MAPPING : FI_SODT ( VARCHAR2 ) 
    public void setFiSodt(String fiSodt) {
        this.fiSodt = fiSodt;
    }

    public String getFiSodt() {
        return this.fiSodt;
    }

    //--- DATABASE MAPPING : FI_EMAIL ( VARCHAR2 ) 
    public void setFiEmail(String fiEmail) {
        this.fiEmail = fiEmail;
    }

    public String getFiEmail() {
        return this.fiEmail;
    }

    //--- DATABASE MAPPING : FI_PT_CC ( VARCHAR2 ) 
    public void setFiPtCc(String fiPtCc) {
        this.fiPtCc = fiPtCc;
    }

    public String getFiPtCc() {
        return this.fiPtCc;
    }

    //--- DATABASE MAPPING : FI_DT_XK ( VARCHAR2 ) 
    public void setFiDtXk(String fiDtXk) {
        this.fiDtXk = fiDtXk;
    }

    public String getFiDtXk() {
        return this.fiDtXk;
    }

    //--- DATABASE MAPPING : FI_DIACHIDTXK ( VARCHAR2 ) 
    public void setFiDiachidtxk(String fiDiachidtxk) {
        this.fiDiachidtxk = fiDiachidtxk;
    }

    public String getFiDiachidtxk() {
        return this.fiDiachidtxk;
    }

    //--- DATABASE MAPPING : FI_TENCK_XK ( VARCHAR2 ) 
    public void setFiTenckXk(String fiTenckXk) {
        this.fiTenckXk = fiTenckXk;
    }

    public String getFiTenckXk() {
        return this.fiTenckXk;
    }

    //--- DATABASE MAPPING : FI_MACK_XK ( VARCHAR2 ) 
    public void setFiMackXk(String fiMackXk) {
        this.fiMackXk = fiMackXk;
    }

    public String getFiMackXk() {
        return this.fiMackXk;
    }

    //--- DATABASE MAPPING : FI_DT_NK ( VARCHAR2 ) 
    public void setFiDtNk(String fiDtNk) {
        this.fiDtNk = fiDtNk;
    }

    public String getFiDtNk() {
        return this.fiDtNk;
    }

    //--- DATABASE MAPPING : FI_DIACHIDTNK ( VARCHAR2 ) 
    public void setFiDiachidtnk(String fiDiachidtnk) {
        this.fiDiachidtnk = fiDiachidtnk;
    }

    public String getFiDiachidtnk() {
        return this.fiDiachidtnk;
    }

    //--- DATABASE MAPPING : FI_TENCK_NK ( VARCHAR2 ) 
    public void setFiTenckNk(String fiTenckNk) {
        this.fiTenckNk = fiTenckNk;
    }

    public String getFiTenckNk() {
        return this.fiTenckNk;
    }

    //--- DATABASE MAPPING : FI_MACK_NK ( VARCHAR2 ) 
    public void setFiMackNk(String fiMackNk) {
        this.fiMackNk = fiMackNk;
    }

    public String getFiMackNk() {
        return this.fiMackNk;
    }

    //--- DATABASE MAPPING : FI_TENQG_NK ( VARCHAR2 ) 
    public void setFiTenqgNk(String fiTenqgNk) {
        this.fiTenqgNk = fiTenqgNk;
    }

    public String getFiTenqgNk() {
        return this.fiTenqgNk;
    }

    //--- DATABASE MAPPING : FI_MAQG_NK ( VARCHAR2 ) 
    public void setFiMaqgNk(String fiMaqgNk) {
        this.fiMaqgNk = fiMaqgNk;
    }

    public String getFiMaqgNk() {
        return this.fiMaqgNk;
    }

    //--- DATABASE MAPPING : FI_MUCDICHSD ( VARCHAR2 ) 
    public void setFiMucdichsd(String fiMucdichsd) {
        this.fiMucdichsd = fiMucdichsd;
    }

    public String getFiMucdichsd() {
        return this.fiMucdichsd;
    }

    //--- DATABASE MAPPING : FI_DIADIEMDK ( VARCHAR2 ) 
    public void setFiDiadiemdk(String fiDiadiemdk) {
        this.fiDiadiemdk = fiDiadiemdk;
    }

    public String getFiDiadiemdk() {
        return this.fiDiadiemdk;
    }

    //--- DATABASE MAPPING : FI_THOIGIANDK ( DATE ) 
    public void setFiThoigiandk(Date fiThoigiandk) {
        this.fiThoigiandk = fiThoigiandk;
    }

    public Date getFiThoigiandk() {
        return this.fiThoigiandk;
    }

    //--- DATABASE MAPPING : FI_DD_TG_GS ( VARCHAR2 ) 
    public void setFiDdTgGs(String fiDdTgGs) {
        this.fiDdTgGs = fiDdTgGs;
    }

    public String getFiDdTgGs() {
        return this.fiDdTgGs;
    }

    //--- DATABASE MAPPING : FI_SOBANGCN ( VARCHAR2 ) 
    public void setFiSobangcn(String fiSobangcn) {
        this.fiSobangcn = fiSobangcn;
    }

    public String getFiSobangcn() {
        return this.fiSobangcn;
    }

    //--- DATABASE MAPPING : FI_NOIKY ( VARCHAR2 ) 
    public void setFiNoiky(String fiNoiky) {
        this.fiNoiky = fiNoiky;
    }

    public String getFiNoiky() {
        return this.fiNoiky;
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

    //--- DATABASE MAPPING : FI_TRANGTHAI ( NUMBER ) 
    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public Long getFiTrangthai() {
        return this.fiTrangthai;
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

    //--- DATABASE MAPPING : FI_ID_HOSOCHA ( NUMBER ) 
    public void setFiIdHosocha(Long fiIdHosocha) {
        this.fiIdHosocha = fiIdHosocha;
    }

    public Long getFiIdHosocha() {
        return this.fiIdHosocha;
    }

    //--- DATABASE MAPPING : FI_LAHOSOTAM ( NUMBER ) 
    public void setFiLahosotam(Long fiLahosotam) {
        this.fiLahosotam = fiLahosotam;
    }

    public Long getFiLahosotam() {
        return this.fiLahosotam;
    }

    //--- DATABASE MAPPING : FI_SOVAOSO ( VARCHAR2 ) 
    public void setFiSovaoso(String fiSovaoso) {
        this.fiSovaoso = fiSovaoso;
    }

    public String getFiSovaoso() {
        return this.fiSovaoso;
    }

    //--- DATABASE MAPPING : FI_NGAYKY_BNN ( DATE ) 
    public void setFiNgaykyBnn(Date fiNgaykyBnn) {
        this.fiNgaykyBnn = fiNgaykyBnn;
    }

    public Date getFiNgaykyBnn() {
        return this.fiNgaykyBnn;
    }

    //--- DATABASE MAPPING : FI_NGUOIKY_BNN ( VARCHAR2 ) 
    public void setFiNguoikyBnn(String fiNguoikyBnn) {
        this.fiNguoikyBnn = fiNguoikyBnn;
    }

    public String getFiNguoikyBnn() {
        return this.fiNguoikyBnn;
    }

    public List<Tbdhanghoa11> getLstHanghoa11() {
        return lstHanghoa11;
    }

    public void setLstHanghoa11(List<Tbdhanghoa11> lstHanghoa11) {
        this.lstHanghoa11 = lstHanghoa11;
    }

    public List<Tbddinhkem11> getLstDinhkem11() {
        return lstDinhkem11;
    }

    public void setLstDinhkem11(List<Tbddinhkem11> lstDinhkem11) {
        this.lstDinhkem11 = lstDinhkem11;
    }

    public String getFiLydoyc() {
        return fiLydoyc;
    }

    public void setFiLydoyc(String fiLydoyc) {
        this.fiLydoyc = fiLydoyc;
    }

    public List<Tbdlichsu11> getLstLichsu11() {
        return lstLichsu11;
    }

    public void setLstLichsu11(List<Tbdlichsu11> lstLichsu11) {
        this.lstLichsu11 = lstLichsu11;
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
        sb.append(fiIdHoso);
        sb.append("]:");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiDtDangky);
        sb.append("|");
        sb.append(fiDiachi);
        sb.append("|");
        sb.append(fiSocmnd);
        sb.append("|");
        sb.append(fiNgaycmnd);
        sb.append("|");
        sb.append(fiNoicmnd);
        sb.append("|");
        sb.append(fiSodt);
        sb.append("|");
        sb.append(fiEmail);
        sb.append("|");
        sb.append(fiPtCc);
        sb.append("|");
        sb.append(fiDtXk);
        sb.append("|");
        sb.append(fiDiachidtxk);
        sb.append("|");
        sb.append(fiTenckXk);
        sb.append("|");
        sb.append(fiMackXk);
        sb.append("|");
        sb.append(fiDtNk);
        sb.append("|");
        sb.append(fiDiachidtnk);
        sb.append("|");
        sb.append(fiTenckNk);
        sb.append("|");
        sb.append(fiMackNk);
        sb.append("|");
        sb.append(fiTenqgNk);
        sb.append("|");
        sb.append(fiMaqgNk);
        sb.append("|");
        sb.append(fiMucdichsd);
        sb.append("|");
        sb.append(fiDiadiemdk);
        sb.append("|");
        sb.append(fiThoigiandk);
        sb.append("|");
        sb.append(fiDdTgGs);
        sb.append("|");
        sb.append(fiSobangcn);
        sb.append("|");
        sb.append(fiNoiky);
        sb.append("|");
        sb.append(fiNgayky);
        sb.append("|");
        sb.append(fiNguoiky);
        sb.append("|");
        sb.append(fiTrangthai);
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
        sb.append(fiIdHosocha);
        sb.append("|");
        sb.append(fiLahosotam);
        sb.append("|");
        sb.append(fiSovaoso);
        sb.append("|");
        sb.append(fiNgaykyBnn);
        sb.append("|");
        sb.append(fiNguoikyBnn);
        return sb.toString();
    }

}
