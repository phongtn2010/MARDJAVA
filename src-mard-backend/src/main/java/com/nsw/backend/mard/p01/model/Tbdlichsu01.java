package com.nsw.backend.mard.p01.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Persistent class for entity stored in table "TBDLICHSU01"
 */
@Entity
@Data
@Table(name = "TBDLICHSU01", schema = "MARD")
public class Tbdlichsu01 extends CmonBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDLICHSU01_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_HS_HST", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdHst;

    @Column(name = "FI_NSW_FILE_CODE")
    private String fiNSWFileCode;
    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_ID_PROC_UNIT")
    private Long fiIdProcUnit; //Cơ quan xử lý

    @Column(name = "FI_SENDER_CODE", length = 50)
    private String fiSenderCode;

    @Column(name = "FI_SENDER_NAME", length = 255)
    private String fiSenderName; // chuyen vien xu ly

    @Column(name = "FI_SENDER_UNIT_CODE", length = 50)
    private String fiSenderUnitCode;

    @Column(name = "FI_SENDER_UNIT_NAME", length = 255)
    private String fiSenderUnitName; // don vi xu ly

    @Column(name = "FI_RECEIVER_CODE", length = 50)
    private String fiReceiverCode;

    @Column(name = "FI_RECEIVER_NAME", length = 255)
    private String fiReceiverName;

    @Column(name = "FI_RECEIVER_UNIT_CODE", length = 50)
    private String fiReceiverUnitCode;

    @Column(name = "FI_RECEIVER_UNIT_NAME", length = 255)
    private String fiReceiverUnitName;

    @Lob
    @Column(name = "FI_CONTENT", length = 2000)
    private String fiContent;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_TIMELINE")
    private Date fiTimeline;

    @Column(name = "FI_STATUS")
    private Long fiStatus;

    @Column(name = "FI_PROC_NAME", length = 250)
    private String fiProcName;

    @Column(name = "FI_ID_HOSO")
    private Long fiIdHS;

    @Column(name = "FI_HS_CODE", length = 50)
    private String fiHSCode;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbdlichsu01() {
        super();
        this.fiSenderUnitName = "Cổng thông tin một cửa quốc gia";
        this.fiSenderUnitCode = "NSW";
    }
}
