/*
 * Created on 18 Jul 2017 ( Time 08:43:14 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.mard.p10.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

//import javax.persistence.*;

/**
 * Persistent class for entity stored in table "TBDHANGHOA10"
 *
 * @author Telosys Tools Generator
 *
 */
//@Entity
//@Table(name = "TBDHANGHOA10", schema = "MARD")
//// Define named queries here
//@NamedQueries({
//    @NamedQuery(name = "Tbdhanghoa10.countAll", query = "SELECT COUNT(x) FROM Tbdhanghoa10 x")
//})
public class Tbdhanghoa10 implements Serializable {

//    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
//    @Id
//    //@Column(name = "FI_ID_HH", nullable = false)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDHANGHOA10_SEQ")
//    @SequenceGenerator(sequenceName = "TBDHANGHOA10_SEQ", schema = "MARD", initialValue = 1, allocationSize = 1, name = "TBDHANGHOA10_SEQ")
    private Long fiIdHh;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name = "FI_STT", nullable = false)
    private Long fiStt;

    //@Column(name = "FI_MA_HH", nullable = false)
    private Long fiMaHh;

    //@Column(name = "FI_TEN_HH", nullable = false, length = 250)
    private String fiTenHh;

    //@Column(name = "FI_NOI_SX", nullable = false, length = 250)
    private String fiNoiSx;

    //@Column(name = "FI_SOLUONG", nullable = false)
    private BigDecimal fiSoluong;

    //@Column(name = "FI_MDV_SL", nullable = false, length = 18)
    private String fiMdvSl;

    //@Column(name = "FI_TENDV_SL", nullable = false, length = 255)
    private String fiTendvSl;

    //@Column(name = "FI_TL_TINH")
    private BigDecimal fiTlTinh;

    //@Column(name = "FI_MA_TL_TINH", length = 18)
    private String fiMaTlTinh;

    //@Column(name = "FI_TENTL_TINH", length = 255)
    private String fiTentlTinh;

    //@Column(name = "FI_TL_BI")
    private BigDecimal fiTlBi;

    //@Column(name = "FI_MA_TL_BI", length = 18)
    private String fiMaTlBi;

    //@Column(name = "FI_TEN_TL_BI", length = 255)
    private String fiTenTlBi;

    //@Column(name = "FI_LOAI_BB", length = 255)
    private String fiLoaiBb;

    //@Column(name = "FI_SO_HD", length = 50)
    private String fiSoHd;

    //@Column(name = "FI_ID_HOSO")
    private Long fiIdHoso;

    //@Column(name = "FI_MA_HOSO", length = 12)
    private String fiMaHoso;

    //@Column(name = "FI_HOATDONG")
    private Long fiHoatdong;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYTAO")
    private Date fiNgaytao;

    //@Column(name = "FI_NGUOITAO", length = 100)
    private String fiNguoitao;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAY_CN")
    private Date fiNgayCn;

    //@Column(name = "FI_NGUOI_CN", length = 100)
    private String fiNguoiCn;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbdhanghoa10() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdHh(Long fiIdHh) {
        this.fiIdHh = fiIdHh;
    }

    public Long getFiIdHh() {
        return this.fiIdHh;
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

    //--- DATABASE MAPPING : FI_MA_HH ( NUMBER ) 
    public void setFiMaHh(Long fiMaHh) {
        this.fiMaHh = fiMaHh;
    }

    public Long getFiMaHh() {
        return this.fiMaHh;
    }

    //--- DATABASE MAPPING : FI_TEN_HH ( VARCHAR2 ) 
    public void setFiTenHh(String fiTenHh) {
        this.fiTenHh = fiTenHh;
    }

    public String getFiTenHh() {
        return this.fiTenHh;
    }

    //--- DATABASE MAPPING : FI_NOI_SX ( VARCHAR2 ) 
    public void setFiNoiSx(String fiNoiSx) {
        this.fiNoiSx = fiNoiSx;
    }

    public String getFiNoiSx() {
        return this.fiNoiSx;
    }

    //--- DATABASE MAPPING : FI_SOLUONG ( NUMBER ) 
    public void setFiSoluong(BigDecimal fiSoluong) {
        this.fiSoluong = fiSoluong;
    }

    public BigDecimal getFiSoluong() {
        return this.fiSoluong;
    }

    //--- DATABASE MAPPING : FI_MDV_SL ( VARCHAR2 ) 
    public void setFiMdvSl(String fiMdvSl) {
        this.fiMdvSl = fiMdvSl;
    }

    public String getFiMdvSl() {
        return this.fiMdvSl;
    }

    //--- DATABASE MAPPING : FI_TENDV_SL ( VARCHAR2 ) 
    public void setFiTendvSl(String fiTendvSl) {
        this.fiTendvSl = fiTendvSl;
    }

    public String getFiTendvSl() {
        return this.fiTendvSl;
    }

    //--- DATABASE MAPPING : FI_TL_TINH ( NUMBER ) 
    public void setFiTlTinh(BigDecimal fiTlTinh) {
        this.fiTlTinh = fiTlTinh;
    }

    public BigDecimal getFiTlTinh() {
        return this.fiTlTinh;
    }

    //--- DATABASE MAPPING : FI_MA_TL_TINH ( VARCHAR2 ) 
    public void setFiMaTlTinh(String fiMaTlTinh) {
        this.fiMaTlTinh = fiMaTlTinh;
    }

    public String getFiMaTlTinh() {
        return this.fiMaTlTinh;
    }

    //--- DATABASE MAPPING : FI_TENTL_TINH ( VARCHAR2 ) 
    public void setFiTentlTinh(String fiTentlTinh) {
        this.fiTentlTinh = fiTentlTinh;
    }

    public String getFiTentlTinh() {
        return this.fiTentlTinh;
    }

    //--- DATABASE MAPPING : FI_TL_BI ( NUMBER ) 
    public void setFiTlBi(BigDecimal fiTlBi) {
        this.fiTlBi = fiTlBi;
    }

    public BigDecimal getFiTlBi() {
        return this.fiTlBi;
    }

    //--- DATABASE MAPPING : FI_MA_TL_BI ( VARCHAR2 ) 
    public void setFiMaTlBi(String fiMaTlBi) {
        this.fiMaTlBi = fiMaTlBi;
    }

    public String getFiMaTlBi() {
        return this.fiMaTlBi;
    }

    //--- DATABASE MAPPING : FI_TEN_TL_BI ( VARCHAR2 ) 
    public void setFiTenTlBi(String fiTenTlBi) {
        this.fiTenTlBi = fiTenTlBi;
    }

    public String getFiTenTlBi() {
        return this.fiTenTlBi;
    }

    //--- DATABASE MAPPING : FI_LOAI_BB ( VARCHAR2 ) 
    public void setFiLoaiBb(String fiLoaiBb) {
        this.fiLoaiBb = fiLoaiBb;
    }

    public String getFiLoaiBb() {
        return this.fiLoaiBb;
    }

    //--- DATABASE MAPPING : FI_SO_HD ( VARCHAR2 ) 
    public void setFiSoHd(String fiSoHd) {
        this.fiSoHd = fiSoHd;
    }

    public String getFiSoHd() {
        return this.fiSoHd;
    }

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

    //--- DATABASE MAPPING : FI_HOATDONG ( NUMBER ) 
    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiHoatdong() {
        return this.fiHoatdong;
    }

    //--- DATABASE MAPPING : FI_NGAYTAO ( TIMESTAMP(6) ) 
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

    //--- DATABASE MAPPING : FI_NGAY_CN ( TIMESTAMP(6) ) 
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
//        sb.append(fiIdHh);
//        sb.append("]:");
//        sb.append(fiStt);
//        sb.append("|");
//        sb.append(fiMaHh);
//        sb.append("|");
//        sb.append(fiTenHh);
//        sb.append("|");
//        sb.append(fiNoiSx);
//        sb.append("|");
//        sb.append(fiSoluong);
//        sb.append("|");
//        sb.append(fiMdvSl);
//        sb.append("|");
//        sb.append(fiTendvSl);
//        sb.append("|");
//        sb.append(fiTlTinh);
//        sb.append("|");
//        sb.append(fiMaTlTinh);
//        sb.append("|");
//        sb.append(fiTentlTinh);
//        sb.append("|");
//        sb.append(fiTlBi);
//        sb.append("|");
//        sb.append(fiMaTlBi);
//        sb.append("|");
//        sb.append(fiTenTlBi);
//        sb.append("|");
//        sb.append(fiLoaiBb);
//        sb.append("|");
//        sb.append(fiSoHd);
//        sb.append("|");
//        sb.append(fiIdHoso);
//        sb.append("|");
//        sb.append(fiMaHoso);
//        sb.append("|");
//        sb.append(fiHoatdong);
//        sb.append("|");
//        sb.append(fiNgaytao);
//        sb.append("|");
//        sb.append(fiNguoitao);
//        sb.append("|");
//        sb.append(fiNgayCn);
//        sb.append("|");
//        sb.append(fiNguoiCn);
//        return sb.toString();
//    }

}
