package com.nsw.backend.mard.p07.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Persistent class for entity stored in table "TBDCVCNNV07" - Giấy chứng nhận vận chuyển
 *
 * @author Telosys Tools Generator
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name = "TBDCVCNVC07", schema = "MARD")
public class TbdCvCnvc07 extends CmonBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDCVCNVC07_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_CV", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiIdCV;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_NSW_FILE_CODE", length = 50)
    private String fiNSWFileCode;

    @Column(name = "FI_CERTIFICATE_NO", length = 50)
    private String fiCertificateNo;

    @Column(name = "FI_NAME_OF_REG", length = 100)
    private String fiNameOfRegistration;

    @Column(name = "FI_ADDRESS_OF_REG")
    private String fiAddressOfRegistration;

    @Column(name = "FI_PHONE_OF_REG", length = 50)
    private String fiPhoneOfRegistration;

    @Column(name = "FI_FAX_OF_REGISTRATION", length = 50)
    private String fiFaxOfRegistration;

    @Column(name = "fi_Email_Of_Reg", length = 100)
    private String fiEmailOfRegistration;

    @Column(name = "FI_TOTAL_QUA_OR_WEIGHT")
    private Double fiTotalQuantityOrWeight;

    @Column(name = "FI_TOTAL_UNIT_CODE", length = 18)
    private String fiTotalUnitCode;

    @Column(name = "FI_TOTAL_UNIT_NAME")
    private String fiTotalUnitName;

    @Column(name = "FI_PURPOSE_USE")
    private String fiPurposeUse;

    @Column(name = "FI_PACKAGE")
    private String fiPackage;

    @Column(name = "FI_QUANTITY_PACKAGE")
    private Integer fiQuantityPackage;

    @Column(name = "FI_NAME_OF_EXPORTER", length = 2000)
    private String fiNameOfExporter;

    @Column(name = "FI_ADDRESS_OF_EXPORTER", length = 2000)
    private String fiAddressOfExporter;

    @Column(name = "FI_NAME_OF_PRODUCE", length = 2000)
    private String fiNameOfProduce;

    @Column(name = "FI_ADDRESS_OF_PRODUCE", length = 2000)
    private String fiAddressOfProduce;

    @Column(name = "FI_ORIGINATION_EXPORT")
    private String fiOriginationExport;

    @Column(name = "FI_ORIGINATION_TRANSIT")
    private String fiOriginationTransit;

    @Column(name = "FI_PORT_OF_DES_CODE", length = 50)
    private String fiPortOfDestinationCode;

    @Column(name = "FI_PORT_OF_DES_NAME")
    private String fiPortOfDestinationName;

    @Column(name = "FI_IMPORT_DATE")
    @Temporal(TemporalType.DATE)
    private Date fiImportDate;

    @Column(name = "FI_DOCUMENT_ATTCH")
    private String fiDocumentAttch;

    @Column(name = "FI_HEALTH_SITUATION")
    private String fiHealthSituation;

    @Column(name = "FI_NAME_OF_ANTISEPTIC")
    private String fiNameOfAntiseptic;

    @Column(name = "FI_CON_OF_ANTISEPTIC")
    private String fiConcentrationOfAntiseptic;

    @Column(name = "FI_NAME_OF_TRANSFER")
    private String fiNameOfTransfer;

    @Column(name = "FI_ADDRESS_OF_TRANSFER")
    private String fiAddressOfTransfer;

    @Lob
    @Column(name = "FI_ROUTE_OF_TRANSFER", length = 1000)
    private String fiRouteOfTransfer;

    @Column(name = "FI_DEADLINE_OF_TRANSFER")
    @Temporal(TemporalType.DATE)
    private Date fiDeadlineOfTransfer;

    @Column(name = "FI_EXPIRE_DATE")
    @Temporal(TemporalType.DATE)
    private Date fiExpireDate;

    @Column(name = "FI_CREATER_NAME", length = 100)
    private String fiCreaterName;

    @Column(name = "FI_SIGN_CONFIRM_DATE")
    @Temporal(TemporalType.DATE)
    private Date fiSignConfirmDate;

    @Column(name = "FI_SIGN_CONFIRM_NAME", length = 100)
    private String fiSignConfirmName;

    @Column(name = "FI_SIGN_CONFIRM_TITLE", length = 100)
    private String fiSignConfirmTitle;

    @Column(name = "FI_SIGN_CONFIRM_ADDRESS", length = 100)
    private String fiSignConfirmAddress;

    @Column(name = "FI_DEPARTMENT_LISENCE_NAME", length = 100)
    private String fiDepartmentLisenceName;

    @Column(name = "FI_LINK_FILE", length = 1000)
    private String fiLinkFile;

    @Column(name = "FI_EDIT_STATUS")
    private Integer fiEditStatus;

    @Column(name = "FI_PARENT_DPT_NAME")
    private String fiParentDepartmentName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_CV_ID")
    private List<TbdCvCnvcHh07> fiGoodsList;

    public TbdCvCnvc07() {
        super();
        fiGoodsList = new ArrayList<>();
    }
}
