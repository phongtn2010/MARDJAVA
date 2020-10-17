package com.nsw.backend.mard.p01.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDDNXINSUACNKD01", schema = "MARD")
public class TbdDNXinSuaCNKD01 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDDINHKEM01_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    @Id
    @Column(name = "FI_ID_DN_SUA", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdDNSua;

    @Column(name = "FI_ACTIVE", nullable = false)
    private long fiActive;
    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    @Column(name = "FI_NSW_FILE_CODE", length = 500, nullable = false)
    private String fiNSWFileCode;

    @Column(name = "FI_REASON", length = 500, nullable = false)
    private String fiReason;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_REQUEST_DATE")
    private Date fiRequestDate;

    @Column(name = "FI_FILE_NAME", length = 100)
    private String fiFileName;

    @Lob
    @Column(name = "FI_FILE_ATTACK")
    private String fiFileAttack;
}
