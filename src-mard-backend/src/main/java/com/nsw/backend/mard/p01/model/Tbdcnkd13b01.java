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
@Table(name = "TBDCNKD13B01", schema = "MARD")
public class Tbdcnkd13b01 extends BaseCert01 implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDCNKD13B01_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    @Id
    @Column(name = "FI_ID_CNKD_13B", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdCNKD13B;

    @Column(name = "FI_NSW_FILE_CODE")
    private String fiNSWFileCode;

    @Column(name = "FI_ATTACHMENT_ID")
    private Long fiAttachmentID;
    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    @Column(name = "FI_HEALTH_CERTIFICATE_NO", length = 50)
    private String fiHealthCertificateNo;

    @Column(name = "FI_DEPARTMENT_PARENT_CODE", length = 50)
    private String fiDepartmentParentCode;

    @Column(name = "FI_DEPARTMENT_PARENT_NAME_VNI", length = 250)
    private String fiDepartmentParentNameVni;

    @Column(name = "FI_DEPARTMENT_PARENT_NAME", length = 250)
    private String fiDepartmentParentName;

    @Column(name = "FI_DEPARTMENT_CHILD_CODE", length = 50)
    private String fiDepartmentChildCode;

    @Column(name = "FI_DEPARTMENT_CHILD_NAME_VNI", length = 250)
    private String fiDepartmentChildNameVni;

    @Column(name = "FI_DEPARTMENT_CHILD_NAME", length = 250)
    private String fiDepartmentChildName;

    @Column(name = "FI_HEALTH_CERTIFICATE_FORM", length = 12)
    private String fiHealthCertificateForm;

    @Column(name = "FI_EXPORTER_NAME_VNI", length = 250)
    private String fiExporterNameVni;

    @Column(name = "FI_EXPORTER_NAME", length = 250)
    private String fiExporterName;

    @Column(name = "FI_EXPORTER_ADRESS_VNI", length = 250)
    private String fiExporterAdressVni;

    @Column(name = "FI_EXPORTER_ADRESS", length = 250)
    private String fiExporterAdress;

    @Column(name = "FI_EXPORTER_TEL", length = 50)
    private String fiExporterTel;

    @Column(name = "FI_EXPORTER_FAX", length = 50)
    private String fiExporterFax;

    @Column(name = "FI_EXPORTER_EMAIL", length = 250)
    private String fiExporterEmail;

    @Column(name = "FI_CONSIGNEE_NAME_ADDRESS_VNI", length = 500)
    private String fiConsigneeNameAddressVni;

    @Column(name = "FI_CONSIGNEE_NAME_ADDRESS", length = 500)
    private String fiConsigneeNameAddress;

    @Column(name = "FI_PROCESSING_NAME_ADDRESS_VNI", length = 500)
    private String fiProcessingNameAddressVni;

    @Column(name = "FI_PROCESSING_NAME_ADDRESS", length = 500)
    private String fiProcessingNameAddress;

    @Column(name = "FI_PROCESSING_TEL", length = 500)
    private String fiProcessingTel;

    @Column(name = "FI_PROCESSING_FAX", length = 500)
    private String fiProcessingFax;

    @Column(name = "FI_MEANS_TRANSPORT_VNI", length = 250)
    private String fiMeansTransportVni;

    @Column(name = "FI_MEANS_TRANSPORT", length = 250)
    private String fiMeansTransport;

    @Lob
    @Column(name = "FI_HEALTH_CERTIFICATE", length = 5000)
    private String fiHealthCertificate;

    @Lob
    @Column(name = "FI_HEALTH_CERTIFICATE_FILE")
    private String fiHealthCertificateFile;

    @Column(name = "FI_NOTE", length = 100)
    private String fiNote;

    @Column(name = "FI_EXPERT_NAME", length = 100)
    private String fiExpertName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_SIGN_RESULT_DATE")
    private Date fiSignResultDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_HEALTH_CERTIFICATE_END_DATE")
    private Date fiHealthCertificateEndDate;

    @Column(name = "FI_SIGN_RESULT_PLACE_VNI", length = 250)
    private String fiSignResultPlaceVni;

    @Column(name = "FI_SIGN_RESULT_PLACE", length = 250)
    private String fiSignResultPlace;

    @Column(name = "FI_SIGN_RESULT_NAME", length = 100)
    private String fiSignResultName;

    @Column(name = "FI_LINK_FILE")
    private String fiLinkFile;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_ANIMAL_PRODUCT_LIST")
    private List<Tbdspdv13b01> fiAnimalProductList;

    public Tbdcnkd13b01() {
        this.fiAnimalProductList = new ArrayList<>();
    }
}
