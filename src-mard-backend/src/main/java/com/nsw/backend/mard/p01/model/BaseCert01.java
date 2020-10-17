package com.nsw.backend.mard.p01.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class BaseCert01 extends CmonBaseEntity {
    @Column(name = "FI_IS_SYNC")
    private Long fiIsSync;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_SYNC_TIME")
    private Date fiSyncTime;

    public void markUnsync(){
        this.fiIsSync = 0L;
        this.fiSyncTime = null;
    }
}
