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
@Table(name = "TBDTEST01", schema = "MARD")
public class TbdTest01 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDTEST01_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    @Id
    @Column(name = "FI_ID_HOSO", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdTEST;

    @Column(name = "FI_ACTIVE", nullable = false)
    private boolean fiActive;

    @Column(name = "FI_NSW_FILE_CODE")
    private String fiNSWFileCode;
    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_TEST_NAME", length = 100)
    private String fiTestName;

    @Column(name = "FI_TEST_NUMBER", length = 50)
    private String fiTestNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_TEST_DATE")
    private Date fiTestDate;
}
