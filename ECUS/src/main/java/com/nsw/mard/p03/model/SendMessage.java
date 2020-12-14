/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p03.model;

import com.nsw.mt.p61.model.BaseMessage;

import java.util.Date;
import java.util.List;

/**
 * @author HuongMK
 */

public class SendMessage extends BaseMessage {

    private String reason;
    private Date delayDateTo;
    private String getXmlNotSend;
    private String signedXml;
    private String fiSoGcn;
    private Date requestDate;
    private TbdHoSo03 tbdHoSo03;
    private TbdGcnKdspdv03 tbdGcnKdspdv03;
    private TbdGcnKiemdichDv03 tbdGcnKiemdichDv03;
    private String soContainer;
    private List<TbdHangHoa03> lstHanghoa;

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

    public String getFiSoGcn() {
        return fiSoGcn;
    }

    public void setFiSoGcn(String fiSoGcn) {
        this.fiSoGcn = fiSoGcn;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public TbdHoSo03 getTbdHoSo03() {
        return tbdHoSo03;
    }

    public void setTbdHoSo03(TbdHoSo03 tbdHoSo03) {
        this.tbdHoSo03 = tbdHoSo03;
    }

    public TbdGcnKdspdv03 getTbdGcnKdspdv03() {
        return tbdGcnKdspdv03;
    }

    public void setTbdGcnKdspdv03(TbdGcnKdspdv03 tbdGcnKdspdv03) {
        this.tbdGcnKdspdv03 = tbdGcnKdspdv03;
    }

    public TbdGcnKiemdichDv03 getTbdGcnKiemdichDv03() {
        return tbdGcnKiemdichDv03;
    }

    public void setTbdGcnKiemdichDv03(TbdGcnKiemdichDv03 tbdGcnKiemdichDv03) {
        this.tbdGcnKiemdichDv03 = tbdGcnKiemdichDv03;
    }

    public String getSoContainer() {
        return soContainer;
    }

    public void setSoContainer(String soContainer) {
        this.soContainer = soContainer;
    }

    public List<TbdHangHoa03> getLstHanghoa() {
        return lstHanghoa;
    }

    public void setLstHanghoa(List<TbdHangHoa03> lstHanghoa) {
        this.lstHanghoa = lstHanghoa;
    }
}
