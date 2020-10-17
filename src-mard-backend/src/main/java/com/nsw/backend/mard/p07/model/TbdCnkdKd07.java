package com.nsw.backend.mard.p07.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name = "TBDCNKDKD07", schema = "MARD")
public class TbdCnkdKd07 extends CmonBaseEntity implements Serializable {
    private static final String SEQUENCE_NAME = "TBDCNKDKD07_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "fi_NSW_File_Code")
    private String fiNSWFileCode;

    @Column(name = "FI_REASON", length = 1000)
    private String fiReason;

    @Column(name = "FI_SIGN_CONFIRM_NAME", length = 100)
    private String fiSignConfirmName;

    @Column(name = "FI_SIGN_CONFIRM_DATE")
    @Temporal(TemporalType.DATE)
    private Date fiSignConfirmDate;

    @Column(name = "FI_SIGN_CONFIRM_ADDRESS", length = 100)
    private String fiSignConfirmAddress;
}
