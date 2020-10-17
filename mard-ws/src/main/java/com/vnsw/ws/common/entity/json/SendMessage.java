package com.vnsw.ws.common.entity.json;

import com.vnsw.ws.p04.message.send.TbdRegistrationProfile04;
import com.vnsw.ws.p04.message.send.TbdThongbaoThanhtoan;
import java.util.Date;

public class SendMessage {

    private String type;
    private String function;
    private Long fiIdHoso;// Id hồ sơ
    private Long fiIdCqxl; //Id co quan xu ly
    private String reason;// Content của lý do
    private Date delayDateTo;// Hạn mới
    private String getXmlNotSend;// Trả về bản tin để ký, không gửi đi
    private String signedXml;//
    private Long idGP;
    private String soGp;
    private String fiMaHoso;
    private Date requestDate;
    private TbdRegistrationProfile04 tbdRegistrationProfile04;
    private TbdThongbaoThanhtoan tbdThongbaoThanhtoan;

    public String getFunction() {
        return function;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getFiIdCqxl() {
        return fiIdCqxl;
    }

    public void setFiIdCqxl(Long fiIdCqxl) {
        this.fiIdCqxl = fiIdCqxl;
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

    public TbdRegistrationProfile04 getTbdRegistrationProfile04() {
        return tbdRegistrationProfile04;
    }

    public void setTbdRegistrationProfile04(TbdRegistrationProfile04 tbdRegistrationProfile04) {
        this.tbdRegistrationProfile04 = tbdRegistrationProfile04;
    }

    public TbdThongbaoThanhtoan getTbdThongbaoThanhtoan() {
        return tbdThongbaoThanhtoan;
    }

    public void setTbdThongbaoThanhtoan(TbdThongbaoThanhtoan tbdThongbaoThanhtoan) {
        this.tbdThongbaoThanhtoan = tbdThongbaoThanhtoan;
    }
    
}
