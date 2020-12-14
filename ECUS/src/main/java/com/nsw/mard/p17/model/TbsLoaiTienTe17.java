package com.nsw.mard.p17.model;

import java.io.Serializable;

public class TbsLoaiTienTe17 implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiId;

    private String fiMoneyUnitCode;

    private String fiMoneyUnitName;

    public Long getFiId() {
        return fiId;
    }

    public void setFiId(Long fiId) {
        this.fiId = fiId;
    }

    public String getFiMoneyUnitCode() {
        return fiMoneyUnitCode;
    }

    public void setFiMoneyUnitCode(String fiMoneyUnitCode) {
        this.fiMoneyUnitCode = fiMoneyUnitCode;
    }

    public String getFiMoneyUnitName() {
        return fiMoneyUnitName;
    }

    public void setFiMoneyUnitName(String fiMoneyUnitName) {
        this.fiMoneyUnitName = fiMoneyUnitName;
    }
    @Override
    public String toString() {
        return "TbsLoaiTienTe17{" +
                "fiId=" + fiId +
                ", fiMoneyUnitCode='" + fiMoneyUnitCode + '\'' +
                ", fiMoneyUnitName='" + fiMoneyUnitName + '\'' +
                '}';
    }
}
