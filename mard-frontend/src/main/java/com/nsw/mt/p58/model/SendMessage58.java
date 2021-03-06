package com.nsw.mt.p58.model;

import java.util.Date;

public class SendMessage58 extends BaseMessage {

    private String reason;// Content của lý do
    private Date delayDateTo;// Hạn mới
    private String getXmlNotSend;// Trả về bản tin để ký, không gửi đi
    private String signedXml;
    private String fiMaThutuc;
    private String fiSoVb;

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

    public String getFiMaThutuc() {
        return fiMaThutuc;
    }

    public void setFiMaThutuc(String fiMaThutuc) {
        this.fiMaThutuc = fiMaThutuc;
    }

    public String getFiSoVb() {
        return fiSoVb;
    }

    public void setFiSoVb(String fiSoVb) {
        this.fiSoVb = fiSoVb;
    }
}
