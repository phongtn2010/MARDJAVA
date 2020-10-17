package com.nsw.backend.mard.p09.dto.receive;

import lombok.Data;

import java.util.Date;

@Data
public class AnimalFeeConfirmation {
    private String fiNSWFileCode;
    private int fiTypeFee;
    private int fiPaymentStatus;
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
    private String fiFileName;
    private String fiFileByte;
}
