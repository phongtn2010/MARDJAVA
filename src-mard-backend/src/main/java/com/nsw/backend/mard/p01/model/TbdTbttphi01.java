package com.nsw.backend.mard.p01.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import com.nsw.backend.mard.p01.client.FeeRequest;
import com.nsw.backend.mard.p01.dto.Attachment;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDTBTTPHI01", schema = "MARD")
public class TbdTbttphi01 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDTBTTPHI01_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    @Id
    @Column(name = "FI_ID_TBAP", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdTBAP;

    @Column(name = "FI_ACTIVE", nullable = false)
    private boolean fiActive;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_NSW_FILE_CODE", length = 50)
    private String fiNSWFileCode;

    @Column(name = "FI_TYPE_FEE")
    private Integer fiTypeFee;

    @Column(name = "FI_PAYMENT_STATUS")
    private Integer fiPaymentStatus;

    @Column(name = "FI_NAME", length = 100)
    private String fiName;

    @Column(name = "FI_ACCOUNT_NUMBER", length = 20)
    private String fiAccountNumber;

    @Column(name = "FI_TOTAL_FEE", length = 15)
    private long fiTotalFee;

    @Column(name = "FI_TOTAL_FEE_TEXT", length = 500)
    private String fiTotalFeeText;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_DATE_PAYMENT")
    private Date fiDatePayment;

    @Column(name = "FI_INVOICE_NUMBER", length = 50)
    private String fiInvoiceNumber;

    @Column(name = "FI_NOTE", length = 250)
    private String fiNote;

    @Column(name = "FI_CREATER_NAME", length = 250)
    private String fiCreaterName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_FROM_DATE")
    private Date fiFromDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_TO_DATE")
    private Date fiToDate;

    @Column(name = "FI_ATTACHMENT")
    private Attachment fiAttachment;

    public static TbdTbttphi01 parse(FeeRequest feeRequest) {
        TbdTbttphi01 fee = new TbdTbttphi01();
        BeanUtils.copyProperties(feeRequest, fee);
        return fee;
    }
}
