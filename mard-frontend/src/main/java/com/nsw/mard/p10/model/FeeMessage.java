/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p10.model;

import java.math.BigDecimal;
import java.util.Date;

public class FeeMessage {
    private String type;
    private String function;
    private String fiMaHoso;
    private Long fiIdHoso;// Id hồ sơ
    private BigDecimal fiSotienCk;
    private String fiNdSotien;
    private String fiChuthich;
    private String fiNguoinop;
    private Date fiNgaynop;
    private String fiSohoadon;
    private Tbddinhkem10 attachment;
    private String signedXml;//

    private String fiNguoitao;

    public String getFiNguoitao() {
        return fiNguoitao;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

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

    
    
    public FeeMessage() {
    }

    public FeeMessage(String fiMaHoso, BigDecimal fiSotienCk, String fiNdSotien, String fiChuthich, String fiNguoinop, Date fiNgaynop, String fiSohoadon, Tbddinhkem10 attachment) {
        this.fiMaHoso = fiMaHoso;
        this.fiSotienCk = fiSotienCk;
        this.fiNdSotien = fiNdSotien;
        this.fiChuthich = fiChuthich;
        this.fiNguoinop = fiNguoinop;
        this.fiNgaynop = fiNgaynop;
        this.fiSohoadon = fiSohoadon;
        this.attachment = attachment;
    }
    
    

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public BigDecimal getFiSotienCk() {
        return fiSotienCk;
    }

    public void setFiSotienCk(BigDecimal fiSotienCk) {
        this.fiSotienCk = fiSotienCk;
    }

    public String getFiNdSotien() {
        return fiNdSotien;
    }

    public void setFiNdSotien(String fiNdSotien) {
        this.fiNdSotien = fiNdSotien;
    }

    public String getFiChuthich() {
        return fiChuthich;
    }

    public void setFiChuthich(String fiChuthich) {
        this.fiChuthich = fiChuthich;
    }

    public String getFiNguoinop() {
        return fiNguoinop;
    }

    public void setFiNguoinop(String fiNguoinop) {
        this.fiNguoinop = fiNguoinop;
    }

    public Date getFiNgaynop() {
        return fiNgaynop;
    }

    public void setFiNgaynop(Date fiNgaynop) {
        this.fiNgaynop = fiNgaynop;
    }

    public String getFiSohoadon() {
        return fiSohoadon;
    }

    public void setFiSohoadon(String fiSohoadon) {
        this.fiSohoadon = fiSohoadon;
    }

    public Tbddinhkem10 getAttachment() {
        return attachment;
    }

    public void setAttachment(Tbddinhkem10 attachment) {
        this.attachment = attachment;
    }
    
    
    
    
}
