package com.nsw.backend.mard.p09.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "TBDGIAYXNCL09", schema = "MARD")
public class Tbdgiayxncl09 implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FI_ID_GIAY_XNCL", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDGIAYXNCL09_SEQ")
    @SequenceGenerator(sequenceName = "TBDGIAYXNCL09_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDGIAYXNCL09_SEQ")
    private Long fiIdQualityCer;

    @Column(name = "FI_HS_ID")
    private Long fiIdHS;

    @Column(name = "FI_NSW_FILE_CODE")
    private String fiNSWFileCode;

    @Column(name = "FI_IS_NOTIFICATION")
    private long fiIsNotification;

    @Column(name = "FI_RES_CONF_NO")
    private String fiRegistrationComfirmNo;

    @Column(name = "FI_QUAN_CER_NO")
    private String fiQuanlityCerNo;

    @Column(name = "FI_DPM_CODE")
    private String fiDepartmentCode;

    @Column(name = "FI_DPM_NAME")
    private String fiDepartmentName;

    @Column(name = "FI_DPM_ADDRESS")
    private String fiDepartmentAddress;

    @Column(name = "FI_DPM_PHONE")
    private String fiDepartmentPhone;

    @Column(name = "FI_DPM_FAX")
    private String fiDepartmentFax;

    @Column(name = "FI_SELLER_STATE_CODE")
    private String fiSellerStateCode;

    @Column(name = "FI_SELLER_STATE_NAME")
    private String fiSellerStateName;

    @Column(name = "FI_SELLER_STATE_ADDRESS")
    private String fiSellerAddress;

    @Column(name = "FI_SELLER_STATE_PHONE")
    private String fiSellerPhone;

    @Column(name = "FI_SELLER_STATE_FAX")
    private String fiSellerFax;

    @Column(name = "FI_DPT_PORT_NAME")
    private String fiPortOfDepartureName;

    @Column(name = "FI_BUYER_NAME")
    private String fiBuyerName;

    @Column(name = "FI_BUYER_ADDRESS")
    private String fiBuyerAddress;

    @Column(name = "FI_BUYER_PHONE")
    private String fiBuyerPhone;

    @Column(name = "FI_BUYER_FAX")
    private String fiBuyerFax;

    @Column(name = "FI_DES_PORT_CODE")
    private String fiPortOfDestinationCode;

    @Column(name = "FI_DES_PORT_NAME")
    private String fiPortOfDestinationName;

    @Column(name = "FI_SIG_RESULT_DATE")
    private Date fiSignResultDate;

    @Column(name = "FI_SIG_RESULT_NAME")
    private String fiSignResultName;

    @Column(name = "FI_SIG_RESULT_ADDRESS")
    private String fiSignResultAddress;

    @Column(name = "FI_LINK_FILE", length = 1000)
    private String fiLinkFile;

    @Column(name = "FI_EDIT_STATUS")
    private Integer fiEditStatus;

    @Column(name = "FI_PARENT_DPT_NAME")
    private String fiParentDepartmentName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_CV_ID")
    private List<TbdXnclHh09> lstGood;
}