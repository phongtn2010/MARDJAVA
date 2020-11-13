package com.nsw.backend.dic.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class CmonBaseEntity {
    private static final String SYSTEM_USER = "NSW";
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_CREATED_DATE")
    private Date fiCreatedDate;

    @Column(name = "FI_CREATED_BY", length = 100)
    private String fiCreatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_UPDATED_DATE")
    private Date fiUpdatedDate;

    @Column(name = "FI_UPDATED_BY", length = 100)
    private String fiUpdatedBy;

    @PrePersist
    public void initCreatedFields() {
        if (fiCreatedDate == null) {
            fiCreatedDate = Calendar.getInstance().getTime();
        }
        if (fiCreatedBy == null) {
            fiCreatedBy = SYSTEM_USER;
            fiUpdatedBy = SYSTEM_USER;
        } else {
            fiUpdatedBy = fiCreatedBy;
        }
        fiUpdatedDate = Calendar.getInstance().getTime();
    }

    @PreUpdate
    public void updateFields() {
        fiUpdatedDate = Calendar.getInstance().getTime();
    }
}
