/*
 * Created on 18 Jul 2017 ( Time 08:46:13 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.vnsw.ws.p10.entity.db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Tbdhanghoa9a implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long fiIdHanghoa;
    private Long fiId9a;
    private Long fiStt;
    private String fiTenhang;
    private BigDecimal fiSoluong;
    private String fiMaSl;
    private String fiTenSl;
    private Long fiHoatdong;
    private Date fiNgaytao;
    private Date fiNgayCn;
    private BigDecimal fiKhoiluong;
    
    public Tbdhanghoa9a() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdHanghoa(Long fiIdHanghoa) {
        this.fiIdHanghoa = fiIdHanghoa;
    }

    public Long getFiIdHanghoa() {
        return this.fiIdHanghoa;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FI_ID_9A ( NUMBER ) 
    public void setFiId9a(Long fiId9a) {
        this.fiId9a = fiId9a;
    }

    public Long getFiId9a() {
        return this.fiId9a;
    }

    //--- DATABASE MAPPING : FI_STT ( NUMBER ) 
    public void setFiStt(Long fiStt) {
        this.fiStt = fiStt;
    }

    public Long getFiStt() {
        return this.fiStt;
    }

    //--- DATABASE MAPPING : FI_TENHANG ( VARCHAR2 ) 
    public void setFiTenhang(String fiTenhang) {
        this.fiTenhang = fiTenhang;
    }

    public String getFiTenhang() {
        return this.fiTenhang;
    }

    //--- DATABASE MAPPING : FI_SOLUONG ( NUMBER ) 
    public void setFiSoluong(BigDecimal fiSoluong) {
        this.fiSoluong = fiSoluong;
    }

    public BigDecimal getFiSoluong() {
        return this.fiSoluong;
    }

    //--- DATABASE MAPPING : FI_MA_SL ( VARCHAR2 ) 
    public void setFiMaSl(String fiMaSl) {
        this.fiMaSl = fiMaSl;
    }

    public String getFiMaSl() {
        return this.fiMaSl;
    }

    //--- DATABASE MAPPING : FI_TEN_SL ( VARCHAR2 ) 
    public void setFiTenSl(String fiTenSl) {
        this.fiTenSl = fiTenSl;
    }

    public String getFiTenSl() {
        return this.fiTenSl;
    }

    //--- DATABASE MAPPING : FI_HOATDONG ( NUMBER ) 
    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiHoatdong() {
        return this.fiHoatdong;
    }

    //--- DATABASE MAPPING : FI_NGAYTAO ( DATE ) 
    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaytao() {
        return this.fiNgaytao;
    }

    //--- DATABASE MAPPING : FI_NGAY_CN ( DATE ) 
    public void setFiNgayCn(Date fiNgayCn) {
        this.fiNgayCn = fiNgayCn;
    }

    public Date getFiNgayCn() {
        return this.fiNgayCn;
    }

    //--- DATABASE MAPPING : FI_KHOILUONG ( NUMBER ) 
    public void setFiKhoiluong(BigDecimal fiKhoiluong) {
        this.fiKhoiluong = fiKhoiluong;
    }

    public BigDecimal getFiKhoiluong() {
        return this.fiKhoiluong;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(fiIdHanghoa);
        sb.append("]:");
        sb.append(fiId9a);
        sb.append("|");
        sb.append(fiStt);
        sb.append("|");
        sb.append(fiTenhang);
        sb.append("|");
        sb.append(fiSoluong);
        sb.append("|");
        sb.append(fiMaSl);
        sb.append("|");
        sb.append(fiTenSl);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiNgayCn);
        sb.append("|");
        sb.append(fiKhoiluong);
        return sb.toString();
    }

}
