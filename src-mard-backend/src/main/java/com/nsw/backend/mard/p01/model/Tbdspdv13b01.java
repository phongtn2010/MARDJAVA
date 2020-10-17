package com.nsw.backend.mard.p01.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDSPDV13B01", schema = "MARD")
public class Tbdspdv13b01 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDSPDV13B01_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    @Id
    @Column(name = "FI_ID_SPDV_13B", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdSPDV13B;

    @Column(name = "FI_NSW_FILE_CODE")
    private String fiNSWFileCode;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    @Column(name = "FI_ID", length = 10)
    private String fiID;

    @Column(name = "FI_PRODUCT_NAME_VNI", length = 250)
    private String fiProductNameVni;

    @Column(name = "FI_PRODUCT_NAME", length = 250)
    private String fiProductName;

    @Column(name = "FI_PACKAGE_TYPE_VNI", length = 250)
    private String fiPackageTypeVni;

    @Column(name = "FI_PACKAGE_TYPE", length = 250)
    private String fiPackageType;

    @Column(name = "FI_NUMBER")
    private long fiNumber;

    @Column(name = "FI_UNIT_CODE", length = 5)
    private String fiUnitCode;

    @Column(name = "FI_UNIT_VNI", length = 50)
    private String fiUnitVni;

    @Column(name = "FI_UNIT", length = 50)
    private String fiUnit;

    @Column(name = "FI_NETWEIGHT")
    private float fiNetWeight;

    @Column(name = "FI_NET_WEIGHT_UNIT_NAME", length = 50)
    private String fiNetWeightUnitName;
}
