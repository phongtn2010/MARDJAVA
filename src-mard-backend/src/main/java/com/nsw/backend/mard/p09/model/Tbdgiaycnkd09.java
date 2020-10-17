package com.nsw.backend.mard.p09.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "TBDGIAYCNKD09", schema = "MARD")
public class Tbdgiaycnkd09 implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FI_ID_GIAY_CNKD", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDGIAYCNKD09_SEQ")
    @SequenceGenerator(sequenceName = "TBDGIAYCNKD09_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDGIAYCNKD09_SEQ")
    private Long fiIdQuarantineCer;

    @Column(name = "FI_HS_ID")
    private Long fiIdHS;

    @Column(name = "FI_HS_CODE")
    private String fiNSWFileCode;

    @Column(name = "FI_CER_NO")
    private String fiCertificateNo;

    @Column(name = "FI_REG_NAME")
    private String fiNameOfRegistration;

    @Column(name = "FI_REG_ADDRESS", length = 500)
    private String fiAddressOfRegistration;

    @Column(name = "FI_IDEN_NO")
    private String fiIdentityNo;

    @Column(name = "FI_ISSUE_DATE")
    private Date fiIssueDate;

    @Column(name = "FI_ISSUE_PLACE")
    private String fiIssuePlace;

    @Column(name = "FI_REG_PHONE")
    private String fiPhoneOfRegistration;

    @Column(name = "FI_REG_FAX")
    private String fiFaxOfRegistration;

    @Column(name = "FI_REG_EMAIL")
    private String fiEmailOfRegistration;

    @Column(name = "FI_TOTAL_QUANTITY")
    private Double fiTotalQuantityOrVolumn;

    @Column(name = "FI_TOTAL_QUANTITY_TEXT", length = 500)
    private String fiTotalQuantityOrVolumnByText;

    @Column(name = "FI_EXPORTER_NAME")
    private String fiNameOfExporter;

    @Column(name = "FI_EXPORTER_ADDRESS")
    private String fiAddressOfExporter;

    @Column(name = "FI_PRODUCER_NAME", length = 2000)
    private String fiNameOfProduce;

    @Column(name = "FI_PRODUCER_NAME_ADDRESS", length = 2000)
    private String fiAddressOfProduce;

    @Column(name = "FI_ORIGI_EXPORT")
    private String fiOriginationExport;

    @Column(name = "FI_ORIGI_TRANSIT")
    private String fiOriginationTransit;

    @Column(name = "FI_DES_PORT_NAME")
    private String fiPortOfDestinationName;

    @Column(name = "FI_IMPORT_DATE")
    private Date fiImportDate;

    @Column(name = "FI_DES_PORT_ADD")
    private String fiPortOfDestinationAddress;

    @Column(name = "FI_OTHER_ITEMS")
    private String fiOtherItems;

    @Column(name = "FI_DOC_ATTCH")
    private String fiDocumentAttach;

    @Column(name = "FI_TRANS_TYPE")
    private String fiTransportType;

    @Column(name = "FI_ANIMAL_ANTISEPTIC")
    private String fiAnimalOfAntiseptic;

    @Column(name = "FI_ANIMAL_CONCENTRATION")
    private String fiAnimalOfConcentration;

    @Column(name = "FI_TRAN_TYPE_ANTISEPTIC")
    private String fiTransportTypeOfAntiseptic;

    @Column(name = "FI_TRAN_TYPE_CONCENTRATION")
    private String fiTransportTypeOfConcentration;

    @Column(name = "FI_EFFECTIVE_DATE")
    private Date fiEffectiveDate;

    @Column(name = "FI_CREATER_NAME")
    private String fiCreaterName;

    @Column(name = "FI_SIG_CONFIRM_DATE")
    private Date fiSignConfirmDate;

    @Column(name = "FI_SIG_CONFIRM_NAME")
    private String fiSignConfirmName;

    @Column(name = "FI_SIG_CONFIRM_ADD")
    private String fiSignConfirmAddress;

    @Column(name = "FI_DEP_LICENSE_NAME")
    private String fiDepartmentLicenseName;

    @Column(name = "FI_EDIT_STATUS")
    private Integer fiEditStatus;

    @Column(name = "FI_LINK_FILE", length = 1000)
    private String fiLinkFile;

    @Column(name = "FI_PARENT_DPT_NAME")
    private String fiParentDepartmentName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_CV_ID")
    private List<TbdCnkdHh09> lstGood;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_ID_GIAY_CNKD")
    private List<Tbdtiemphong09> lstImmunes;

    public Tbdgiaycnkd09() {
        super();
        lstGood = new ArrayList<>();
        lstImmunes = new ArrayList<>();
    }

}