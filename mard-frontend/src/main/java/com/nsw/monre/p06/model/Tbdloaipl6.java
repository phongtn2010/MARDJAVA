package com.nsw.monre.p06.model;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

//import javax.persistence.*;
//
//@Entity
//@Table(name="TBDLOAIPL6", schema="MONRE" )
//@NamedQueries ( {
//  @NamedQuery ( name="Tbdloaipl6.countAll", query="SELECT COUNT(x) FROM Tbdloaipl6 x" )
//} )
public class Tbdloaipl6 implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Id
//    @Column(name="FI_ID_LOAI_PL", nullable=false)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDLOAIPL6_SEQ")
//    @SequenceGenerator(sequenceName = "TBDLOAIPL6_SEQ", schema = "MONRE", initialValue = 1, allocationSize = 1, name = "TBDLOAIPL6_SEQ")
    private Long fiIdLoaiPl;

//    @Column(name="FI_TENLOAI_PL", length=250)
    private String fiTenloaiPl;

//    @Column(name="FI_MA_HS", length=250)
    private String fiMaHs;

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
    
    //@Column(name="FI_IDPL")
    private Long     fiIdpl   ;

//    @Transient
    private List<Tbdlohangpl6> lstLohangPheLieu;

    public Tbdloaipl6() {
        super();
    }

    public void setFiIdLoaiPl(Long fiIdLoaiPl) {
        this.fiIdLoaiPl = fiIdLoaiPl;
    }

    public Long getFiIdLoaiPl() {
        return this.fiIdLoaiPl;
    }

    public void setFiTenloaiPl(String fiTenloaiPl) {
        this.fiTenloaiPl = fiTenloaiPl;
    }

    public String getFiTenloaiPl() {
        return this.fiTenloaiPl;
    }

    public void setFiMaHs(String fiMaHs) {
        this.fiMaHs = fiMaHs;
    }

    public String getFiMaHs() {
        return this.fiMaHs;
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
    
    public Long getFiIdpl() {
        return fiIdpl;
    }

    public void setFiIdpl(Long fiIdpl) {
        this.fiIdpl = fiIdpl;
    }

    public List<Tbdlohangpl6> getLstLohangPheLieu() {
        return lstLohangPheLieu;
    }

    public void setLstLohangPheLieu(List<Tbdlohangpl6> lstLohangPheLieu) {
        this.lstLohangPheLieu = lstLohangPheLieu;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(fiIdLoaiPl);
        sb.append("]:");
        sb.append(fiTenloaiPl);
        sb.append("|");
        sb.append(fiMaHs);
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
        return sb.toString();
    }

}
