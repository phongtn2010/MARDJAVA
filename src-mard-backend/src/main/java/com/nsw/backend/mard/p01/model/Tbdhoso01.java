package com.nsw.backend.mard.p01.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "TBDHOSO01", schema = "MARD")
public class Tbdhoso01 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDHOSO01_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    @Id
    @Column(name = "FI_ID_HOSO", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdHS;

    @Column(name = "FI_ACTIVE", nullable = false)
    private Boolean fiActive;

    @Column(name = "FI_ID_HS_PARENT")
    private Long fiIdHSParent;

    @Column(name = "FI_HS_STATUS")
    private Long fiHSStatus;

    @Column(name = "FI_PAYMENT_STATUS")
    private Long fiPaymentStatus;

    @Column(name = "FI_NSW_FILE_CODE")
    private String fiNSWFileCode;

    @Column(name = "FI_LICENSE_NO")
    private String fiLicenseNo;

    @Column(name = "FI_LICENSE_TYPE")
    private Integer fiLicenseType;

    @Column(name = "FI_CNKD_ID")
    private Long fiCNKDId;

    //Thong tin ca nhan, to chuc dang ky

    @Column(name = "FI_REGISTRATION_NO", length = 50)
    private String fiRegistrationNo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_REGISTRATION_DATE")
    private Date fiRegistrationDate;

    @Column(name = "FI_CHECK_PLACE", length = 2000)
    private String fiCheckPlace;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_CHECK_TIME")
    private Date fiCheckTime;

    @Column(name = "FI_CREATER_NAME", length = 250)
    private String fiCreaterName;

    @Column(name = "FI_DEAPARTMENT_CODE", length = 50, nullable = false)
    private String fiDepartmentCode;

    @Column(name = "FI_DEPARTMENT_NAME_VNI", length = 250, nullable = false)
    private String fiDepartmentNameVni;

    @Column(name = "FI_DEPARTMENT_NAME", length = 250, nullable = false)
    private String fiDepartmentName;

    @Column(name = "FI_TAX_CODE", length = 15, nullable = false)
    private String fiTaxCode;

    @Column(name = "FI_EXPORTER_NAME_VNI", length = 250, nullable = false)
    private String fiExporterNameVni;

    @Column(name = "FI_EXPORTER_NAME", length = 250, nullable = false)
    private String fiExporterName;

    @Column(name = "FI_EXPORTER_ADRESS_VNI", length = 250, nullable = false)
    private String fiExporterAdressVni;

    @Column(name = "FI_EXPORTER_ADRESS", length = 250, nullable = false)
    private String fiExporterAdress;

    @Column(name = "FI_IDENTITY_NUMBER", length = 13)
    private String fiIdentityNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_IDENTITY_ISSUE_DATE")
    private Date fiIdentityIssueDate;

    @Column(name = "FI_IDENTITY_ISSUE_ADRESS", length = 250)
    private String fiIdentityIssueAdress;

    @Column(name = "FI_EXPORTER_TEL", length = 50, nullable = false)
    private String fiExporterTel;

    @Column(name = "FI_EXPORTER_FAX", length = 50, nullable = false)
    private String fiExporterFax;

    @Column(name = "FI_EXPORTER_EMAIL", length = 250, nullable = false)
    private String fiExporterEmail;

    @Column(name = "FI_OBJECT_TYPE", nullable = false)
    private Integer fiObjectType;

    @Column(name = "FI_TOTAL_ANIMAL_BY_CHAR_VNI", length = 1000)
    private String fiTotalAnimalByCharVni;

    @Column(name = "FI_TOTAL_ANIMAL_BY_CHAR", length = 1000)
    private String fiTotalAnimalByChar;

    @Column(name = "FI_DEP_PLACE_OF_ANIMAL_VNI", length = 250)
    private String fiDeparturePlaceOfAnimalVni;

    @Column(name = "FI_DEPARTURE_PLACE_OF_ANIMAL", length = 250)
    private String fiDeparturePlaceOfAnimal;

    @Column(name = "FI_ANIMAL_HEALTH_STATUS")
    private String fiAnimalHealthStatus;

    @Column(name = "FI_DISEASE_SAFE_NAME", length = 255)
    private String fiDiseaseSafeName;

    @Column(name = "FI_DECISION_NO", length = 50)
    private String fiDecisionNo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_DECISION_DATE")
    private Date fiDecisionDate;

    @Column(name = "FI_DECISION_DEPARTMENT", length = 100)
    private String fiDecisionDepartment;

    @Column(name = "FI_TOTAL_ANIMAL_PR_BY_CHAR_VNI", length = 1000)
    private String fiTotalAnimalProductByCharVni;

    @Column(name = "FI_TOTAL_ANIMAL_PR_BY_CHAR", length = 1000)
    private String fiTotalAnimalProductByChar;

    @Column(name = "FI_ANIMAL_PRODUCT_TEST_NO", length = 250)
    private String fiAnimalProductTestNo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fiAnimalProductTestDate")
    private Date fiAnimalProductTestDate;

    @Column(name = "FI_ANIMAL_PR_TEST_DEPARTMENT", length = 250)
    private String fiAnimalProductTestDepartment;

    @Column(name = "FI_TEMPERATURE_PRODUCT_NAME")
    private Integer fiTemperatureProductName;

    @Column(name = "FI_PRO_NAME_ADDRESS_VNI", length = 500)
    private String fiProcessingNameAddressVni;

    @Column(name = "FI_PRO_NAME_ADDRESS", length = 500)
    private String fiProcessingNameAddress;

    @Column(name = "FI_PROCESSING_TEL", length = 50)
    private String fiProcessingTel;

    @Column(name = "FI_PROCESSING_FAX", length = 50)
    private String fiProcessingFax;

    @Column(name = "FI_PRO_NUMBER_REG", length = 15)
    private String fiProcessingNumberRegistration;

    @Column(name = "FI_SLA_HOUSE_NAME_ADD_VNI", length = 500)
    private String fiSlaughterHouseNameAddressVni;

    @Column(name = "FI_SLA_HOUSE_NAME_ADDRESS", length = 500)
    private String fiSlaughterHouseNameAddress;

    @Column(name = "FI_SLAUGHTER_HOUSE_TEL", length = 50)
    private String fiSlaughterHouseTel;

    @Column(name = "FI_SLAUGHTER_HOUSE_FAX", length = 50)
    private String fiSlaughterHouseFax;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_SLAUGHTER_HOUSE_DATE")
    private Date fiSlaughterHouseDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_PROCESSSING_DATE")
    private Date fiProcesssingDate;

    @Column(name = "FI_PORT_SHIPMENT_CODE", length = 50)
    private String fiPortShipmentCode;

    @Column(name = "FI_PORT_SHIPMENT_NAME_VNI", length = 100)
    private String fiPortShipmentNameVni;

    @Column(name = "FI_PORT_SHIPMENT_NAME", length = 100)
    private String fiPortShipmentName;

    @Column(name = "FI_IMPORTE_NAME_ADDRESS_VNI", length = 500, nullable = false)
    private String fiImporteNameAddressVni;

    @Column(name = "FI_IMPORTE_NAME_ADDRESS", length = 500, nullable = false)
    private String fiImporteNameAddress;

    @Column(name = "FI_IMPORTER_TEL", length = 50, nullable = false)
    private String fiImporterTel;

    @Column(name = "FI_IMPORTER_FAX", length = 50, nullable = false)
    private String fiImporterFax;

    @Column(name = "FI_IMPORTER_EMAIL", length = 250)
    private String fiImporterEmail;

    @Column(name = "FI_ENTRY_POINT_CODE", length = 50)
    private String fiEntryPointCode;

    @Column(name = "FI_ENTRY_POINT_NAME_VNI", length = 250)
    private String fiEntryPointNameVni;

    @Column(name = "FI_ENTRY_POINT_NAME", length = 250)
    private String fiEntryPointName;

    @Column(name = "FI_BORDER_GATE_CODE", length = 5)
    private String fiBorderGateCode;

    @Column(name = "FI_BORDER_GATE_NAME_VNI", length = 250)
    private String fiBordergateNameVni;

    @Column(name = "FI_BORDER_GATE_NAME", length = 250)
    private String fiBordergateName;

    @Column(name = "FI_MEANS_TRANSPORT_NAME_VNI", length = 250, nullable = false)
    private String fiMeansTransportNameVni;

    @Column(name = "FI_MEANS_TRANSPORT_NAME", length = 250, nullable = false)
    private String fiMeansTransportName;

    @Column(name = "FI_CONTAINE", length = 500)
    private String fiContaine;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_DEPARTURE_DATE_FROM")
    private Date fiDepartureDateFrom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_EXPECTING_DATE_FROM")
    private Date fiExpectingDateFrom;

    @Column(name = "FI_IMPORTER_COUNTRY_CODE", length = 50)
    private String fiImporterCountryCode;

    @Column(name = "FI_IMPORTER_COUNTRY_NAME_VNI", length = 150, nullable = false)
    private String fiImporterCountryNameVni;

    @Column(name = "FI_IMPORTER_COUNTRY_NAME", length = 150, nullable = false)
    private String fiImporterCountryName;

    @Column(name = "FI_TRANSIT_COUNTRY_CODE", length = 50)
    private String fiTransitCountryCode;

    @Column(name = "FI_TRANSIT_COUNTRY_NAME_VNI", length = 150)
    private String fiTransitCountryNameVni;

    @Column(name = "FI_TRANSIT_COUNTRY_NAME", length = 150)
    private String fiTransitCountryName;

    @Column(name = "FI_CONDITIONS_TRANSPORT", length = 250, nullable = false)
    private String fiConditionsTransport;

    @Column(name = "FI_OTHER_TRANSPORT", length = 500, nullable = false)
    private String fiOtherTransport;

    @Column(name = "FI_TRANSPORT_ATTRACH_FILE", length = 500, nullable = false)
    private String fiTransportAttrachFile;

    @Column(name = "FI_LOCATION_QUARANTINE_VNI", length = 250, nullable = false)
    private String fiLocationQuarantineVni;

    @Column(name = "FI_LOCATION_QUARANTINE", length = 250, nullable = false)
    private String fiLocationQuarantine;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_TIME_QUARANTINE", nullable = false)
    private Date fiTimeQuarantine;

    @Column(name = "FI_HEALTH_CERTIFICATE_CONTENT", length = 5000)
    private String fiHealthCertificateContent;

    @Column(name = "FI_SIGN_ADDRESS", length = 100, nullable = false)
    private String fiSignAddress;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_SIGN_DATE", nullable = false)
    private Date fiSignDate;

    @Column(name = "FI_SIGN_NAME", length = 100, nullable = false)
    private String fiSignName;

    // Dinh kem
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_ATTACHMENT_LIST")
    private List<Tbddinhkem01> fiAttachmentList;

    //Child-list
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_TEST_ID")
    private List<TbdTest01> fiTestList;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_ANIMAIL_ID")
    private List<TbdAnimailProduct01> fiAnimalProductList;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_VACCIN_ID")
    private List<TbdVaccin01> fiVaccinList;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_ANMAIL_LIST")
    private List<TbdAnimal01> fiAnimalList;

    public Tbdhoso01() {
        super();
        clearLst();
    }

    private void clearLst() {
        fiAnimalList = new ArrayList<>();
        fiVaccinList = new ArrayList<>();
        fiTestList = new ArrayList<>();
        fiAttachmentList = new ArrayList<>();
        fiAnimalProductList = new ArrayList<>();
    }

}
