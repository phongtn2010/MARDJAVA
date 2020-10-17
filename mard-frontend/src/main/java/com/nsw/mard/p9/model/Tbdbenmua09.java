package com.nsw.mard.p9.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Tbdbenmua09 implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiIdBuyer;

    private Long fiIdHS;

    private String fiBuyerName;

    private String fiBuyerIdentityNo;

    private Date fiBuyerDateOfIdentity;

    private String fiBuyerPlaceOfIdentity;

    private String fiBuyerAddress;

    private Date fiImportingDateFrom;

    private Date fiImportingDateTo;

    private String fiBuyerTel;

    private String fiBuyerFax;

    private String fiPortOfDestinationCode;
    private String fiPortOfDestinationName;

    private String fiLadingBill;

    private Date fiLadingBillDate;
}
