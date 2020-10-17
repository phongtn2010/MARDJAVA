package com.vnsw.ws.p16.model;

import javax.validation.constraints.NotNull;

public class SendMessage16 {
    private String fiReason;

    private String fiXml;

    private String fiTaxCode;

    private String fiUserName;

    private boolean fiSign;

    @NotNull
    private Long fiIdHoSo;

    @NotNull
    private Integer fiAction;

    public String getFiReason() {
        return fiReason;
    }

    public void setFiReason(String fiReason) {
        this.fiReason = fiReason;
    }

    public String getFiXml() {
        return fiXml;
    }

    public void setFiXml(String fiXml) {
        this.fiXml = fiXml;
    }

    public String getFiTaxCode() {
        return fiTaxCode;
    }

    public void setFiTaxCode(String fiTaxCode) {
        this.fiTaxCode = fiTaxCode;
    }

    public String getFiUserName() {
        return fiUserName;
    }

    public void setFiUserName(String fiUserName) {
        this.fiUserName = fiUserName;
    }

    public Long getFiIdHoSo() {
        return fiIdHoSo;
    }

    public void setFiIdHoSo(Long fiIdHoSo) {
        this.fiIdHoSo = fiIdHoSo;
    }

    public Integer getFiAction() {
        return fiAction;
    }

    public void setFiAction(Integer fiAction) {
        this.fiAction = fiAction;
    }

    public boolean isFiSign() {
        return fiSign;
    }

    public void setFiSign(boolean fiSign) {
        this.fiSign = fiSign;
    }

    @Override
    public String toString() {
        return "SendMessage16 [fiReason=" + fiReason + ", fiXml=" + fiXml + ", fiTaxCode=" + fiTaxCode + ", fiUserName=" + fiUserName + ", fiIdHoSo=" + fiIdHoSo + ", fiAction=" + fiAction + "]";
    }

}
