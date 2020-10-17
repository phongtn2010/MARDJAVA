/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p11.message.send;

import com.vnsw.ws.p11.entity.db.Tbddinhkem11;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhytosanitaryFeeRequest")
public class PhytosanitaryFeeRequest {

    @XmlElement(name = "NSWFileCode")
    private String fiMaHoso;

    @XmlElement(name = "TotalFee")
    private BigDecimal fiSotienTt;

    @XmlElement(name = "Note")
    private String fiGhichu;

    @XmlElement(name = "Attachment")
    private Tbddinhkem11 attachment;

    public PhytosanitaryFeeRequest() {
    }

    public PhytosanitaryFeeRequest(String fiMaHoso, BigDecimal fiSotienTt, String fiGhichu, Tbddinhkem11 attachment) {
        this.fiMaHoso = fiMaHoso;
        this.fiSotienTt = fiSotienTt;
        this.fiGhichu = fiGhichu;
        this.attachment = attachment;
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

    public Tbddinhkem11 getAttachment() {
        return attachment;
    }

    public void setAttachment(Tbddinhkem11 attachment) {
        this.attachment = attachment;
    }

}
