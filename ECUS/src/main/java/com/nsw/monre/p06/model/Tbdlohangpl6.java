package com.nsw.monre.p06.model;

import java.io.Serializable;

import java.util.Date;

//import javax.persistence.*;
//
//@Entity
//@Table(name="TBDLOHANGPL6", schema="MONRE" )
//@NamedQueries ( {
//  @NamedQuery ( name="Tbdlohangpl6.countAll", query="SELECT COUNT(x) FROM Tbdlohangpl6 x" )
//} )
public class Tbdlohangpl6 implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Id
//    @Column(name="FI_ID_LOHANG", nullable=false)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDLOHANGPL6_SEQ")
//    @SequenceGenerator(sequenceName = "TBDLOHANGPL6_SEQ", schema = "MONRE", initialValue = 1, allocationSize = 1, name = "TBDLOHANGPL6_SEQ")
    private Long fiIdLohang;

//    @Column(name="FI_LH_TEN", length=250)
    private String fiLhTen;

//    @Column(name="FI_LH_KLUONG")
    private Long fiLhKluong;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="FI_LH_TGIAN")
    private Date fiLhTgian;

//    @Column(name="FI_LH_TEN_CK", length=250)
    private String fiLhTenCuakhau;

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

//    @Column(name="FI_ID_HOSO")
    private Long fiIdHoso;

//    @Column(name="FI_ID_LOAI_PL")
    private Long fiIdLoaiPl;
    
    private String  fiLhMaCuakhau  ;

    public Tbdlohangpl6() {
        super();
    }

    public void setFiIdLohang(Long fiIdLohang) {
        this.fiIdLohang = fiIdLohang;
    }

    public Long getFiIdLohang() {
        return this.fiIdLohang;
    }

    public void setFiLhTen(String fiLhTen) {
        this.fiLhTen = fiLhTen;
    }

    public String getFiLhTen() {
        return this.fiLhTen;
    }

    public void setFiLhKluong(Long fiLhKluong) {
        this.fiLhKluong = fiLhKluong;
    }

    public Long getFiLhKluong() {
        return this.fiLhKluong;
    }

    public void setFiLhTgian(Date fiLhTgian) {
        this.fiLhTgian = fiLhTgian;
    }

    public Date getFiLhTgian() {
        return this.fiLhTgian;
    }

    public String getFiLhTenCuakhau() {
        return fiLhTenCuakhau;
    }

    public void setFiLhTenCuakhau(String fiLhTenCuakhau) {
        this.fiLhTenCuakhau = fiLhTenCuakhau;
    }

    public String getFiLhMaCuakhau() {
        return fiLhMaCuakhau;
    }

    public void setFiLhMaCuakhau(String fiLhMaCuakhau) {
        this.fiLhMaCuakhau = fiLhMaCuakhau;
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

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    public void setFiIdLoaiPl(Long fiIdLoaiPl) {
        this.fiIdLoaiPl = fiIdLoaiPl;
    }

    public Long getFiIdLoaiPl() {
        return this.fiIdLoaiPl;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(fiIdLohang);
        sb.append("]:");
        sb.append(fiLhTen);
        sb.append("|");
        sb.append(fiLhKluong);
        sb.append("|");
        sb.append(fiLhTgian);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNguoitao);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiNgCapnhat);
        sb.append("|");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiIdLoaiPl);
        return sb.toString();
    }

}
