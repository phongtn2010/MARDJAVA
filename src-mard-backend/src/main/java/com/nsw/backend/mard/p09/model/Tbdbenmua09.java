package com.nsw.backend.mard.p09.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "TBDBENMUA09", schema = "MARD")
public class Tbdbenmua09 implements Serializable {
    private static final long serialVersionUID = 1L;
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_BUYER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDBENMUA09_SEQ")
    @SequenceGenerator(sequenceName = "TBDBENMUA09_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDBENMUA09_SEQ")
    private Long fiIdBuyer;

    @Column(name = "FI_BUYER_NAME", length = 250)
    private String fiBuyerName;

    @Column(name = "FI_BUYER_IDENTITY_NO", length = 50)
    private String fiBuyerIdentityNo;

    @Column(name = "FI_BUYER_IDENTITY_DATE")
    private Date fiBuyerDateOfIdentity;

    @Column(name = "FI_BUYER_IDENTITY_PLACE", length = 250)
    private String fiBuyerPlaceOfIdentity;

    @Column(name = "FI_BUYER_ADDRESS", length = 250)
    private String fiBuyerAddress;

    @Column(name = "FI_IMPORTING_DATE_FROM")
    private Date fiImportingDateFrom;

    @Column(name = "FI_IMPORTING_DATE_TO")
    private Date fiImportingDateTo;

    @Column(name = "FI_BUYER_TEL", length = 50)
    private String fiBuyerTel;

    @Column(name = "FI_BUYER_FAX", length = 50)
    private String fiBuyerFax;

    @Column(name = "FI_PORT_DEST_CODE", length = 15)
    private String fiPortOfDestinationCode;

    @Column(name = "FI_PORT_DEST_NAME", length = 500)
    private String fiPortOfDestinationName;

    @Column(name = "FI_LADING_BILL", length = 250)
    private String fiLadingBill;

    @Column(name = "FI_LADING_BILL_DATE")
    private Date fiLadingBillDate;
}
