package com.nsw.mard.p14.model;

public class CmonUnit14 {

    private Long fiUnitID;

    private String fiUnitCode;

    private String fiUnitName;

    private Integer fiSystemID;

    private Integer fiUnitTypeID;

    public CmonUnit14() {
    }

    public CmonUnit14(Long fiUnitID, String fiUnitCode, String fiUnitName, Integer fiSystemID, Integer fiUnitTypeID) {
        this.fiUnitID = fiUnitID;
        this.fiUnitCode = fiUnitCode;
        this.fiUnitName = fiUnitName;
        this.fiSystemID = fiSystemID;
        this.fiUnitTypeID = fiUnitTypeID;
    }

    public Long getFiUnitID() {
        return fiUnitID;
    }

    public void setFiUnitID(Long fiUnitID) {
        this.fiUnitID = fiUnitID;
    }

    public String getFiUnitCode() {
        return fiUnitCode;
    }

    public void setFiUnitCode(String fiUnitCode) {
        this.fiUnitCode = fiUnitCode;
    }

    public String getFiUnitName() {
        return fiUnitName;
    }

    public void setFiUnitName(String fiUnitName) {
        this.fiUnitName = fiUnitName;
    }

    public Integer getFiSystemID() {
        return fiSystemID;
    }

    public void setFiSystemID(Integer fiSystemID) {
        this.fiSystemID = fiSystemID;
    }

    public Integer getFiUnitTypeID() {
        return fiUnitTypeID;
    }

    public void setFiUnitTypeID(Integer fiUnitTypeID) {
        this.fiUnitTypeID = fiUnitTypeID;
    }
}
