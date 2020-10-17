package com.nsw.monre.p06.model;

import java.io.Serializable;

import java.util.Date;

//import javax.persistence.*;
//
//@Entity
//@Table(name="TBDYCRUT6", schema="MONRE" )
//@NamedQueries ( {
//  @NamedQuery ( name="Tbdycrut6.countAll", query="SELECT COUNT(x) FROM Tbdycrut6 x" )
//} )
public class Tbdycrut6 implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Id
//    @Column(name="FI_ID_YCRUT", nullable=false)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDYCRUT6_SEQ")
//    @SequenceGenerator(sequenceName = "TBDYCRUT6_SEQ", schema = "MONRE", initialValue = 1, allocationSize = 1, name = "TBDYCRUT6_SEQ")
    private Long fiIdYcrut;

//    @Column(name="FI_ID_HOSO")
    private Long fiIdHoso;

//    @Column(name="FI_MA_HOSO", length=50)
    private String fiMaHoso;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="FI_NGAY_RUT")
    private Date fiNgayRut;

//    @Column(name="FI_NOIDUNG_YC", length=2000)
    private String fiNoidungYc;

//    @Column(name="FI_NOIDUNG_PH", length=2000)
    private String fiNoidungPh;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="FI_NGAY_XL")
    private Date fiNgayXl;

//    @Column(name="FI_DONVI_XL", length=250)
    private String fiDonviXl;

//    @Column(name="FI_TRTHAI_CU")
    private Long fiTrthaiCu;

//    @Column(name="FI_TEN_TT_CU", length=500)
    private String fiTenTtCu;

//    @Column(name="FI_HOATDONG")
    private Long fiHoatdong;

//    @Column(name="FI_NGUOITAO", length=50)
    private String fiNguoitao;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="FI_NGAYTAO")
    private Date fiNgaytao;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="FI_NG_CAPNHAT")
    private Date fiNgCapnhat;

    public Tbdycrut6() {
        super();
    }

    public void setFiIdYcrut(Long fiIdYcrut) {
        this.fiIdYcrut = fiIdYcrut;
    }

    public Long getFiIdYcrut() {
        return this.fiIdYcrut;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiMaHoso() {
        return this.fiMaHoso;
    }

    public void setFiNgayRut(Date fiNgayRut) {
        this.fiNgayRut = fiNgayRut;
    }

    public Date getFiNgayRut() {
        return this.fiNgayRut;
    }

    public void setFiNoidungYc(String fiNoidungYc) {
        this.fiNoidungYc = fiNoidungYc;
    }

    public String getFiNoidungYc() {
        return this.fiNoidungYc;
    }

    public void setFiNoidungPh(String fiNoidungPh) {
        this.fiNoidungPh = fiNoidungPh;
    }

    public String getFiNoidungPh() {
        return this.fiNoidungPh;
    }

    public void setFiNgayXl(Date fiNgayXl) {
        this.fiNgayXl = fiNgayXl;
    }

    public Date getFiNgayXl() {
        return this.fiNgayXl;
    }

    public void setFiDonviXl(String fiDonviXl) {
        this.fiDonviXl = fiDonviXl;
    }

    public String getFiDonviXl() {
        return this.fiDonviXl;
    }

    public void setFiTrthaiCu(Long fiTrthaiCu) {
        this.fiTrthaiCu = fiTrthaiCu;
    }

    public Long getFiTrthaiCu() {
        return this.fiTrthaiCu;
    }

    public void setFiTenTtCu(String fiTenTtCu) {
        this.fiTenTtCu = fiTenTtCu;
    }

    public String getFiTenTtCu() {
        return this.fiTenTtCu;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiHoatdong() {
        return this.fiHoatdong;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public String getFiNguoitao() {
        return this.fiNguoitao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaytao() {
        return this.fiNgaytao;
    }

    public void setFiNgCapnhat(Date fiNgCapnhat) {
        this.fiNgCapnhat = fiNgCapnhat;
    }

    public Date getFiNgCapnhat() {
        return this.fiNgCapnhat;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(fiIdYcrut);
        sb.append("]:");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiNgayRut);
        sb.append("|");
        sb.append(fiNoidungYc);
        sb.append("|");
        sb.append(fiNoidungPh);
        sb.append("|");
        sb.append(fiNgayXl);
        sb.append("|");
        sb.append(fiDonviXl);
        sb.append("|");
        sb.append(fiTrthaiCu);
        sb.append("|");
        sb.append(fiTenTtCu);
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
