package com.nsw.monre.p07.model;

import java.io.Serializable;

import java.util.Date;
import java.util.List;


public class Tbdhoso7 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdHoso     ;


    private String     fiMaHoso     ;

    private String     fiMaCqCap    ;

    private String     fiTenCqCap   ;

    private String     fiMstDn      ;

    private String     fiTenDn      ;

    private String     fiSoDkkd     ;

    private Date       fiNgaycapDkkd ;

    private String     fiNoicapDkkd ;

    private String     fiDiachiTsc  ;

    private Date       fiNgaycapGxn ;

    private String     fiCqCapGxn   ;

    private Date       fiNgaygui    ;

    private String     fiSoVbCt     ;

    private Date       fiNgaycapVb  ;

    private Long fiHoatdong   ;

    private String     fiNguoitao   ;

    private Date       fiNgaytao    ;

    private Date       fiNgCapnhat  ;

    private Long fiTrangthai  ;

    private String     fiTenTt      ;

    private List<Tbdcososx7> lstCosoSx;
    
    private List<Tbdphelieu7> lstPheLieu;
    
    private List<Tbddinhkem7> lstDinhKem;

    private String     fiSdtDn  ;
    
    private String     fiFaxDn  ;
    
    private String     fiEmailDn  ;
    
    private String     fiSoGxn  ;
    
    public Tbdhoso7() {
		super();
    }
    
    public String getFiSdtDn() {
        return fiSdtDn;
    }

    public void setFiSdtDn(String fiSdtDn) {
        this.fiSdtDn = fiSdtDn;
    }

    public String getFiFaxDn() {
        return fiFaxDn;
    }

    public void setFiFaxDn(String fiFaxDn) {
        this.fiFaxDn = fiFaxDn;
    }

    public String getFiEmailDn() {
        return fiEmailDn;
    }

    public void setFiEmailDn(String fiEmailDn) {
        this.fiEmailDn = fiEmailDn;
    }

    public String getFiSoGxn() {
        return fiSoGxn;
    }

    public void setFiSoGxn(String fiSoGxn) {
        this.fiSoGxn = fiSoGxn;
    }
    
    public void setFiIdHoso( Long fiIdHoso ) {
        this.fiIdHoso = fiIdHoso ;
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

    public void setFiMaCqCap( String fiMaCqCap ) {
        this.fiMaCqCap = fiMaCqCap;
    }
    public String getFiMaCqCap() {
        return this.fiMaCqCap;
    }

    public void setFiTenCqCap( String fiTenCqCap ) {
        this.fiTenCqCap = fiTenCqCap;
    }
    public String getFiTenCqCap() {
        return this.fiTenCqCap;
    }

    public void setFiMstDn( String fiMstDn ) {
        this.fiMstDn = fiMstDn;
    }
    public String getFiMstDn() {
        return this.fiMstDn;
    }

    public void setFiTenDn( String fiTenDn ) {
        this.fiTenDn = fiTenDn;
    }
    public String getFiTenDn() {
        return this.fiTenDn;
    }

    public void setFiSoDkkd( String fiSoDkkd ) {
        this.fiSoDkkd = fiSoDkkd;
    }
    public String getFiSoDkkd() {
        return this.fiSoDkkd;
    }

    public void setFiNgaycapDkkd( Date fiNgaycapDkkd ) {
        this.fiNgaycapDkkd = fiNgaycapDkkd;
    }
    public Date getFiNgaycapDkkd() {
        return this.fiNgaycapDkkd;
    }

    public void setFiNoicapDkkd( String fiNoicapDkkd ) {
        this.fiNoicapDkkd = fiNoicapDkkd;
    }
    public String getFiNoicapDkkd() {
        return this.fiNoicapDkkd;
    }

    public void setFiDiachiTsc( String fiDiachiTsc ) {
        this.fiDiachiTsc = fiDiachiTsc;
    }
    public String getFiDiachiTsc() {
        return this.fiDiachiTsc;
    }

    public void setFiNgaycapGxn( Date fiNgaycapGxn ) {
        this.fiNgaycapGxn = fiNgaycapGxn;
    }
    public Date getFiNgaycapGxn() {
        return this.fiNgaycapGxn;
    }

    public void setFiCqCapGxn( String fiCqCapGxn ) {
        this.fiCqCapGxn = fiCqCapGxn;
    }
    public String getFiCqCapGxn() {
        return this.fiCqCapGxn;
    }

    public void setFiNgaygui( Date fiNgaygui ) {
        this.fiNgaygui = fiNgaygui;
    }
    public Date getFiNgaygui() {
        return this.fiNgaygui;
    }

    public void setFiSoVbCt( String fiSoVbCt ) {
        this.fiSoVbCt = fiSoVbCt;
    }
    public String getFiSoVbCt() {
        return this.fiSoVbCt;
    }

    public void setFiNgaycapVb( Date fiNgaycapVb ) {
        this.fiNgaycapVb = fiNgaycapVb;
    }
    public Date getFiNgaycapVb() {
        return this.fiNgaycapVb;
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

    public void setFiTrangthai( Long fiTrangthai ) {
        this.fiTrangthai = fiTrangthai;
    }
    public Long getFiTrangthai() {
        return this.fiTrangthai;
    }

    public void setFiTenTt( String fiTenTt ) {
        this.fiTenTt = fiTenTt;
    }
    public String getFiTenTt() {
        return this.fiTenTt;
    }

    public List<Tbdcososx7> getLstCosoSx() {
        return lstCosoSx;
    }

    public void setLstCosoSx(List<Tbdcososx7> lstCosoSx) {
        this.lstCosoSx = lstCosoSx;
    }

    public List<Tbdphelieu7> getLstPheLieu() {
        return lstPheLieu;
    }

    public void setLstPheLieu(List<Tbdphelieu7> lstPheLieu) {
        this.lstPheLieu = lstPheLieu;
    }

    public List<Tbddinhkem7> getLstDinhKem() {
        return lstDinhKem;
    }

    public void setLstDinhKem(List<Tbddinhkem7> lstDinhKem) {
        this.lstDinhKem = lstDinhKem;
    }
    
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(fiIdHoso);
        sb.append("]:"); 
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiMaCqCap);
        sb.append("|");
        sb.append(fiTenCqCap);
        sb.append("|");
        sb.append(fiMstDn);
        sb.append("|");
        sb.append(fiTenDn);
        sb.append("|");
        sb.append(fiSoDkkd);
        sb.append("|");
        sb.append(fiNgaycapDkkd);
        sb.append("|");
        sb.append(fiNoicapDkkd);
        sb.append("|");
        sb.append(fiDiachiTsc);
        sb.append("|");
        sb.append(fiNgaycapGxn);
        sb.append("|");
        sb.append(fiCqCapGxn);
        sb.append("|");
        sb.append(fiNgaygui);
        sb.append("|");
        sb.append(fiSoVbCt);
        sb.append("|");
        sb.append(fiNgaycapVb);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNguoitao);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiNgCapnhat);
        sb.append("|");
        sb.append(fiTrangthai);
        sb.append("|");
        sb.append(fiTenTt);
        return sb.toString(); 
    } 

}
