package com.nsw.backend.mard.p01.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "TBDDVXL01", schema = "MARD")
public class Tbddvxl01 implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDDVXL01_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_PU", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdPU;

    @Column(name = "FI_NSW_FILE_CODE")
    private String fiNSWFileCode;
    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    @Column(name = "FI_PU_CODE")
    private String fiPUCode;

    @Column(name = "FI_PU_DESC_Vni")
    private String fiPUDescVni;

    @Column(name = "FI_PU_DESC")
    private String fiPUDesc;

    @Column(name = "FI_PU_LEVEL")
    private Integer fiPULevel;

    @Column(name = "FI_PARENT_PU")
    private Long fiPUParentID;

    @Column(name = "FI_UNIT_SYMBOL")
    private String fiUnitSymbol;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_PARENT_PU")
    private List<Tbddvxl01> lstChildPU;

    public Tbddvxl01() {
        lstChildPU = new ArrayList<>();
    }

    public Tbddvxl01(String fiPUCode, String fiPUDescVni, String fiPUDesc, int fiPULevel) {
        this();
        this.fiPUCode = fiPUCode;
        this.fiPUDescVni = fiPUDescVni;
        this.fiPUDesc = fiPUDesc;
        this.fiPULevel = fiPULevel;
    }

}
