/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p02.model;

import com.nsw.mt.p61.model.BaseMessage;

import java.util.Date;

/**
 * @author Fujitsu
 */

public class SendMessage extends BaseMessage {

    private String reason;
    private Date delayDateTo;
    private String getXmlNotSend;
    private String signedXml;
    private String fiSoGp;
    private Long idGP;
    private String soGp;
    private Date requestDate;
    private TbdRegistration02 tbdRegistration02;
    private TbdQuarantineCer02 tbdQuarantineCer02;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getDelayDateTo() {
        return delayDateTo;
    }

    public void setDelayDateTo(Date delayDateTo) {
        this.delayDateTo = delayDateTo;
    }

    public String getGetXmlNotSend() {
        return getXmlNotSend;
    }

    public void setGetXmlNotSend(String getXmlNotSend) {
        this.getXmlNotSend = getXmlNotSend;
    }

    public String getSignedXml() {
        return signedXml;
    }

    public void setSignedXml(String signedXml) {
        this.signedXml = signedXml;
    }

    public String getFiSoGp() {
        return fiSoGp;
    }

    public void setFiSoGp(String fiSoGp) {
        this.fiSoGp = fiSoGp;
    }

    public Long getIdGP() {
        return idGP;
    }

    public void setIdGP(Long idGP) {
        this.idGP = idGP;
    }


    public String getSoGp() {
        return soGp;
    }

    public void setSoGp(String soGp) {
        this.soGp = soGp;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public TbdRegistration02 getTbdRegistration02() {
        return tbdRegistration02;
    }

    public void setTbdRegistration02(TbdRegistration02 tbdRegistration02) {
        this.tbdRegistration02 = tbdRegistration02;
    }

    public TbdQuarantineCer02 getTbdQuarantineCer02() {
        return tbdQuarantineCer02;
    }

    public void setTbdQuarantineCer02(TbdQuarantineCer02 tbdQuarantineCer02) {
        this.tbdQuarantineCer02 = tbdQuarantineCer02;
    }
}
