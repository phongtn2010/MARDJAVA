package com.nsw.mard.p16.model;

import javax.validation.constraints.Size;

public class TbsCountry16 {
    private Long fiId;

    private String fiCode;

    @Size(max = 2000)
    private String fiName;

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

    public String getFiName() {
        return fiName;
    }

    public void setFiName(String fiName) {
        this.fiName = fiName;
    }
}
