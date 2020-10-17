package com.nsw.backend.mard.p09.model;


import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Persistent class for entity stored in table "TBDLICHSU09"
 *
 * @author Telosys Tools Generator
 */
@Entity
@Table(name = "TBDLICHSU09", schema = "MARD")
@Data
// Define named queries here
@NamedQueries({
        @NamedQuery(name = "Tbdlichsu09.countAll", query = "SELECT COUNT(x) FROM Tbdlichsu09 x")
})
public class Tbdlichsu09 extends CmonBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_HS_HST", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDLICHSU09_SEQ")
    @SequenceGenerator(sequenceName = "TBDLICHSU09_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDLICHSU09_SEQ")
    private Long fiIdHst;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_ID_PROC_UNIT")
    private Long fiIdProcUnit; //Cơ quan xử lý

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

    @Lob
    @Column(name = "FI_CONTENT")
    private String fiContent;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_TIMELINE")
    private Date fiTimeline;

    @Column(name = "FI_STATUS")
    private Long fiStatus;

    @Column(name = "FI_PROC_NAME")
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
    public Tbdlichsu09() {
        super();
        this.fiSenderUnitName = "Cổng thông tin một cửa quốc gia";
        this.fiSenderUnitCode = "NSW";
    }

}
