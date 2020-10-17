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
@Table(name = "TBDCNKDM01", schema = "MARD")
public class TbdcnkdM01 extends BaseCert01 implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDCNKDM01_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    @Id
    @Column(name = "FI_ID_CNKD_M", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdCNKDM;

    @Column(name = "FI_NSW_FILE_CODE")
    private String fiNSWFileCode;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_HEALTH_CERTIFICATE_NO", length = 50)
    private String fiHealthCertificateNoVni;

    @Column(name = "FI_DEPARTMENT_CODE", length = 50)
    private String fiDepartmentCode;

    @Column(name = "FI_DEPARTMENT_NAME_VNI", length = 250)
    private String fiDepartmentNameVni;

    @Column(name = "FI_DEPARTMENT_NAME", length = 250)
    private String fiDepartmentName;

    @Column(name = "FI_CONSIGNER_NAME", length = 250)
    private String fiConsignerName;

    @Column(name = "FI_CONSIGNER_ADRESS", length = 250)
    private String fiConsignerAdress;

    @Column(name = "FI_CONSIGNEE_NAME_ADDRESS", length = 500)
    private String fiConsigneeNameAddress;

    @Column(name = "FI_SLAUGHTER_HOUSE_NAME_ADD", length = 500)
    private String fiSlaughterHouseNameAddress;

    @Lob
    @Column(name = "FI_HEALTH_CERTIFICATE")
    private String fiHealthCertificate;

    @Column(name = "FI_NOTE", length = 100)
    private String fiNote;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_SIGN_RESULT_DATE")
    private Date fiSignResultDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_HEALTH_CERTIFICATE_END_DATE")
    private Date fiHealthCertificateEndDate;

    @Column(name = "FI_SIGN_RESULT_NAME", length = 100)
    private String fiSignResultName;

    @Column(name = "FI_LINK_FILE")
    private String fiLinkFile;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_ANIMAL_PRODUCT_M")
    private List<TbdAnimailProductM01> fiAnimalProductList;

    public TbdcnkdM01() {
        this.fiAnimalProductList = new ArrayList<>();
    }
}
