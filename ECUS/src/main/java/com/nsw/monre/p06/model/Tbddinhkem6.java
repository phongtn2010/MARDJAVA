package com.nsw.monre.p06.model;

import java.io.Serializable;

import java.util.Date;

public class Tbddinhkem6 implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Id
//    @Column(name="FI_ID_DK", nullable=false)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDDINHKEM6_SEQ")
//    @SequenceGenerator(sequenceName = "TBDDINHKEM6_SEQ", schema = "MONRE", initialValue = 1, allocationSize = 1, name = "TBDDINHKEM6_SEQ")
    private Long fiIdDk;

//    @Column(name="FI_MALOAI_TEP")
    private Long fiMaloaiTep;

//    @Column(name="FI_TENLOAI_TEP", length=250)
    private String fiTenloaiTep;

//    @Column(name="FI_TEN_TEP", length=250)
    private String fiTenTep;

//    @Column(name="FI_ID_TEP", length=250)
    private String fiIdTep;

//    @Column(name="FI_DUONGDAN", length=250)
    private String fiDuongdan;

//    @Column(name="FI_TENTEPTIN", length=250)
    private String fiTenteptin;

//    @Column(name="FI_ID_DT")
    private Long fiIdDt;

//    @Column(name="FI_LOAI_DT")
    private Long fiLoaiDt;

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

    public Tbddinhkem6() {
        super();
    }

    public void setFiIdDk(Long fiIdDk) {
        this.fiIdDk = fiIdDk;
    }

    public Long getFiIdDk() {
        return this.fiIdDk;
    }

    public void setFiMaloaiTep(Long fiMaloaiTep) {
        this.fiMaloaiTep = fiMaloaiTep;
    }

    public Long getFiMaloaiTep() {
        return this.fiMaloaiTep;
    }

    public void setFiTenloaiTep(String fiTenloaiTep) {
        this.fiTenloaiTep = fiTenloaiTep;
    }

    public String getFiTenloaiTep() {
        return this.fiTenloaiTep;
    }

    public void setFiTenTep(String fiTenTep) {
        this.fiTenTep = fiTenTep;
    }

    public String getFiTenTep() {
        return this.fiTenTep;
    }

    public void setFiIdTep(String fiIdTep) {
        this.fiIdTep = fiIdTep;
    }

    public String getFiIdTep() {
        return this.fiIdTep;
    }

    public void setFiDuongdan(String fiDuongdan) {
        this.fiDuongdan = fiDuongdan;
    }

    public String getFiDuongdan() {
        return this.fiDuongdan;
    }

    public void setFiTenteptin(String fiTenteptin) {
        this.fiTenteptin = fiTenteptin;
    }

    public String getFiTenteptin() {
        return this.fiTenteptin;
    }

    public void setFiIdDt(Long fiIdDt) {
        this.fiIdDt = fiIdDt;
    }

    public Long getFiIdDt() {
        return this.fiIdDt;
    }

    public void setFiLoaiDt(Long fiLoaiDt) {
        this.fiLoaiDt = fiLoaiDt;
    }

    public Long getFiLoaiDt() {
        return this.fiLoaiDt;
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
        sb.append(fiIdDk);
        sb.append("]:");
        sb.append(fiMaloaiTep);
        sb.append("|");
        sb.append(fiTenloaiTep);
        sb.append("|");
        sb.append(fiTenTep);
        sb.append("|");
        sb.append(fiIdTep);
        sb.append("|");
        sb.append(fiDuongdan);
        sb.append("|");
        sb.append(fiTenteptin);
        sb.append("|");
        sb.append(fiIdDt);
        sb.append("|");
        sb.append(fiLoaiDt);
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
