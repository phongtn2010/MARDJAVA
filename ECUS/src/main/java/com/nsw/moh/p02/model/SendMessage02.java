/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p02.model;

import java.util.Date;

/**
 * @author HuongMK
 */

public class SendMessage02 extends BaseMessage {

    private Date delayDateTo;
    private String getXmlNotSend;
    private String signedXml;
    private Date requestDate;
    private String reason;
    private TbdHoso02 tbdHoso02;

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

    public TbdHoso02 getTbdHoso02() {
        return tbdHoso02;
    }

    public void setTbdHoso02(TbdHoso02 tbdHoso02) {
        this.tbdHoso02 = tbdHoso02;
    }
}
