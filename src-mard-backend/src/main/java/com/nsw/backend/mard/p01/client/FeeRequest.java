package com.nsw.backend.mard.p01.client;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FeeRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiNSWFileCode;
    private Integer fiTypeFee;
    private Integer fiPaymentStatus;
    private String fiName;
    private String fiAccountNumber;
    private long fiTotalFee;
    private String fiTotalFeeText;
    private Date fiDatePayment;
    private String fiInvoiceNumber;
    private String fiNote;
    private String fiCreaterName;
    private Date fiFromDate;
    private Date fiToDate;

    private Attachment fiAttachment;
}
