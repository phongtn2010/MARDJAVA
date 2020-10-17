/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p11.model;

import java.math.BigDecimal;
import java.util.Date;

public class FeeMessage {
    private String type;
    private String function;
    private String fiMaHoso;
    private Long fiIdHoso;
    private BigDecimal fiSotienTt;
    private String fiGhichu;
    private Date fiNgaynop;
    private Tbddinhkem11 attachment;
    private String fiNguoinop;
    private String signedXml;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getSignedXml() {
        return signedXml;
    }

    public void setSignedXml(String signedXml) {
        this.signedXml = signedXml;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public BigDecimal getFiSotienTt() {
        return fiSotienTt;
    }

    public void setFiSotienTt(BigDecimal fiSotienTt) {
        this.fiSotienTt = fiSotienTt;
    }

    public String getFiGhichu() {
        return fiGhichu;
    }

    public void setFiGhichu(String fiGhichu) {
        this.fiGhichu = fiGhichu;
    }

    public Date getFiNgaynop() {
        return fiNgaynop;
    }

    public void setFiNgaynop(Date fiNgaynop) {
        this.fiNgaynop = fiNgaynop;
    }

    public Tbddinhkem11 getAttachment() {
        return attachment;
    }

    public void setAttachment(Tbddinhkem11 attachment) {
        this.attachment = attachment;
    }

    public String getFiNguoinop() {
        return fiNguoinop;
    }

    public void setFiNguoinop(String fiNguoinop) {
        this.fiNguoinop = fiNguoinop;
    }

    public FeeMessage() {
    }

    public FeeMessage(String fiMaHoso, BigDecimal fiSotienTt, String fiGhichu, Date fiNgaynop, Tbddinhkem11 attachment) {
        this.fiMaHoso = fiMaHoso;
        this.fiSotienTt = fiSotienTt;
        this.fiGhichu = fiGhichu;
        this.fiNgaynop = fiNgaynop;
        this.attachment = attachment;
    }    
}
