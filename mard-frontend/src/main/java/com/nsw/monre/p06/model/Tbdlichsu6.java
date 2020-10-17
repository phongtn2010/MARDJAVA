package com.nsw.monre.p06.model;

import java.io.Serializable;

import java.util.Date;

//import javax.persistence.*;
//
//@Entity
//@Table(name="TBDLICHSU6", schema="MONRE" )
//@NamedQueries ( {
//  @NamedQuery ( name="Tbdlichsu6.countAll", query="SELECT COUNT(x) FROM Tbdlichsu6 x" )
//} )
public class Tbdlichsu6 implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Id
//    @Column(name="FI_ID_LICHSU", nullable=false)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDLICHSU6_SEQ")
//    @SequenceGenerator(sequenceName = "TBDLICHSU6_SEQ", schema = "MONRE", initialValue = 1, allocationSize = 1, name = "TBDLICHSU6_SEQ")
    private Long fiIdLichsu;

//    @Column(name="FI_ID_HOSO")
    private Long fiIdHoso;

//    @Column(name="FI_MA_HOSO", length=50)
    private String fiMaHoso;

//    @Column(name="FI_TEN_NGGUI", length=250)
    private String fiTenNggui;

//    @Column(name="FI_TEN_DVGUI", length=250)
    private String fiTenDvgui;

//    @Column(name="FI_TEN_NGNHAN", length=250)
    private String fiTenNgnhan;

//    @Column(name="FI_TEN_DVNHAN", length=250)
    private String fiTenDvnhan;

//    @Column(name="FI_TRANGTHAI")
    private Long fiTrangthai;

//    @Column(name="FI_TEN_TT", length=500)
    private String fiTenTt;

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

//    @Column(name="FI_NOIDUNG", length=500)
    private String fiNoidung;

//    @Column(name="FI_LINK_CVAN", length=2000)
    private String fiLinkCvan;

    public Tbdlichsu6() {
        super();
    }

    public void setFiIdLichsu(Long fiIdLichsu) {
        this.fiIdLichsu = fiIdLichsu;
    }

    public Long getFiIdLichsu() {
        return this.fiIdLichsu;
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

    public void setFiTenNggui(String fiTenNggui) {
        this.fiTenNggui = fiTenNggui;
    }

    public String getFiTenNggui() {
        return this.fiTenNggui;
    }

    public void setFiTenDvgui(String fiTenDvgui) {
        this.fiTenDvgui = fiTenDvgui;
    }

    public String getFiTenDvgui() {
        return this.fiTenDvgui;
    }

    public void setFiTenNgnhan(String fiTenNgnhan) {
        this.fiTenNgnhan = fiTenNgnhan;
    }

    public String getFiTenNgnhan() {
        return this.fiTenNgnhan;
    }

    public void setFiTenDvnhan(String fiTenDvnhan) {
        this.fiTenDvnhan = fiTenDvnhan;
    }

    public String getFiTenDvnhan() {
        return this.fiTenDvnhan;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public Long getFiTrangthai() {
        return this.fiTrangthai;
    }

    public void setFiTenTt(String fiTenTt) {
        this.fiTenTt = fiTenTt;
    }

    public String getFiTenTt() {
        return this.fiTenTt;
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

    public String getFiNoidung() {
        return fiNoidung;
    }

    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public String getFiLinkCvan() {
        return fiLinkCvan;
    }

    public void setFiLinkCvan(String fiLinkCvan) {
        this.fiLinkCvan = fiLinkCvan;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(fiIdLichsu);
        sb.append("]:");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiTenNggui);
        sb.append("|");
        sb.append(fiTenDvgui);
        sb.append("|");
        sb.append(fiTenNgnhan);
        sb.append("|");
        sb.append(fiTenDvnhan);
        sb.append("|");
        sb.append(fiTrangthai);
        sb.append("|");
        sb.append(fiTenTt);
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
