package com.nsw.mard.p9.model;
import lombok.Data;

import java.util.Date;

@Data
public class Base09DTO {

    private Date fiCreatedDate;

    private String fiCreatedBy;

    private Date fiUpdatedDate;

    private String fiUpdatedBy;

    public Date getFiCreatedDate() {
        return fiCreatedDate;
    }

    public void setFiCreatedDate(Date fiCreatedDate) {
        this.fiCreatedDate = fiCreatedDate;
    }

    public String getFiCreatedBy() {
        return fiCreatedBy;
    }

    public void setFiCreatedBy(String fiCreatedBy) {
        this.fiCreatedBy = fiCreatedBy;
    }

    public Date getFiUpdatedDate() {
        return fiUpdatedDate;
    }

    public void setFiUpdatedDate(Date fiUpdatedDate) {
        this.fiUpdatedDate = fiUpdatedDate;
    }

    public String getFiUpdatedBy() {
        return fiUpdatedBy;
    }

    public void setFiUpdatedBy(String fiUpdatedBy) {
        this.fiUpdatedBy = fiUpdatedBy;
    }
}

