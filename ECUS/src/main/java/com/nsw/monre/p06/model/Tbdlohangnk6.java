package com.nsw.monre.p06.model;

import java.io.Serializable;

import java.util.Date;

//import javax.persistence.*;
//
//@Entity
//@Table(name="TBDLOHANGNK6", schema="MONRE" )
//@NamedQueries ( {
//  @NamedQuery ( name="Tbdlohangnk6.countAll", query="SELECT COUNT(x) FROM Tbdlohangnk6 x" )
//} )
public class Tbdlohangnk6 implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Id
//    @Column(name="FI_ID_LOHANG_NK", nullable=false)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDLOHANGNK6_SEQ")
//    @SequenceGenerator(sequenceName = "TBDLOHANGNK6_SEQ", schema = "MONRE", initialValue = 1, allocationSize = 1, name = "TBDLOHANGNK6_SEQ")
    private Long fiIdLohangNk;

//    @Column(name="FI_ID_HOSO")
    private Long fiIdHoso;

//    @Column(name="FI_MA_HOSO", length=50)
    private String fiMaHoso;

//    @Column(name="FI_ID_CAPTBNK")
    private Long fiIdCaptbnk;

//    @Column(name="FI_TEN_LOAI_PL", length=250)
    private String fiTenLoaiPl;

//    @Column(name="FI_MA_HS", length=250)
    private String fiMaHs;

//    @Column(name="FI_KL_TONG", length=20)
    private String fiKlTong;

//    @Column(name="FI_KL_NHAP", length=20)
    private String fiKlNhap;

//    @Column(name="FI_KL_DA_NK", length=20)
    private String fiKlDaNk;

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

    public Tbdlohangnk6() {
        super();
    }

    public void setFiIdLohangNk(Long fiIdLohangNk) {
        this.fiIdLohangNk = fiIdLohangNk;
    }

    public Long getFiIdLohangNk() {
        return this.fiIdLohangNk;
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

    public void setFiIdCaptbnk(Long fiIdCaptbnk) {
        this.fiIdCaptbnk = fiIdCaptbnk;
    }

    public Long getFiIdCaptbnk() {
        return this.fiIdCaptbnk;
    }

    public void setFiTenLoaiPl(String fiTenLoaiPl) {
        this.fiTenLoaiPl = fiTenLoaiPl;
    }

    public String getFiTenLoaiPl() {
        return this.fiTenLoaiPl;
    }

    public void setFiMaHs(String fiMaHs) {
        this.fiMaHs = fiMaHs;
    }

    public String getFiMaHs() {
        return this.fiMaHs;
    }

    public void setFiKlTong(String fiKlTong) {
        this.fiKlTong = fiKlTong;
    }

    public String getFiKlTong() {
        return this.fiKlTong;
    }

    public void setFiKlNhap(String fiKlNhap) {
        this.fiKlNhap = fiKlNhap;
    }

    public String getFiKlNhap() {
        return this.fiKlNhap;
    }

    public void setFiKlDaNk(String fiKlDaNk) {
        this.fiKlDaNk = fiKlDaNk;
    }

    public String getFiKlDaNk() {
        return this.fiKlDaNk;
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
        sb.append(fiIdLohangNk);
        sb.append("]:");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiIdCaptbnk);
        sb.append("|");
        sb.append(fiTenLoaiPl);
        sb.append("|");
        sb.append(fiMaHs);
        sb.append("|");
        sb.append(fiKlTong);
        sb.append("|");
        sb.append(fiKlNhap);
        sb.append("|");
        sb.append(fiKlDaNk);
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
