package com.nsw.backend.mard.p09.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "TBDGIAYVC09", schema = "MARD")
public class Tbdgiayvc09 implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FI_ID_GIAY_VC", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDGIAYVC09_SEQ")
    @SequenceGenerator(sequenceName = "TBDGIAYVC09_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDGIAYVC09_SEQ")
    private Long fiIdTransportCer;

    @Column(name = "FI_NSW_CODE")
    private String fiNSWFileCode;

    @Column(name = "FI_CER_NO")
    private String fiCertificateNo;

    @Column(name = "FI_REG_NAME")
    private String fiNameOfRegistration;

    @Column(name = "FI_REG_ADDRESS", length = 500)
    private String fiAddressOfRegistration;

    @Column(name = "FI_IDENTITY_NO")
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

    @Column(name = "FI_TOTAL_QUANTITY_BY_TEXT")
    private String fiTotalQuantityOrVolumnByText;

    @Column(name = "FI_EXPORTER_NAME")
    private String fiNameOfExporter;

    @Column(name = "FI_EXPORTER_ADDRESS")
    private String fiAddressOfExporter;

    @Column(name = "FI_ORIGIN_EXPORT")
    private String fiOriginationExport;

    @Column(name = "FI_ORIGIN_TRANSIT")
    private String fiOriginationTransit;

    @Column(name = "FI_PORT_DEST_NAME")
    private String fiPortOfDestinationName;

    @Column(name = "FI_IMPORT_DATE")
    private Date fiImportDate;

    @Column(name = "FI_PORT_DEST_ADDRESS")
    private String fiPortOfDestinationAddress;

    @Column(name = "FI_OTHER_ITEMS")
    private String fiOtherItems;

    @Column(name = "FI_DOC_ATTACH")
    private String fiDocumentAttach;

    @Column(name = "FI_TRANSPORT_TYPE")
    private String fiTransportType;

    @Column(name = "FI_LICENSE_PLATE")
    private String fiLicensePlate;

    @Column(name = "FI_ANIMAL_ANTISEPTIC")
    private String fiAnimalOfAntiseptic;

    @Column(name = "FI_ANIMAL_CONCENTRATION")
    private String fiAnimalOfConcentration;

    @Column(name = "FI_TRAN_TYPE_ANTISEPTIC")
    private String fiTransportTypeOfAntiseptic;

    @Column(name = "FI_TRAN_TYPE_CONCENTRATION")
    private String fiTransportTypeOfConcentration;

    @Column(name = "FI_TRAN_DATE")
    private Date fiTransportDate;

    @Column(name = "FI_TRAN_PLACE")
    private String fiTransportPlace;

    @Column(name = "FI_TRAN_STREET")
    private String fiTransportStreet;

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
    private List<TbdGvcHh09> lstGood;

    public Tbdgiayvc09() {
        super();
        lstGood = new ArrayList<>();
    }

}
