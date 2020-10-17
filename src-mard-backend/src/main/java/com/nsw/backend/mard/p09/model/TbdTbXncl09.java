package com.nsw.backend.mard.p09.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "TBDTBXNCL09", schema = "MARD")
public class TbdTbXncl09 implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final String SEQUENCE_NAME = "TBDTBXNCL09_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdTb;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    private String fiNSWFileCode;

    private Date fiRequestDate;
    private String fiQualityResult;
    private String fiDepartment;
    private String fiCreaterName;
    private String fiDescription;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_CV_ID")
    private List<TbdTbXnclHh09> fiGoodsList;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "FI_ID_CVXNKD")
    private List<TbdDkTbXncl09> fiAttachmentList;
}
