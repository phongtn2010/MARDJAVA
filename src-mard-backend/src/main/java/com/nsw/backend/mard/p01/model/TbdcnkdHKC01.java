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
@Table(name = "TBDCNKDHKC01", schema = "MARD")
public class TbdcnkdHKC01 extends BaseCert01 implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDCNKDHKC01_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    @Id
    @Column(name = "FI_ID_CNKD_HKC", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdCNKDHKC;

    @Column(name = "FI_ACTIVE", nullable = false)
    private boolean fiActive;

    @Column(name = "FI_NSW_FILE_CODE")
    private String fiNSWFileCode;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    @Column(name = "FI_HEALTH_CERTIFICATE_NO", length = 50)
    private String fiHealthCertificateNo;

    @Column(name = "FI_DEPARTMENT_CODE", length = 50)
    private String fiDepartmentCode;

    @Column(name = "FI_DEPARTMENT_NAME_VNI", length = 250)
    private String fiDepartmentNameVni;

    @Column(name = "FI_DEPARTMENT_NAME", length = 250)
    private String fiDepartmentName;

    @Column(name = "FI_EXPORT_NAME", length = 250)
    private String fiExportName;

    @Column(name = "FI_EXPORT_ADRESS", length = 250)
    private String fiExportAdress;

    @Column(name = "FI_EXPORTER_TEL", length = 50)
    private String fiExporterTel;

    @Column(name = "FI_EXPORTER_FAX", length = 50)
    private String fiExporterFax;

    @Column(name = "FI_EXPORTER_EMAIL", length = 250)
    private String fiExporterEmail;

    @Column(name = "FI_CONSIGNEE_NAME_ADDRESS", length = 500)
    private String fiConsigneeNameAddress;

    @Column(name = "FI_CONSIGNEE_TEL", length = 50)
    private String fiConsigneeTel;

    @Column(name = "FI_CONSIGNEE_FAX", length = 50)
    private String fiConsigneeFax;

    @Column(name = "FI_CONSIGNEE_EMAIL", length = 250)
    private String fiConsigneeEmail;

    @Column(name = "FI_SLAUGHTER_HOUSE_NAME_ADD", length = 500)
    private String fiSlaughterHouseNameAddress;


    @Column(name = "FI_SLAUGHTER_HOUSE_TEL", length = 50)
    private String fiSlaughterHouseTel;

    @Column(name = "FI_SLAUGHTER_HOUSE_FAX", length = 50)
    private String fiSlaughterHouseFax;

    @Column(name = "FI_PROCESSING_NAME_ADDRESS", length = 500)
    private String fiProcessingNameAddress;

    @Column(name = "FI_PROCESSING_TEL", length = 50)
    private String fiProcessingTel;

    @Column(name = "FI_PROCESSING_FAX", length = 50)
    private String fiProcessingFax;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_DATE_SLAUGHTER")
    private Date fiDateSlaughter;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_DATE_SPROCESSING")
    private Date fiDateSProcessing;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_DATE_HEAT_PROCESSING")
    private Date fiDateHeatProcessing;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_DATE_EXPIRY")
    private Date fiDateExpiry;

    @Column(name = "FI_PORT_SHIPMENT_CODE", length = 50)
    private String fiPortShipmentCode;

    @Column(name = "FI_PORT_SHIPMENT_NAME", length = 100)
    private String fiPortShipmentName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_DATE_DEPARTURE")
    private Date fiDateDeparture;

    @Column(name = "FI_MEANS_TRANSPORT_NAME", length = 250)
    private String fiMeansTransportName;

    @Column(name = "FI_ENTRY_POINT_CODE", length = 50)
    private String fiEntryPointCode;

    @Column(name = "FI_ENTRY_POINT_NAME", length = 250)
    private String fiEntryPointName;

    @Lob
    @Column(name = "FI_CONTAINE", length = 5000)
    private String fiContaine;

    @Lob
    @Column(name = "FI_HEALTH_CERTIFICATE")
    private String fiHealthCertificate;

    @Column(name = "FI_NOTE", length = 100)
    private String fiNote;

    @Column(name = "FI_EXPERT_NAME", length = 500)
    private String fiExpertName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_SIGN_RESULT_DATE")
    private Date fiSignResultDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_HEALTH_CERTIFICATE_END_DATE")
    private Date fiHealthCertificateEndDate;

    @Column(name = "FI_SIGN_RESULT_PLACE", length = 500)
    private String fiSignResultPlace;

    @Column(name = "FI_SIGN_RESULT_NAME", length = 100)
    private String fiSignResultName;

    @Column(name = "FI_LINK_FILE")
    private String fiLinkFile;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_ANIMAL_PRODUCT_HKC")
    private List<TbdAnimailProductHKC01> fiAnimalProductList;

    public TbdcnkdHKC01() {
        this.fiAnimalProductList = new ArrayList<>();
    }
}
