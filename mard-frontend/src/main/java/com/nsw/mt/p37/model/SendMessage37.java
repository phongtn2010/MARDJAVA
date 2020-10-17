package com.nsw.mt.p37.model;

import java.util.Date;

public class SendMessage37 extends BaseMessage {

    private String reason;// Content của lý do
    private Date delayDateTo;// Hạn mới
    private String getXmlNotSend;// Trả về bản tin để ký, không gửi đi
    private String signedXml;
    private String fiSoGp;

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
    
}
