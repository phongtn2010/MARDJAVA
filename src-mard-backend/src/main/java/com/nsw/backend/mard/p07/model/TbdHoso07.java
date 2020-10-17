package com.nsw.backend.mard.p07.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Persistent class for entity stored in table "TbdHoso07" - Hồ sơ Đăng ký
 *
 * @author Telosys Tools Generator
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name = "TBDHOSO07", schema = "MARD")
public class TbdHoso07 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHOSO07_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_HS", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiIdHS;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    //Thong tin ho so
    @Column(name = "FI_HS_CODE", length = 50)
    private String fiNSWFileCode;

    @Column(name = "FI_HS_TYPE", nullable = false)
    private Integer fiHSType = 1;

    @Column(name = "FI_HS_STATUS")
    private Integer fiHSStatus;

    @Column(name = "FI_GS_STATUS")
    private Integer fiGSStatus;

    @Column(name = "FI_KD_STATUS")
    private Integer fiKDStatus;

    @Column(name = "FI_PAYMENT_STATUS")
    private Integer fiPaymentStatus;

    @Column(name = "FI_ACTIVE_STATUS")
    private boolean fiActive = true;

    @Column(name = "FI_TAXCODE", length = 13)
    private String fiTaxCode;

    @Column(name = "FI_REGISTRATION_CONFIRM_NO", length = 50)
    private String fiRegistrationComfirmNo;

    @Column(name = "FI_DPT_MONITOR_CODE", length = 50)
    private String fiDepartmentofMonitorCode;

    @Column(name = "FI_DPT_MONITOR_NAME")
    private String fiDepartmentofMonitorName;

    @Column(name = "FI_DPT_QUARANTINE_CODE", length = 50)
    private String fiDepartmentofQuarantineCode;

    @Column(name = "FI_DPT_QUARANTINE_NAME")
    private String fiDepartmentofQuarantineName;

    @Column(name = "FI_DEPARTMENT_CODE", length = 15)
    private String fiDepartmentCode;

    @Column(name = "FI_DEPARTMENT_NAME")
    private String fiDepartmentName;

    @Column(name = "FI_DEPARTMENT_ADDRESS")
    private String fiDepartmentAddress;

    @Column(name = "FI_DEPARTMENT_PHONE", length = 15)
    private String fiDepartmentPhone;

    @Column(name = "FI_DEPARTMENT_FAX", length = 15)
    private String fiDepartmentFax;

    //Thông tin đăng ký
    @Column(name = "FI_NAME_OF_REGISTRATION", nullable = false, length = 250)
    private String fiNameOfRegistration;

    @Column(name = "FI_ADDR_OF_REGISTRATION", nullable = false, length = 500)
    private String fiAddressOfRegistration;

    @Column(name = "FI_REG_PHONE", nullable = false, length = 15)
    private String fiPhoneOfRegistration;

    @Column(name = "FI_REG_NUMBER", length = 15)
    private String fiNumberOfRegistration;

    @Column(name = "FI_REG_FAX", length = 15)
    private String fiFaxOfRegistration;

    @Column(name = "FI_REG_EMAIL", length = 250)
    private String fiEmailOfRegistration;

    @Column(name = "FI_IDENTITY_NUMBER", length = 13)
    private String fiIdentityNumber;

    @Column(name = "FI_IDENTITY_ISSUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fiIdentityIssueDate;

    @Column(name = "FI_IDENTITY_ISSUE_ADDRESS", length = 250)
    private String fiIdentityIssueAddress;

    @Column(name = "FI_REQUEST_OPTION", length = 20)
    private String fiRequestOption;

    @Column(name = "FI_OPTION_OTHER")
    private String fiOptionOther;

    @Lob
    @Column(name = "FI_EXPORTER", length = 2000)
    private String fiExporter;

    @Lob
    @Column(name = "FI_EXPORTER_COUNTRY_ADDRESS", length = 2000)
    private String fiExporterCountryAddress;

    @Lob
    @Column(name = "FI_PROCESSING_NAME", length = 2000)
    private String fiProcessingName;

    @Lob
    @Column(name = "FI_PROCESSING_ADDRESS", length = 2000)
    private String fiProcessingAddress;

    @Column(name = "FI_PACKAGE")
    private String fiPackage;

    @Column(name = "FI_CONTRACTS_NO")
    private String fiContractsNo;

    @Column(name = "FI_ORIGINATION_IMPORT")
    private String fiOriginationImport;

    @Column(name = "FI_ORIGINATION_TRANSIT")
    private String fiOriginationTransit;

    @Column(name = "FI_PORT_OF_DEPARTURE_NAME")
    private String fiPortOfDepartureName;

    @Column(name = "FI_PORT_OF_DESTINATION_NAME")
    private String fiPortOfDestinationName;

    //column có trong bản tin còn đây ko có
    @Column(name = "FI_PORT_OF_DESTINATION_CODE")
    private String fiPortOfDestinationCode;

    @Column(name = "FI_TRANSPORT_TYPE")
    private String fiTransportType;

    @Column(name = "FI_PURPOSE_USE")
    private String fiPurposeUse;

    @Column(name = "FI_LICENSE_NO")
    private String fiLicenseNo;

    @Column(name = "FI_LICENSE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fiLicenseDate;

    @Column(name = "FI_LOCATION_OF_GROW")
    private String fiLocationOfGrow;

    @Column(name = "FI_LOCATION_OF_QUARANTINE")
    private String fiLocationOfQuarantine;

    @Column(name = "FI_DATE_OF_QUARANTINE_FROM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fiDateOfQuarantineFrom;

    @Column(name = "FI_DATE_OF_QUARANTINE_TO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fiDateOfQuarantineTo;

    @Column(name = "FI_LOCATION_OF_MONITOR")
    private String fiLocationOfMonitor;

    @Column(name = "FI_DATE_OF_MONITOR_FROM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fiDateOfMonitorFrom;

    @Column(name = "FI_DATE_OF_MONITOR_TO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fiDateOfMonitorTo;

    @Column(name = "FI_QUANTITY_LICENSE")
    private Integer fiQuantityLicense;

    @Column(name = "FI_TRANSSHIPMENT_GOODS")
    private Integer fiTransshipmentGoods;

    @Column(name = "FI_BUSINESS_NUMBER_OF_REG")
    private String fiBusinessNumberofRegistration;

    @Column(name = "FI_NAME_OF_REPRESENT_REG")
    private String fiNameOfRepresentRegistration;

    @Column(name = "FI_TOTAL_OF_GOODS_WEIGHT")
    private Double fiTotalOfGoodsWeight;

    @Column(name = "FI_TOGW_UNIT_CODE")
    private String fiTotalOfGoodsWeightUnitCode;

    @Column(name = "FI_TOGW_UNIT_NAME")
    private String fiTotalOfGoodsWeightUnitName;

    @Column(name = "FI_NAME_OF_FISHING_SHIP")
    private String fiNameOfFishingShip;

    @Column(name = "FI_CODE_OF_FISHING_SHIP")
    private String fiCodeOfFishingShip;

    @Column(name = "FI_ORI_OF_FISHING_SHIP")
    private String fiOriginationOfFishingShip;

    @Column(name = "FI_NAME_OF_TRANSFER_SHIP")
    private String fiNameOfTransferShip;

    @Column(name = "fi_Code_Of_Transfer_Ship")
    private String fiCodeOfTransferShip;

    @Column(name = "FI_ORI_OF_TRANSFER_SHIP")
    private String fiOriginationOfTransferShip;

    @Column(name = "FI_NAME_OF_CONTAINER_SHIP")
    private String fiNameOfContainerShip;

    @Column(name = "FI_CODE_OF_CONTAINER_SHIP")
    private String fiCodeOfContainerShip;

    @Column(name = "FI_ORI_OF_CONTAINER_SHIP")
    private String fiOriginationOfContainerShip;

    @Column(name = "FI_LOADING_UNLOADING_TIME_FROM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fiLoadingUnLoadingTimeFrom;

    @Column(name = "FI_LOADING_UNLOADING_TIME_TO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fiLoadingUnLoadingTimeTo;

    @Column(name = "FI_LOADING_UNLOADING_PLACE")
    private String fiLoadingUnloadingPlace;

    @Column(name = "FI_NAME_OF_SHIP")
    private String fiNameOfShip;

    @Column(name = "FI_CODE_OF_SHIP")
    private String fiCodeOfShip;

    @Column(name = "FI_ORIGINATION_OF_SHIP")
    private String fiOriginationOfShip;

    @Column(name = "FI_DATE_OF_CATCH_FROM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fiDateOfCatchFrom;

    @Column(name = "FI_DATE_OF_CATCH_TO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fiDateOfCatchTo;

    @Column(name = "FI_LOCATION_OF_CATCH")
    private String fiLocationOfCatch;

    @Column(name = "FI_METHOD_CATCH")
    private String fiMethodCatch;

    @Column(name = "FI_SIGN_ADDRESS")
    private String fiSignAddress;

    @Column(name = "FI_SIGN_DATE")
    private Date fiSignDate;

    @Column(name = "FI_SIGN_NAME")
    private String fiSignName;

    @Column(name = "FI_SIGN_POSITION")
    private String fiSignPosition;

    @Column(name = "FI_MODIFY_REASON")
    private String fiModifyReason;

    @Column(name = "FI_ID_HS_PARENT")
    private Integer fiIdHSParent;

    @Column(name = "FI_FAIL_CNKD")
    private Integer fiFailCnkd;

    @Column(name = "FI_HAVE_TRANSPORT")
    private Integer fiHaveTransport;

    private Integer fiPendingCertEdit;

    @Column(name = "FI_QTY_PACKAGE")
    private Long fiQuantityPackage;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FI_ID_XND")
    private TbdXacnhan07 fiRegistrationConfirm;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<TbdHanghoa07> fiGoodsList;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<TbdDinhkem07> fiAttachmentList;

    @Transient
    private String fiCertNo;

    public TbdHoso07() {
        super();
        fiAttachmentList = new ArrayList<>();
    }

    public boolean isParallel() {
        return Objects.equals(this.getFiDepartmentofMonitorCode(), this.getFiDepartmentofQuarantineCode());
    }

}
