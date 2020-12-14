package com.nsw.monre.p06.model;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

public class Tbdcaptbnk6 implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Id
//    @Column(name="FI_ID_CAPTBNK", nullable=false)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDCAPTBNK6_SEQ")
//    @SequenceGenerator(sequenceName = "TBDCAPTBNK6_SEQ", schema = "MONRE", initialValue = 1, allocationSize = 1, name = "TBDCAPTBNK6_SEQ")
    private Long fiIdCaptbnk  ;

//    @Column(name="FI_ID_HOSO")
    private Long fiIdHoso     ;

//    @Column(name="FI_MA_HOSO", length=50)
    private String     fiMaHoso     ;

//    @Column(name="FI_TEN_CQ_CAP", length=250)
    private String     fiTenCqCap   ;

//    @Column(name="FI_SO_TB", length=100)
    private String     fiSoTb       ;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="FI_NGAY_KY")
    private Date       fiNgayKy     ;

//    @Column(name="FI_NGUOI_KY", length=250)
    private String     fiNguoiKy    ;

//    @Column(name="FI_HOATDONG")
    private Long fiHoatdong   ;

//    @Column(name="FI_NGUOITAO", length=50)
    private String     fiNguoitao   ;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="FI_NGAYTAO")
    private Date       fiNgaytao    ;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="FI_NG_CAPNHAT")
    private Date       fiNgCapnhat  ;

//    @Transient
    private List<Tbdlohangnk6> lstLohangNk;
    
//    @Transient
    private Tbddinhkem6 dinhkem;
    
    public Tbdcaptbnk6() {
		super();
    }
    
    public void setFiIdCaptbnk( Long fiIdCaptbnk ) {
        this.fiIdCaptbnk = fiIdCaptbnk ;
    }
    public Long getFiIdCaptbnk() {
        return this.fiIdCaptbnk;
    }

    public void setFiIdHoso( Long fiIdHoso ) {
        this.fiIdHoso = fiIdHoso;
    }
    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    public void setFiMaHoso( String fiMaHoso ) {
        this.fiMaHoso = fiMaHoso;
    }
    public String getFiMaHoso() {
        return this.fiMaHoso;
    }

    public void setFiTenCqCap( String fiTenCqCap ) {
        this.fiTenCqCap = fiTenCqCap;
    }
    public String getFiTenCqCap() {
        return this.fiTenCqCap;
    }

    public void setFiSoTb( String fiSoTb ) {
        this.fiSoTb = fiSoTb;
    }
    public String getFiSoTb() {
        return this.fiSoTb;
    }

    public void setFiNgayKy( Date fiNgayKy ) {
        this.fiNgayKy = fiNgayKy;
    }
    public Date getFiNgayKy() {
        return this.fiNgayKy;
    }

    public void setFiNguoiKy( String fiNguoiKy ) {
        this.fiNguoiKy = fiNguoiKy;
    }
    public String getFiNguoiKy() {
        return this.fiNguoiKy;
    }

    public void setFiHoatdong( Long fiHoatdong ) {
        this.fiHoatdong = fiHoatdong;
    }
    public Long getFiHoatdong() {
        return this.fiHoatdong;
    }

    public void setFiNguoitao( String fiNguoitao ) {
        this.fiNguoitao = fiNguoitao;
    }
    public String getFiNguoitao() {
        return this.fiNguoitao;
    }

    public void setFiNgaytao( Date fiNgaytao ) {
        this.fiNgaytao = fiNgaytao;
    }
    public Date getFiNgaytao() {
        return this.fiNgaytao;
    }

    public void setFiNgCapnhat( Date fiNgCapnhat ) {
        this.fiNgCapnhat = fiNgCapnhat;
    }
    public Date getFiNgCapnhat() {
        return this.fiNgCapnhat;
    }

    public List<Tbdlohangnk6> getLstLohangNk() {
        return lstLohangNk;
    }

    public void setLstLohangNk(List<Tbdlohangnk6> lstLohangNk) {
        this.lstLohangNk = lstLohangNk;
    }

    public Tbddinhkem6 getDinhkem() {
        return dinhkem;
    }

    public void setDinhkem(Tbddinhkem6 dinhkem) {
        this.dinhkem = dinhkem;
    }
    
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(fiIdCaptbnk);
        sb.append("]:"); 
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiTenCqCap);
        sb.append("|");
        sb.append(fiSoTb);
        sb.append("|");
        sb.append(fiNgayKy);
        sb.append("|");
        sb.append(fiNguoiKy);
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
