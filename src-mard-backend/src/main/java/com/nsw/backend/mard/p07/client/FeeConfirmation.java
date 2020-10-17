package com.nsw.backend.mard.p07.client;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FeeConfirmation {
    String fiNSWFileCode;
    Integer fiTypeFee;

    String fiName;
    String fiAccountNumber;
    Double fiTotalFee;
    String fiTotalFeeText;
    Date fiDatePayment;
    String fiInvoiceNumber;
    String fiNote;
    String fiCreaterName;
    Date fiFromDate;
    Date fiToDate;

    List<FeeConfirmationAttachment> fiAttachmentList;
}
