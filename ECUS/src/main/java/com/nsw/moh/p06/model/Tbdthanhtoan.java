/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p06.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nsw.annotations.*;
import com.nsw.util.CustomJsonDateDeserializer;
import java.util.Date;

/**
 *
 * @author Nhan
 */
public class Tbdthanhtoan {

    private Long fiId;
    @Mandatory
    @FieldName(name="fiNgaynop")
    private Date fiNgaynop;
    @Mandatory
    @FieldName(name="fiNguoinop")
    @Maxlength(maxLength = 250)  
    //@FilterXSS
    private String fiNguoinop;
    @Mandatory
    @FieldName(name="fiSdt")
    @Maxlength(maxLength = 50) 
    //@FilterXSS
    private String fiSdt;
    @Mandatory
    @FieldName(name="fiSohoadon")
    @Maxlength(maxLength = 50)  
    //@FilterXSS
    private String fiSohoadon;
    @Mandatory
    @FieldName(name="fiTongtien")
    private String fiTongtien;
    @Mandatory
    @FieldName(name="fiLoaiphi")
    private Long fiLoaiphi;
    @FieldName(name="fiGhichu")
    //@FilterXSS
    private String fiGhichu;
    private Tbdtaptin dinhKem;
    private Long fiHosoid;

    public Tbdthanhtoan() {
    }

    public Tbdthanhtoan(Long fiId, Date fiNgaynop, String fiNguoinop, String fiSdt, String fiSohoadon, String fiTongtien, Long fiLoaiphi, String fiGhichu, Tbdtaptin dinhKem, Long fiHosoid) {
        this.fiId = fiId;
        this.fiNgaynop = fiNgaynop;
        this.fiNguoinop = fiNguoinop;
        this.fiSdt = fiSdt;
        this.fiSohoadon = fiSohoadon;
        this.fiTongtien = fiTongtien;
        this.fiLoaiphi = fiLoaiphi;
        this.fiGhichu = fiGhichu;
        this.dinhKem = dinhKem;
        this.fiHosoid = fiHosoid;
    }

    public Tbdtaptin getDinhKem() {
        return dinhKem;
    }

    public void setDinhKem(Tbdtaptin dinhKem) {
        this.dinhKem = dinhKem;
    }

    public Long getFiHosoid() {
        return fiHosoid;
    }

    public void setFiHosoid(Long fiHosoid) {
        this.fiHosoid = fiHosoid;
    }

    public Long getFiId() {
        return fiId;
    }

    public void setFiId(Long fiId) {
        this.fiId = fiId;
    }

    public Date getFiNgaynop() {
        return fiNgaynop;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setFiNgaynop(Date fiNgaynop) {
        this.fiNgaynop = fiNgaynop;
    }

    public String getFiNguoinop() {
        return fiNguoinop;
    }

    public void setFiNguoinop(String fiNguoinop) {
        this.fiNguoinop = fiNguoinop;
    }

    public String getFiSdt() {
        return fiSdt;
    }

    public void setFiSdt(String fiSdt) {
        this.fiSdt = fiSdt;
    }

    public String getFiSohoadon() {
        return fiSohoadon;
    }

    public void setFiSohoadon(String fiSohoadon) {
        this.fiSohoadon = fiSohoadon;
    }

    public String getFiTongtien() {
        return fiTongtien;
    }

    public void setFiTongtien(String fiTongtien) {
        this.fiTongtien = fiTongtien;
    }

    public Long getFiLoaiphi() {
        return fiLoaiphi;
    }

    public void setFiLoaiphi(Long fiLoaiphi) {
        this.fiLoaiphi = fiLoaiphi;
    }

    public String getFiGhichu() {
        return fiGhichu;
    }

    public void setFiGhichu(String fiGhichu) {
        this.fiGhichu = fiGhichu;
    }

}
