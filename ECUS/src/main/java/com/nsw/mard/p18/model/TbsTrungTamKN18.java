package com.nsw.mard.p18.model;

import java.io.Serializable;

public class TbsTrungTamKN18 implements Serializable {
    private Long fiId;
    private String fiCode;
    private String fiName;
    private String fiAdress;
    public Long getFiId() {
        return fiId;
    }

    public void setFiId(Long fiId) {
        this.fiId = fiId;
    }

    public String getFiCode() {
        return fiCode;
    }

    public void setFiCode(String fiCode) {
        this.fiCode = fiCode;
    }

    public String getFiAdress() {
        return fiAdress;
    }

    public void setFiAdress(String fiAdress) {
        this.fiAdress = fiAdress;
    }
    public String getFiName() {
        return fiName;
    }

    public void setFiName(String fiName) {
        this.fiName = fiName;
    }

    @Override
    public String toString() {
        return "TbsTrungTamKN18{" +
                "fiId=" + fiId +
                ", fiCode='" + fiCode + '\'' +
                ", fiName='" + fiName + '\'' +
                ", fiAdress='" + fiAdress + '\'' +
                '}';
    }
}
