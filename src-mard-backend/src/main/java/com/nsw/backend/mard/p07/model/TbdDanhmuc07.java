package com.nsw.backend.mard.p07.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "TBDDANHMUC07", schema = "MARD")
public class TbdDanhmuc07 {
    private static final String SEQUENCE_NAME = "TBDDANHMUC07_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiId;

    @Column(name = "FI_TYPE")
    private String fiType;

    @Column(name = "FI_CODE")
    private String fiCode;

    @Column(name = "FI_NAME")
    private String fiName;

    public TbdDanhmuc07() {
    }

    public TbdDanhmuc07(String fiType, String fiCode, String fiName) {
        this.fiType = fiType;
        this.fiCode = fiCode;
        this.fiName = fiName;
    }
}
