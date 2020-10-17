package com.nsw.backend.mard.p09.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "TDBXNCHITIEU09", schema = "MARD")
public class TdbXnChitieu09 implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final String SEQUENCE_NAME = "TDBXNCHITIEU09_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_CT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdCT;

    @Column(name = "FI_ID_XND")
    private Long fiIdXND;

    @Column(name = "FI_ANALYTICAL_CODE", length = 12)
    private String fiAnanyticalCode;

    @Column(name = "FI_ANALYTICAL_NAME")
    private String fiAnanyticalName;

    @Column(name = "FI_REQUIRED", length = 500)
    private String fiRequired;

    public TdbXnChitieu09() {
    }

    public TdbXnChitieu09(String fiAnanyticalCode, String fiAnanyticalName, String fiRequired) {
        this.fiAnanyticalCode = fiAnanyticalCode;
        this.fiAnanyticalName = fiAnanyticalName;
        this.fiRequired = fiRequired;
    }
}