/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p03.model;

import java.util.Date;

/**
 * @author HuongMK
 */

public class SendMessage03 extends BaseMessage {

    private Date delayDateTo;
    private String getXmlNotSend;
    private String signedXml;
    private Date requestDate;
    private String reason;
    private TbdHoso03 tbdHoso03;

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

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public TbdHoso03 getTbdHoso03() {
        return tbdHoso03;
    }

    public void setTbdHoso03(TbdHoso03 tbdHoso03) {
        this.tbdHoso03 = tbdHoso03;
    }
}
