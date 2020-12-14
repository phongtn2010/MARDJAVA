package com.nsw.monre.p06.model;

import java.io.Serializable;
import java.util.Date;

//@Entity
//@Table(name="TBDKQXL6", schema="MONRE" )
//@NamedQueries ( {
//  @NamedQuery ( name="Tbdkqxl6.countAll", query="SELECT COUNT(x) FROM Tbdkqxl6 x" )
//} )
public class Tbdkqxl6 implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Id
//    @Column(name="FI_ID_KQXL", nullable=false)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDKQXL6_SEQ")
//    @SequenceGenerator(sequenceName = "TBDKQXL6_SEQ", schema = "MONRE", initialValue = 1, allocationSize = 1, name = "TBDKQXL6_SEQ")
    private Long fiIdKqxl     ;
    
//    @Column(name="FI_ID_HOSO")
    private Long fiIdHoso     ;

//    @Column(name="FI_MA_HOSO", length=50)
    private String     fiMaHoso     ;

//    @Column(name="FI_NOIDUNG", length=2000)
    private String     fiNoidung    ;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="FI_NGAY_XL")
    private Date       fiNgayXl     ;

//    @Column(name="FI_DONVI_XL", length=250)
    private String     fiDonviXl    ;

//    @Column(name="FI_LINK_CVAN", length=2000)
    private String     fiLinkCvan   ;

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

    public Tbdkqxl6() {
		super();
    }
    
    public void setFiIdKqxl( Long fiIdKqxl ) {
        this.fiIdKqxl = fiIdKqxl ;
    }
    public Long getFiIdKqxl() {
        return this.fiIdKqxl;
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

    public void setFiNoidung( String fiNoidung ) {
        this.fiNoidung = fiNoidung;
    }
    public String getFiNoidung() {
        return this.fiNoidung;
    }

    public void setFiNgayXl( Date fiNgayXl ) {
        this.fiNgayXl = fiNgayXl;
    }
    public Date getFiNgayXl() {
        return this.fiNgayXl;
    }

    public void setFiDonviXl( String fiDonviXl ) {
        this.fiDonviXl = fiDonviXl;
    }
    public String getFiDonviXl() {
        return this.fiDonviXl;
    }

    public void setFiLinkCvan( String fiLinkCvan ) {
        this.fiLinkCvan = fiLinkCvan;
    }
    public String getFiLinkCvan() {
        return this.fiLinkCvan;
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

    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(fiIdKqxl);
        sb.append("]:"); 
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiNoidung);
        sb.append("|");
        sb.append(fiNgayXl);
        sb.append("|");
        sb.append(fiDonviXl);
        sb.append("|");
        sb.append(fiLinkCvan);
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
