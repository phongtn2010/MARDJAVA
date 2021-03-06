package com.nsw.backend.mard.p26.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Persistent class for entity stored in table "TBDLICHSU26"
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDLICHSU26", schema = "MARD")
public class TbdLichsu26 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDLICHSU26_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiIdHst;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_ID_PROC_UNIT")
    private Integer fiIdProcUnit; //Cơ quan xử lý

    @Column(name = "FI_SENDER_CODE", length = 50)
    private String fiSenderCode;

    @Column(name = "FI_SENDER_NAME")
    private String fiSenderName;

    @Column(name = "FI_SENDER_UNIT_CODE", length = 50)
    private String fiSenderUnitCode;

    @Column(name = "FI_SENDER_UNIT_NAME")
    private String fiSenderUnitName;

    @Column(name = "FI_RECEIVER_CODE", length = 50)
    private String fiReceiverCode;

    @Column(name = "FI_RECEIVER_NAME")
    private String fiReceiverName;

    @Column(name = "FI_RECEIVER_UNIT_CODE", length = 50)
    private String fiReceiverUnitCode;

    @Column(name = "FI_RECEIVER_UNIT_NAME")
    private String fiReceiverUnitName;

    @Column(name = "FI_CONTENT", length = 2000)
    private String fiContent;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_TIMELINE")
    private Date fiTimeline;

    @Column(name = "FI_STATUS")
    private Integer fiStatus;

    @Column(name = "FI_PROC_NAME")
    private String fiProcName;

    @Column(name = "FI_ID_HOSO")
    private Integer fiIdHS;

    @Column(name = "FI_HS_CODE", length = 50)
    private String fiHSCode;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TbdLichsu26() {
        super();
        this.fiSenderUnitName = "Cổng thông tin một cửa quốc gia";
        this.fiSenderUnitCode = "NSW";
    }
}
