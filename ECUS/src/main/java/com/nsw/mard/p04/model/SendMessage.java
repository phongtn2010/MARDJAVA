package com.nsw.mard.p04.model;

import java.util.Date;
import java.util.List;

public class SendMessage extends BaseMessage {
    private String reason;
    private Date delayDateTo;
    private String getXmlNotSend;
    private String signedXml;
    private String fiSoGp;
    private Long idGP;
    private String soGp;
    private Date requestDate;
    private TbdHoso04 tbdHoso04;
    private List<TbdDinhkemXinGh04> lstDinhkemGh;
    private String fiMaLoaiKiemtra;

    public String getReason() {
        return this.reason;
    }

    public void setReason(final String reason) {
        this.reason = reason;
    }

    public Date getDelayDateTo() {
        return this.delayDateTo;
    }

    public void setDelayDateTo(final Date delayDateTo) {
        this.delayDateTo = delayDateTo;
    }

    public String getGetXmlNotSend() {
        return this.getXmlNotSend;
    }

    public void setGetXmlNotSend(final String getXmlNotSend) {
        this.getXmlNotSend = getXmlNotSend;
    }

    public String getSignedXml() {
        return this.signedXml;
    }

    public void setSignedXml(final String signedXml) {
        this.signedXml = signedXml;
    }

    public String getFiSoGp() {
        return this.fiSoGp;
    }

    public void setFiSoGp(final String fiSoGp) {
        this.fiSoGp = fiSoGp;
    }

    public Long getIdGP() {
        return this.idGP;
    }

    public void setIdGP(final Long idGP) {
        this.idGP = idGP;
    }

    public String getSoGp() {
        return this.soGp;
    }

    public void setSoGp(final String soGp) {
        this.soGp = soGp;
    }

    public Date getRequestDate() {
        return this.requestDate;
    }

    public void setRequestDate(final Date requestDate) {
        this.requestDate = requestDate;
    }

    public TbdHoso04 getTbdHoso04() {
        return this.tbdHoso04;
    }

    public void setTbdHoso04(final TbdHoso04 tbdHoso04) {
        this.tbdHoso04 = tbdHoso04;
    }

    public List<TbdDinhkemXinGh04> getLstDinhkemGh() {
        return lstDinhkemGh;
    }

    public void setLstDinhkemGh(List<TbdDinhkemXinGh04> lstDinhkemGh) {
        this.lstDinhkemGh = lstDinhkemGh;
    }

    public String getFiMaLoaiKiemtra() {
        return fiMaLoaiKiemtra;
    }

    public void setFiMaLoaiKiemtra(String fiMaLoaiKiemtra) {
        this.fiMaLoaiKiemtra = fiMaLoaiKiemtra;
    }
}