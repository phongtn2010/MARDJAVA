package com.nsw.backend.mard.p01.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "TBDCVKQFAIL01", schema = "MARD")
public class Tbdcvkqfail01 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDCVKQFAIL01_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    @Id
    @Column(name = "FI_ID_KQ_FAIL", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdKQFail;

    @Column(name = "FI_NSW_FILE_CODE")
    private String fiNSWFileCode;

    @Column(name = "FI_ATTACHMENT_ID")
    private Long fiAttachmentID;
    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    @Column(name = "FI_DISPATCH_CONTENT", length = 500)
    private String fiDispatchContent;

    @Column(name = "FI_FILE_NAME", length = 100)
    private String fiFileName;

    @Lob
    @Column(name = "FI_DISPATCH_FILE")
    private String fiDispatchFile;

    @Column(name = "FI_CREATER_NAME", length = 250)
    private String fiCreaterName;

    @Column(name = "FI_LINK_FILE", length = 1000)
    private String fiLinkFile;

    @Transient
    private boolean fileAvailable;
}
