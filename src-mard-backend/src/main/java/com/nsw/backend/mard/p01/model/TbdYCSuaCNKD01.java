package com.nsw.backend.mard.p01.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "TBDYCSUACNKD01", schema = "MARD")
public class TbdYCSuaCNKD01 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDYCSUACNKD01_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    @Id
    @Column(name = "FI_ID_Sua_CNKD", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdSuaCNKD;

    @Column(name = "FI_NSW_FILE_CODE")
    private String fiNSWFileCode;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_REQUEST_DATE")
    private Date fiRequestDate;

    @Column(name = "FI_FILE_NAME", length = 100)
    private String fiFileName;

    @Lob
    @Column(name = "FI_FILE_ATTACK", length = 5000)
    private String fiFileAttack;

    @Column(name = "FI_REASON", length = 500)
    private String fiReason;

}
